package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.EntityConfig;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.actions.Action;
import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Grass;

public class AddGrassAction extends AddEntityAction {

    private static final double MIN_GRASS_DENSITY = 0.015;

    @Override
    protected Entity getEntity() {
        return new Grass();
    }

    @Override
    protected double getDensity() {
        return EntityConfig.getGrassDensity();
    }

    @Override
    protected double getMinDensity() {
        return MIN_GRASS_DENSITY;
    }

}
