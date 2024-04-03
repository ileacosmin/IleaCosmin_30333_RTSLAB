package Lab3.example3;

class JoinTestThread extends Thread {
    private Thread t;

    private int limit;
    static int divisorSum ;

    JoinTestThread(String n, Thread t, int limit) {
        this.setName(n);
        this.t = t;
        this.limit = limit;
    }

    public  void findDivisorSum(){
    for (int i = 1; i <= this.limit; i++) {
        if (this.limit % i == 0)
            divisorSum += i;
    }
}
    public void run() {
        System.out.println(this.getName() + " has entered the run() method");
        try {
            if (t != null)
                t.join();

            findDivisorSum();

            Main.setSumOfDivisors(divisorSum);


            System.out.println("Thread " + this.getName() + " executing operation.");
            Thread.sleep(3000);
            System.out.println("Thread " + this.getName() + " has terminated operation.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}