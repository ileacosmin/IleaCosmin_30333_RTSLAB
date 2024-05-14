package LabSession3.Lab4.App4;

public class Main {

    public static void main(String[] args) {
        Integer p6 = 1;
        Integer p10 = 1;

        ExecutionThread1 executionThread1 = new ExecutionThread1(7, 2, 3, p6, p10);
        ExecutionThread2 executionThread21 = new ExecutionThread2(3, 5, executionThread1, p6);
        ExecutionThread2 executionThread22 = new ExecutionThread2(4, 6, executionThread1, p10);
        executionThread1.start();
        executionThread21.start();
        executionThread22.start();
    }

}
