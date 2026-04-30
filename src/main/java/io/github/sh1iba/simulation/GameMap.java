package main.java.io.github.sh1iba.simulation;

import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.HashMap;

public class GameMap {

    private final int width;
    private final int height;

    private final HashMap<Coordinates, Entity> map = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
