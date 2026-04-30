package main.java.io.github.sh1iba.simulation.actions.init;

import main.java.io.github.sh1iba.simulation.EntityConfig;
import main.java.io.github.sh1iba.simulation.entities.Entity;
import main.java.io.github.sh1iba.simulation.entities.Tree;

public class PlaceTreesAction extends PlaceEntityAction {

    @Override
    protected Entity getEntity() {
        return new Tree();
    }

    @Override
    protected double getDensity() {
        return EntityConfig.getTreesDensity();
    }
}
