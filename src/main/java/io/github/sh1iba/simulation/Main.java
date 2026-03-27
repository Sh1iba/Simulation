package main.java.io.github.sh1iba.simulation;

public class Main {
    public static void main(String[] args) {
        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(new Map(24,10));
    }
}