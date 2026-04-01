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

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final int counterOfMoves = 0;
    MapConsoleRenderer renderer = new MapConsoleRenderer();
    GameMap map = new GameMap(40, 15);
    List<Action> initActions = new ArrayList<>();
    List<Action> turnActions = new ArrayList<>();

    private void nextTurn() {

    }

    private void addInitActions() {
        initActions.add(new PlaceGrassAction());
        initActions.add(new PlaceHerbivoresAction());
        initActions.add(new PlacePredatorsAction());
        initActions.add(new PlaceRocksAction());
        initActions.add(new PlaceTreesAction());
    }

    private void init() {
        addInitActions();
        for (Action action : initActions) {
            action.perform(map);
        }

    }

    public void startSimulation() {
        init();
        renderer.render(map);
    }

    public void pauseSimulation() {

    }
}
