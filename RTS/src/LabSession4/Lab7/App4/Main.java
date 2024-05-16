package LabSession4.Lab7.App4;

import java.lang.invoke.SwitchPoint;
import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);

        int[] t1 = {3, 6, 5};
        int[] t2 = {4, 7, 3};
        int[] t3 = {5, 7, 6};
        new ExecThread(sem, t1).start();
        new ExecThread(sem, t2).start();
        new ExecThread(sem, t3).start();
    }
}