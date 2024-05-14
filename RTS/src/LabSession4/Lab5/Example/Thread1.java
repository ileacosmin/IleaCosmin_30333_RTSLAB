package LabSession4.Lab5.Example;

import static LabSession4.Lab5.Example.Main.monitor1;

public class Thread1 extends Thread{
    //run method
    private int activity_min1 ;
    private int activity_max1;
    public Thread1(int activity_min1, int activity_max1){
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
    }



    public void run(){
        System.out.println("State 1 "+ this.getName());
        synchronized (monitor1){
            System.out.println("State 2 "+ this.getName());
            int k = (int) (Math.random() * (activity_max1 - activity_min1) + activity_min1);
                for (int i = 0; i <k* 100000; i++) {
                    i++;
                    i--;
                }
        }
        System.out.println("State 3 " + this.getName());
    }
}
