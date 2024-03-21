package Lab3.example3;

class JoinTestThread extends Thread {
    private Thread t;

    private int limit;

    JoinTestThread(String n, Thread t, int limit) {
        this.setName(n);
        this.t = t;
        this.limit = limit;
    }

    public void run() {
        System.out.println(this.getName() + " has entered the run() method");
        try {
            if (t != null)
                t.join();

            int divisorSum = 0;
            for (int i = 1; i <= limit; i++) {
                if (limit % i == 0)
                    divisorSum += i;
            }

            Main.setSumOfDivisors(divisorSum);


            System.out.println("Thread " + this.getName() + " executing operation.");
            Thread.sleep(3000);
            System.out.println("Thread " + this.getName() + " has terminated operation.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}