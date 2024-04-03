package Lab4.App3;

public class Main {
    static Integer monitor = new Integer(1);

    public static void main(String[] args) {
        new ExecutionThread(monitor,3,6,5).start();
        new ExecutionThread(monitor,4,7,3).start();
        new ExecutionThread(monitor,5,7,6).start();
    }


}
