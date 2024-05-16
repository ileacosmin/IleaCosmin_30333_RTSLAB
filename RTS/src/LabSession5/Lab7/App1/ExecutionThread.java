package LabSession5.Lab7.App1;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class ExecutionThread extends Thread {

    Lock p9, p10;

    CyclicBarrier barrier;


    int sleep_time, activity_min1, activity_max1, activity_min2, activity_max2;

    // constructor
    public ExecutionThread(String name, int sleep_time, int activity_min1, int activity_max1, int activity_min2, int activity_max2, Lock p9, Lock p10, CyclicBarrier barrier) {
        super(name);
        this.sleep_time = sleep_time;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
        this.p9 = p9;
        this.p10 = p10;
        this.barrier = barrier;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        if (p9.tryLock()) {
            try {
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                if (p10.tryLock()) {
                    try {
                        System.out.println(this.getName() + " - STATE 3");
                        Thread.sleep(sleep_time * 1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        p10.unlock();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                p9.unlock();
            }

        }
        System.out.println(this.getName() + " - STATE 4");

        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}


