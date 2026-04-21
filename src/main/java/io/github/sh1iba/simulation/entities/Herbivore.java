package main.java.io.github.sh1iba.simulation.entities;


import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;

public class Herbivore extends Creature {
    private static final String SYMBOL = "\uD83D\uDC04";

    public Herbivore() {
        this.healthPoint = 75;
        this.speed = 4;
    }

    @Override
    public Class<? extends Entity> getTargetClass() {
        return Grass.class;
    }

    @Override
    public void interact(Coordinates coordinates, GameMap map) {
        eat(coordinates, map);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void eat(Coordinates coordinates, GameMap map) {
        if (getTargetClass().isInstance(map.getEntity(coordinates))) {
            map.removeEntity(coordinates);
        }
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
