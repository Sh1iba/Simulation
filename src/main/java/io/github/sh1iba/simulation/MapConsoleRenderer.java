package main.java.io.github.sh1iba.simulation;

public class MapConsoleRenderer {

    public void render(Map map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                System.out.print("| ");
            }
            System.out.printf("|%n");
        }
    }
}
