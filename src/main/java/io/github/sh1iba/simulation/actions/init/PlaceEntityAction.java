package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.Map;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Entity;
import java.util.Random;

public abstract class PlaceEntityAction implements Action {

    private final Random random = new Random();

    protected abstract Entity getEntity();

    protected abstract double getDensity();

    @Override
    public void perform(Map map) {
        int entitiesToPlace = getEntitiesToPlace(map);

        while (entitiesToPlace > 0) {
            Coordinates coordinates = getRandomCoordinates(map);
            if (map.isSquareEmpty(coordinates)) {
                map.setEntity(coordinates, getEntity());
                entitiesToPlace--;
            }
        }
    }

    private Coordinates getRandomCoordinates(Map map) {
        int x = random.nextInt(map.getWidth());
        int y = random.nextInt(map.getHeight());
        return new Coordinates(x, y);
    }

    private int getEntitiesToPlace(Map map) {
        return (int) (map.getHeight() * map.getWidth() * getDensity());
    }

}
