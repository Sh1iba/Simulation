package main.java.io.github.sh1iba.simulation.actions.turn;

import main.java.io.github.sh1iba.simulation.entities.Creature;
import main.java.io.github.sh1iba.simulation.entities.Predator;

public class MovePredatorsAction extends MoveEntityAction {
    @Override
    protected Class<? extends Creature> getEntityClass() {
        return Predator.class;
    }
}
