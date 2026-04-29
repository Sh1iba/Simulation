package main.java.io.github.sh1iba.simulation;


import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.actions.init.*;
import main.java.io.github.sh1iba.simulation.actions.turn.MoveHerbivoresAction;
import main.java.io.github.sh1iba.simulation.actions.turn.MovePredatorsAction;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int counterOfMoves = 0;
    private static final String COUNTER_OF_MOVES_BANNER = """
            ╔══════════════════════════╗
            ║  🌿 Симуляция |  Ход %-3d ║
            ╚══════════════════════════╝
            """;
    private static final String SIMULATION_MENU_BANNER = """
            ╔═══════════════════════════════════════════════╗
            ║  Введите 'F' для остановки/запуска симуляции  ║
            ╚═══════════════════════════════════════════════╝
            """;
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final GameMap map = new GameMap(50, 20);
    private final List<Action> initActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();
    private boolean running = true;

    public Simulation() {
        addInitActions();
        addTurnAction();
        for (Action action : initActions) {
            action.perform(map);
        }
        print();
        launch();
    }

    public void startSimulation() {
        while (true) {
            synchronized (this) {
                while (!running) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
            System.out.println("сосать");
            nextTurn();
        }
    }

    public void launch() {
        var runnable = new InputRunnable(this);
        var thread = new Thread(runnable);
        //var thread = new Thread(this::pauseSimulation);
        thread.setDaemon(true);
        thread.start();
    }

    public void pauseSimulation(String str) {
        synchronized (this) {
            if (str.equals("F") || str.equals("f")) {
                running = !running;
                if (running) this.notifyAll();
            }
        }
    }

    private void nextTurn() {
        for (Action action : turnActions) {
            action.perform(map);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            print();
        }
    }

    private void print() {
        System.out.printf(COUNTER_OF_MOVES_BANNER, counterOfMoves++);
        System.out.println();
        renderer.render(map);
        System.out.println();
        System.out.print(SIMULATION_MENU_BANNER);
    }

    private void addInitActions() {
        initActions.add(new PlaceGrassAction());
        initActions.add(new PlaceHerbivoresAction());
        initActions.add(new PlacePredatorsAction());
        initActions.add(new PlaceRocksAction());
        initActions.add(new PlaceTreesAction());
    }

    private void addTurnAction() {
        turnActions.add(new MoveHerbivoresAction());
        turnActions.add(new MovePredatorsAction());
    }

}
