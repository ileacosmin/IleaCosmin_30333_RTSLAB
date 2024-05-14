package LabSession1.Lab2.Ex2;

import java.awt.*;
import java.util.Observable;

public class Fir extends Observable implements Runnable {
    int id;
    Window win;
    int processorLoad;
    int c;

    Fir(int id,Window win, int procLoad){
        this.id=id;
        this.win=win;
        this.processorLoad=procLoad;
        addObserver(win);
        this.c=0;
    }
    public void run(){
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c++;

            setChanged();
            notifyObservers(this);
        }
    }

    public int getId() {
        return id;
    }

    public int getC() {
        return c;
    }

}
