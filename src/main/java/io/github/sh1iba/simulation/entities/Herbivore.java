package main.java.io.github.sh1iba.simulation.entities;


import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;

public class Herbivore extends Creature {
    private static final String SYMBOL = "\uD83D\uDC04";
    private static final int MAX_HEALTH_POINT = 75;

    public Herbivore() {
        this.healthPoint = MAX_HEALTH_POINT;
        this.speed = 1;
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
            if (healthPoint < MAX_HEALTH_POINT) {
                recoverHp();
            }

        }
    }

    private void recoverHp() {
        int nutritionValue = Grass.getNutritionValue();
        healthPoint = Math.min(healthPoint + nutritionValue, MAX_HEALTH_POINT);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
