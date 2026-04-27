package main.java.io.github.sh1iba.simulation;

public class SimulationRunnable implements Runnable{

    private final Simulation simulation;

    public SimulationRunnable(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void run() {
        simulation.pauseSimulation();
    }

}
