package LabSession5.Lab7.App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(String[] args) {
        Lock p9 = new java.util.concurrent.locks.ReentrantLock();
        Lock p10 = new java.util.concurrent.locks.ReentrantLock();


      CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier routine");
            }
        });
        ExecutionThread t1;
        ExecutionThread t2;

        while(true) {
            System.out.println("Main thread- STATE 1");
            t1 = new ExecutionThread("Thread 1", 4, 2, 4, 4, 6, p9,p10, barrier);
            t2 = new ExecutionThread("Thread 2", 5, 3, 5, 5, 7, p10, p9,barrier);
            t1.start();
            t2.start();
            try{
                barrier.await();
                barrier.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }
}
