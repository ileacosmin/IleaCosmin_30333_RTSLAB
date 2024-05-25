package LabSession4.Lab5.App4;

import java.util.concurrent.Semaphore;


public class TrafficLightController implements Runnable {
    private final Semaphore semaphore;
    private final CarQueue carQueue;
    private final String direction;

    public TrafficLightController(Semaphore semaphore, CarQueue carQueue, String direction) {
        this.semaphore = semaphore;
        this.carQueue = carQueue;
        this.direction = direction;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int cars = carQueue.getCarCount();
                if (cars >= 2) {
                    int permits = Math.min(cars, 10);
                    semaphore.acquire(permits);
                    System.out.println(direction + " light green for " + permits + " seconds. Releasing " + permits + " cars.");
                    Thread.sleep(permits * 1000); // Simulate cars passing
                    carQueue.releaseCars(permits);
                    semaphore.release(permits);
                }
                Thread.sleep(1000); // Check every second
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
