package Lab5.Example;

public class Main {
    static Integer monitor1 = new Integer(1);

    public static void main(String[] args) {
        new Thread1(2,5).start();
        new Thread2(5,9).start();
    }
}
