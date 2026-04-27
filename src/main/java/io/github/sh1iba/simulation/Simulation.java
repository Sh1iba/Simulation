package main.java.io.github.sh1iba.simulation;

/*
TODO Simulation
   Главный класс приложения, включает в себя:
    Карту
    Счётчик ходов
    Рендерер поля
    Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)
    /
    Методы:
    nextTurn() - просимулировать и отрендерить один ход
    startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга
 */

import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.actions.init.*;
import main.java.io.github.sh1iba.simulation.actions.turn.MoveHerbivoresAction;
import main.java.io.github.sh1iba.simulation.actions.turn.MovePredatorsAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private final Scanner scanner = new Scanner(System.in);
    private static volatile boolean running = false;

    public Simulation() {
        addInitActions();
        addTurnAction();
        for (Action action : initActions) {
            action.perform(map);
        }
        printSimulation();
        launch();
    }

    public void startSimulation() {
        running = true;
        while (true) {
            if (running) {
                nextTurn();
            }
        }
    }

    public void launch(){
        var runnable = new SimulationRunnable(this);
        var thread = new Thread(runnable);
        //var thread = new Thread(this::pauseSimulation);
        thread.start();
    }

    public void pauseSimulation() {
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("F") || str.equals("f")) {
                running = !running;
            }
        }
    }

    private void nextTurn() {
        for (Action action : turnActions) {
            action.perform(map);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printSimulation();
        }
    }

    private void printSimulation() {
        System.out.printf(COUNTER_OF_MOVES_BANNER, counterOfMoves++);
        System.out.println();
        renderer.render(map);
        System.out.println();
        System.out.println(SIMULATION_MENU_BANNER);
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
