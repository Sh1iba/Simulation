package main.java.io.github.sh1iba.simulation;

public class EntityConfig {

    private static final double GRASS_DENSITY = 0.07;
    private static final double HERBIVORES_DENSITY = 0.05;
    private static final double PREDATORS_DENSITY = 0.01;
    private static final double ROCKS_DENSITY = 0.06;
    private static final double TREES_DENSITY = 0.09;

    public static double getGrassDensity() {
        return GRASS_DENSITY;
    }

    public static double getHerbivoresDensity() {
        return HERBIVORES_DENSITY;
    }

    public static double getPredatorsDensity() {
        return PREDATORS_DENSITY;
    }

    public static double getRocksDensity() {
        return ROCKS_DENSITY;
    }

    public static double getTreesDensity() {
        return TREES_DENSITY;
    }
}
