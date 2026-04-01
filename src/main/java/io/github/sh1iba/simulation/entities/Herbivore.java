package main.java.io.github.sh1iba.simulation.entities;

/*
TODO Herbivore
   Травоядное, наследуется от Creature.
   Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы,
   либо на её поглощение.
 */

import main.java.io.github.sh1iba.simulation.search.BreadthFirstSearch;
import main.java.io.github.sh1iba.simulation.search.Search;

public class Herbivore extends Creature {
    private static final String SYMBOL = "\uD83D\uDC04";
    Search search = new BreadthFirstSearch();

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
