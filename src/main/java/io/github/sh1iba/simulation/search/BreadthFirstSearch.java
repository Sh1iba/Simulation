package main.java.io.github.sh1iba.simulation.search;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.GameMap;
import main.java.io.github.sh1iba.simulation.entities.*;

import java.util.*;
import java.util.HashMap;

//TODO написать метод который возвращает соседние координаты
//TODO метод который проверяет не попадут ли камни деревья или другие нежелательные сущности

public class BreadthFirstSearch implements Search {

    private final Set<Coordinates> visited = new HashSet<>();
    private final Queue<Coordinates> queue = new LinkedList<>();
    private final Map<Coordinates, Coordinates> roadMap = new HashMap<>();

    @Override
    public List<Coordinates> findPath(GameMap map, Coordinates start, Class<?> target) {

        roadMap.put(start, null);
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            if (isTarget(map, current, target)) {
                return getPath(roadMap, start, current);
            }

            for (Coordinates neighbour : getNeighboringCoordinates(map, current)) {
                if (!visited.contains(neighbour) && isAvailableEntity(map, neighbour, target)) {
                    roadMap.put(neighbour, current);
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }

        }

        return new ArrayList<>();
    }

    private List<Coordinates> getPath(Map<Coordinates, Coordinates> roadMap, Coordinates start, Coordinates target) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = target;
        while (!current.equals(start)) {
            path.add(current);
            current = roadMap.get(current);
        }
        path.add(start);
        return path.reversed();
    }

    private boolean isAvailableEntity(GameMap map, Coordinates coordinates, Class<?> target) {
        Entity entity = map.getEntity(coordinates);
        if (entity instanceof Predator) return false;
        if (entity instanceof Rock) return false;
        if (entity instanceof Tree) return false;

        if (entity instanceof Herbivore) {
            return target == Herbivore.class;
        }

        return true;
    }

    private boolean isTarget(GameMap map, Coordinates coordinates, Class<?> target) {
        Entity entity = map.getEntity(coordinates);
        return target.isInstance(entity);
    }

    private boolean isValidCoordinate(GameMap map, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        return x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight();
    }

    //TODO понять не вышли ли мы за границы карты
    private List<Coordinates> getNeighboringCoordinates(GameMap map, Coordinates current) {
        List<Coordinates> neighboringCoordinates = new ArrayList<>();
        int x = current.getX();
        int y = current.getY();

        if (isValidCoordinate(map, new Coordinates(x, y + 1))) {
            neighboringCoordinates.add(new Coordinates(x, y + 1));
        }
        if (isValidCoordinate(map, new Coordinates(x, y - 1))) {
            neighboringCoordinates.add(new Coordinates(x, y - 1));
        }
        if (isValidCoordinate(map, new Coordinates(x + 1, y))) {
            neighboringCoordinates.add(new Coordinates(x + 1, y));
        }
        if (isValidCoordinate(map, new Coordinates(x - 1, y))) {
            neighboringCoordinates.add(new Coordinates(x - 1, y));
        }
        return neighboringCoordinates;
    }


}
