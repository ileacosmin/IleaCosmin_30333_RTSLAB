package LabSession4.Lab5.Example;

import static LabSession4.Lab5.Example.Main.monitor1;

public class Thread2 extends Thread{
    int activity_min1 ;
    int activity_max1 ;
    //run method
    public Thread2(int activity_min1, int activity_max1){
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
    }
public void run () {
    System.out.println("State 1 " + this.getName());
    int j = 0;
    while (j<3){
        System.out.println("State 2 " + this.getName());
        synchronized (monitor1){
            System.out.println("State 3 " + this.getName());
            int k= (int) (Math.random() * (activity_max1 - activity_min1) + activity_min1);
            for(int i = 0; i < 100000 * k; i++){
                i++;
                i--;
            }
            System.out.println("State 4 " + this.getName());
        }
        j++;
    }
}
}
