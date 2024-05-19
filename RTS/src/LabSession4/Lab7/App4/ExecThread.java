package LabSession4.Lab7.App4;

import java.lang.invoke.SwitchPoint;
import  java.util.concurrent.Semaphore;

public class ExecThread extends Thread{

    final Semaphore sem;
    int[] activity_and_sleep_times;

    public ExecThread(Semaphore sem, int[] activity_and_sleep_times){
        this.sem = sem;
        this.activity_and_sleep_times = activity_and_sleep_times;
    }

    public void run(){

        while(true){
            System.out.println(this.getName() + " - STATE 1");
            try{
                sem.acquire(1);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_and_sleep_times[1] - activity_and_sleep_times[0]) + activity_and_sleep_times[0]);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            sem.release(1);
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep((long)activity_and_sleep_times[2] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }
}