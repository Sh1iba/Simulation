package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Predator;

public class PlacePredatorsAction extends PlaceEntityAction {
    private static final double PREDATORS_DENSITY = 0.03;

    @Override
    protected Entity getEntity() {
        return new Predator();
    }

    @Override
    protected double getDensity() {
        return PREDATORS_DENSITY;
    }
}
