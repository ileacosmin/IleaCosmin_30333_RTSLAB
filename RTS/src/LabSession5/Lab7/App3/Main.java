package LabSession5.Lab7.App3;

import java.util.concurrent.CountDownLatch;

public class Main {
        public static void main(String[] args) {



            CountDownLatch latch = new CountDownLatch(2);

            Integer lock1 = new Integer(1);
            Integer lock2 = new Integer(1);

            ExecutionThread1 thread1 = new ExecutionThread1(latch, lock1, lock2, 7, 2, 3);
            ExecutionThread2 thread2 = new ExecutionThread2(latch, lock1, 5, 3, 5);
            ExecutionThread2 thread3 = new ExecutionThread2(latch, lock2, 5, 3, 5);

            thread1.start();
            thread2.start();
            thread3.start();

        }
    }

