package Lab4.App4;

public class ExecutionThread1 extends Thread{

        int sleep,activity_min, activity_max;
        Integer monitor1, monitor2;

        public ExecutionThread1( int sleep, int activity_min, int activity_max, Integer monitor1, Integer monitor2) {

            this.monitor1 = monitor1;
            this.monitor2 = monitor2;

            this.sleep = sleep;
            this.activity_min = activity_min;
            this.activity_max = activity_max;
        }

        public synchronized void waitNotify(String name) throws InterruptedException{
            System.out.println(name + " waitis");
            wait();
        }

        public void run() {
            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                System.out.println(this.getName() + " - STATE 2");

                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                //here t6 happens
                synchronized (monitor1) {
                    monitor1.notify();
                }
                synchronized (monitor2){
                    monitor2.notify();
                }

                System.out.println( this.getName() + " - STATE 3");



            }
        }

