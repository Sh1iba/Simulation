package main.java.io.github.sh1iba.simulation.entities;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;

public class Predator extends Creature {

    private static final String SYMBOL = "\uD83D\uDC79";

    private final int attackPower;

    public Predator() {
        this.healthPoint = 100;
        this.speed = 6;
        this.attackPower = 25;
    }

    @Override
    public Class<? extends Entity> getTargetClass() {
        return Herbivore.class;
    }

    @Override
    public void interact(Coordinates coordinates, GameMap map) {
        attack(coordinates, map);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void attack(Coordinates coordinates, GameMap map) {
        if (getTargetClass().isInstance(map.getEntity(coordinates))) {
            Creature creature = (Creature) map.getEntity(coordinates);
            creature.healthPoint -= attackPower;
            if (creature.healthPoint == 0) {
                map.removeEntity(coordinates);
            }
        }
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
