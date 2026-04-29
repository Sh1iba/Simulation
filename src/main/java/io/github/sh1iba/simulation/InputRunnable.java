package main.java.io.github.sh1iba.simulation;

import java.util.Scanner;

public class InputRunnable implements Runnable{

    private final Simulation simulation;
    private final Scanner scanner;

    public InputRunnable(Simulation simulation) {
        this.simulation = simulation;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true){
            String str = scanner.nextLine();
            simulation.pauseSimulation(str);
        }
    }
}
