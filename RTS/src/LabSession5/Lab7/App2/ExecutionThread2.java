package LabSession5.Lab7.App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ExecutionThread2 extends Thread {
    CountDownLatch latch;
    Semaphore sem1;
    Semaphore sem2;

    int[] times;

    public ExecutionThread2(CountDownLatch latch, Semaphore sem1, Semaphore sem2, int[] times) {
        this.latch = latch;
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.times = times;
    }

    public void run()
    {
        while (true)
        {
            System.out.println(this.getName() + " - STATE 1");
            try
            {
                sem1.acquire();
                sem2.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (times[1] - times[0]) + times[0]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            try
            {
                Thread.sleep(times[2] * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            sem1.release();
            sem2.release();
            System.out.println(this.getName() + " - STATE 3");
            latch.countDown();
            try
            {
                latch.await();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}