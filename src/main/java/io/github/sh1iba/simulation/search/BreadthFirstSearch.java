package main.java.io.github.sh1iba.simulation.search;

import main.java.io.github.sh1iba.simulation.Coordinates;
import main.java.io.github.sh1iba.simulation.Map;
import main.java.io.github.sh1iba.simulation.entities.Entity;

import java.util.*;

//TODO написать метод который возвращает соседние координаты
//TODO метод который проверяет не попадут ли камни деревья или другие нежелательные сущности

public class BreadthFirstSearch implements Search {

    @Override
    public List<Coordinates> findPath(Map map, Coordinates start, Class<?> target) {
        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new LinkedList<>();


        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            if (isTarget(map, current, target)) {
                return visited;
            }

            for (Coordinates neighbour : getNeighboringCoordinates(map, current)){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }

        }

        return List.of();
    }

    private boolean isTarget(Map map, Coordinates coordinates, Class<?> target) {
        Entity entity = map.getEntity(coordinates);
        return target.isInstance(entity);
    }

    private boolean isValidCoordinate(Map map, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        return x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight();
    }

    //TODO понять не вышли ли мы за границы карты
    private List<Coordinates> getNeighboringCoordinates(Map map, Coordinates current) {
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
