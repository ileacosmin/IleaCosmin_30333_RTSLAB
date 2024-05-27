package LabSession4.Lab5.Lab4App2RedundantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock monitor1 = new ReentrantLock();
        ReentrantLock monitor2 = new ReentrantLock();


        int[] t1 = {2, 4, 4, 6, 4};
        int[] t2 = {3, 5, 5, 7, 5};
        new ExecutionThread(monitor1, monitor2, t1).start();
        new ExecutionThread(monitor2, monitor1, t2).start();
    }
}