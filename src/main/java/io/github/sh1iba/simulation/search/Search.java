package main.java.io.github.sh1iba.simulation.search;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.List;

public interface Search {
    List<Coordinates> findPath(GameMap map, Coordinates start, Class<? extends Entity> target);
}
