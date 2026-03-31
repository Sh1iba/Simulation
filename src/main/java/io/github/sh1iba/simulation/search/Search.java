package main.java.io.github.sh1iba.simulation.search;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.Map;

import java.util.List;

public interface Search {
    List<Coordinates> findPath(Map map, Coordinates start, Class<?> target);
}
