package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.EntityConfig;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Herbivore;

public class AddHerbivoresAction extends AddEntityAction {

    private static final double MIN_HERBIVORES_DENSITY = 0.01;

    @Override
    protected Entity getEntity() {
        return new Herbivore();
    }

    @Override
    protected double getDensity() {
        return EntityConfig.getHerbivoresDensity();
    }

    @Override
    protected double getMinDensity() {
        return MIN_HERBIVORES_DENSITY;
    }
}
