package Lab4.App1;

import Lab4.Example1.ExecutionThread;

public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread1(monitor1, 2, 4).start();
        new ExecutionThread2(monitor1,monitor2, 3, 6).start();
        new ExecutionThread3(monitor2,2,5).start();
    }
}
