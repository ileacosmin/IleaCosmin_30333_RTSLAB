package Lab2.Example2;

class Main{

    public static void main(String[] args) {

        CounterRunnable c1 = new CounterRunnable();

        CounterRunnable c2 = new CounterRunnable();

        CounterRunnable c3 = new CounterRunnable();

        Thread t1 = new Thread(c1,"conuter1");

        Thread t2 = new Thread(c2,"conuter2");

        Thread t3 = new Thread(c3,"conuter3");

        t1.start();

        t2.start();

        t3.start();

    }

}