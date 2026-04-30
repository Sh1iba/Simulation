package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.EntityConfig;
import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Herbivore;

public class PlaceHerbivoresAction extends PlaceEntityAction {

    @Override
    protected Entity getEntity() {
        return new Herbivore();
    }

    @Override
    protected double getDensity() {
        return EntityConfig.getHerbivoresDensity();
    }

}
