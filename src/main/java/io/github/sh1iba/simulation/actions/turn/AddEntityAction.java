package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.Random;

public abstract class AddEntityAction implements Action {

    private final Random random = new Random();

    protected abstract Entity getEntity();

    protected abstract double getDensity();

    protected abstract double getMinDensity();

    @Override
    public void perform(GameMap map) {
        int entityCount = getEntitiesCountOnMap(map);
        if (entityCount <= getMinEntitiesCount(map)) {
            int entitiesCountToPlace = getEntitiesCountToPlace(map);

            while (entitiesCountToPlace > 0) {
                Coordinates coordinates = getRandomCoordinates(map);
                if (map.isSquareEmpty(coordinates)) {
                    map.setEntity(coordinates, getEntity());
                    entitiesCountToPlace--;
                }
            }
        }
    }

    private Coordinates getRandomCoordinates(GameMap map) {
        int x = random.nextInt(map.getWidth());
        int y = random.nextInt(map.getHeight());
        return new Coordinates(x, y);
    }

    private int getEntitiesCountToPlace(GameMap map) {
        return (int) (map.getHeight() * map.getWidth() * (getDensity() - getMinDensity()));
    }

    private int getMinEntitiesCount(GameMap map) {
        return (int) (map.getHeight() * map.getWidth() * getMinDensity());
    }

    private int getEntitiesCountOnMap(GameMap map) {
        Entity entity = getEntity();
        int entityCount = 0;
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (entity.getClass().isInstance(map.getEntity(new Coordinates(j, i)))) {
                    entityCount++;
                }
            }
        }
        return entityCount;
    }

}
