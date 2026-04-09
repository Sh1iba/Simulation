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
import main.java.io.github.sh1iba.simulation.entities.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private volatile boolean running = false;
    private final MapConsoleRenderer renderer = new MapConsoleRenderer();
    private final GameMap map = new GameMap(40, 15);
    private final List<Action> initActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();

    private void nextTurn() {
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
        // turnActions.add(new MovePredatorsAction());
    }

    private void init() {
        addInitActions();
        addTurnAction();
        for (Action action : initActions) {
            action.perform(map);
        }
    }

    public void startSimulation() {
        init();

            for (Action action : turnActions) {
                action.perform(map);
                System.out.println();
            }


    }

    public void pauseSimulation() {
        running = false;
    }

    public void stopSimulation() {
        running = false;
    }
}
