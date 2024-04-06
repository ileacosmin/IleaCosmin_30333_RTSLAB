package Lab4.App4;

public class Main {
    public static void main(String[] args) {
        ExecutionThread1 executionThread1 = new ExecutionThread1(7, 2, 3);
        ExecutionThread2 executionThread21 = new ExecutionThread2(3, 5, executionThread1);
        ExecutionThread2 executionThread22 = new ExecutionThread2(4, 6, executionThread1);
        executionThread1.start();
        executionThread21.start();
        executionThread22.start();
    }

}
