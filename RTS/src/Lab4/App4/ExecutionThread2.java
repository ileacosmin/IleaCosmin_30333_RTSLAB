package Lab4.App4;

public class ExecutionThread2 extends Thread{
    int activity_min;
    int activity_max;
    ExecutionThread1 executionThread1;

    public ExecutionThread2(int activity_min, int activity_max, ExecutionThread1 executionThread1) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.executionThread1 = executionThread1;
    }

    public void run(){
        try {
            executionThread1.waitNotify(this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " - STATE 2");
    }

}