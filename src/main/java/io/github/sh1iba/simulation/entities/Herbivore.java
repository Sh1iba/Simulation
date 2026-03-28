package main.java.io.github.sh1iba.simulation.entities;

/*
TODO Herbivore
   Травоядное, наследуется от Creature.
   Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы,
   либо на её поглощение.
 */

public class Herbivore extends Creature {
    public static final String SYMBOL = "\uD83D\uDC04";
    @Override
    public void makeMove() {
        super.makeMove();
    }

    public void eat() {

    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
