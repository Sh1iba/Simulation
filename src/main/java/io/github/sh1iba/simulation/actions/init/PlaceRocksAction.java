package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Rock;

public class PlaceRocksAction extends PlaceEntityAction {
    private static final double ROCKS_DENSITY = 0.07;

    @Override
    protected Entity getEntity() {
        return new Rock();
    }

    @Override
    protected double getDensity() {
        return ROCKS_DENSITY;
    }
}
