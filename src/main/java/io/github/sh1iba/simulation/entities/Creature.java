package main.java.io.github.sh1iba.simulation.entities;


import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.search.BreadthFirstSearch;
import main.java.io.github.sh1iba.simulation.search.Search;

import java.util.List;

public abstract class Creature extends Entity {

    public int speed = 0;

    public int healthPoint = 0;

    private final Search search = new BreadthFirstSearch();

    public void makeMove(GameMap map, Coordinates coordinates) {
        int i = 0;
        Coordinates current = coordinates;
        while (i < getSpeed()) {
            List<Coordinates> pathToTarget = search.findPath(map, current, getTargetClass());
            if (pathToTarget.size() < 2) return;

            Coordinates next = pathToTarget.get(1);

            if (getTargetClass().isInstance(map.getEntity(next))) {
                interact(next, map);
                return;
            }

            map.removeEntity(current);
            if (map.getEntity(next) == null) {
                map.setEntity(next, this);
            }

            current = next;
            i++;

        }
    }

    abstract public Class<? extends Entity> getTargetClass();

    abstract public void interact(Coordinates coordinates, GameMap map);

    abstract public int getSpeed();

}
