package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Grass;

public class PlaceGrassAction extends PlaceEntityAction {

    private static final double GRASS_DENSITY = 0.07;

    @Override
    protected Entity getEntity() {
        return new Grass();
    }

    @Override
    protected double getDensity() {
        return GRASS_DENSITY;
    }

}
