package LabSession4.Lab5.Lab4App2RedundantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread {

    ReentrantLock monitor1, monitor2;
    int[] times;

    public ExecutionThread(ReentrantLock monitor1, ReentrantLock monitor2, int[] times) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.times = times;
    }

    public void run()
    {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        monitor1.lock();

        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (times[3] - times[2]) + times[2]);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        if(monitor2.tryLock())
        {
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)times[4] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                monitor2.unlock();
            }
        }

        monitor1.unlock();
        System.out.println(this.getName() + " - STATE 4");
    }
}