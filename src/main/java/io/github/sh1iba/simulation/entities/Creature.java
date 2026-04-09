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
        List<Coordinates> pathToTarget = search.findPath(map, coordinates, getTargetClass());
        if (pathToTarget.size() < 2) return;
        int i = 1;
        Coordinates old = coordinates;
        while (i <= getSpeed()) {
            if (getTargetClass().isInstance(map.getEntity(pathToTarget.get(i)))) {
                interact(pathToTarget.get(i));
                return;
            }
            map.removeEntity(old);
            Coordinates current = pathToTarget.get(i);
            if (map.getEntity(current) == null) {
                map.setEntity(current, this);
            }
            i++;
            old = current;
        }
    }

    abstract public Class<? extends Entity> getTargetClass();

    abstract public void interact(Coordinates coordinates);

    abstract public int getSpeed();

}
