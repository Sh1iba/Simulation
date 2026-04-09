package main.java.io.github.sh1iba.simulation.entities;


import main.java.io.github.sh1iba.simulation.Coordinates;

public class Herbivore extends Creature {
    private static final String SYMBOL = "\uD83D\uDC04";

    public Herbivore() {
        this.healthPoint = 75;
        this.speed = 2;
    }

    @Override
    public Class<? extends Entity> getTargetClass() {
        return Grass.class;
    }

    @Override
    public void interact(Coordinates coordinates) {
        eat();
    }


    @Override
    public int getSpeed() {
        return speed;
    }

    public void eat() {

    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
