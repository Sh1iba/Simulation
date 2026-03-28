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
    MapConsoleRenderer renderer = new MapConsoleRenderer();
    Map map = new Map(40, 15);
    List<Action> initActions = new ArrayList<>();

    private void nextTurn() {

    }

    private void init() {

    }

    public void startSimulation() {
        PlaceEntityAction action = new PlaceGrassAction();
        action.perform(map);
        action = new PlaceHerbivoresAction();
        action.perform(map);
        action = new PlacePredatorsAction();
        action.perform(map);
        action = new PlaceRocksAction();
        action.perform(map);
        action = new PlaceTreesAction();
        action.perform(map);
        renderer.render(map);
    }

    public void pauseSimulation() {

    }
}
