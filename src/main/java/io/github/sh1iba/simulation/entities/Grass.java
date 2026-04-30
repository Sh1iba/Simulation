package main.java.io.github.sh1iba.simulation.entities;

public class Grass extends Entity {
    private static final String SYMBOL = "\uD83C\uDF3F";
    private static final int NUTRITION_VALUE = 10;

    public static int getNutritionValue() {
        return NUTRITION_VALUE;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
