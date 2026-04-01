package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.Random;

public abstract class PlaceEntityAction implements Action {

    private final Random random = new Random();

    protected abstract Entity getEntity();

    protected abstract double getDensity();

    @Override
    public void perform(GameMap map) {
        int entitiesCountToPlace = getEntitiesCountToPlace(map);

        while (entitiesCountToPlace > 0) {
            Coordinates coordinates = getRandomCoordinates(map);
            if (map.isSquareEmpty(coordinates)) {
                map.setEntity(coordinates, getEntity());
                entitiesCountToPlace--;
            }
        }
    }

    private Coordinates getRandomCoordinates(GameMap map) {
        int x = random.nextInt(map.getWidth());
        int y = random.nextInt(map.getHeight());
        return new Coordinates(x, y);
    }

    private int getEntitiesCountToPlace(GameMap map) {
        return (int) (map.getHeight() * map.getWidth() * getDensity());
    }

}
