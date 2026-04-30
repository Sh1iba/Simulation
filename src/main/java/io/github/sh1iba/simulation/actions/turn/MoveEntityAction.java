package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Creature;
import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public abstract class MoveEntityAction implements Action {

    protected abstract Class<? extends Creature> getEntityClass();

    @Override
    public void perform(GameMap map) {
        Map<Coordinates, Creature> creaturesBeforeMove = new HashMap<>();

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Coordinates coordinates = new Coordinates(j, i);
                Entity entity = map.getEntity(coordinates);
                if (getEntityClass().isInstance(entity)) {
                    creaturesBeforeMove.put(coordinates, (Creature) entity);
                }
            }
        }

        for (Coordinates coordinates : creaturesBeforeMove.keySet()) {
            creaturesBeforeMove.get(coordinates).makeMove(map, coordinates);
        }
    }
}
