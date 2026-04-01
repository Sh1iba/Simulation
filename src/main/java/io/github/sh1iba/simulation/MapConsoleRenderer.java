package main.java.io.github.sh1iba.simulation;

import main.java.io.github.sh1iba.simulation.entities.Entity;

public class MapConsoleRenderer {

    public static final String EMPTY_CELL_CONTENT = "⬛";

    public void render(GameMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Entity entity = map.getEntity(new Coordinates(j, i));
                if (entity != null) {
                    System.out.print(entity.getSymbol());
                    continue;
                }
                System.out.printf("%s",EMPTY_CELL_CONTENT);
            }
            System.out.println();
        }
    }

}
