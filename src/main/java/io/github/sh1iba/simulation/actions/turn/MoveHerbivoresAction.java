package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.entities.Creature;
import main.java.io.github.sh1iba.simulation.entities.Herbivore;

public class MoveHerbivoresAction extends MoveEntityAction {

    @Override
    protected Class<? extends Creature> getEntityClass() {
        return Herbivore.class;
    }
}
