package main.java.io.github.sh1iba.simulation;

/*
TODO Map
   Карта, содержит в себе коллекцию для хранения существ и их расположения.
   Советую не спешить использовать двумерный массив или список списков,
   а подумать какие ещё коллекции могут подойти.
 */

import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.HashMap;

public class GameMap {

    private final int width;
    private final int height;

    HashMap<Coordinates,Entity> map = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public void setEntity(Coordinates coordinates, Entity entity){
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return map.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates){
        map.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !map.containsKey(coordinates);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
