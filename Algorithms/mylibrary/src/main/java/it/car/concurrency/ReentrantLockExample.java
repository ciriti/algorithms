package it.car.concurrency;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by carmeloiriti, 29/08/16.
 */
public class ReentrantLockExample {

    /**
     */

    ReentrantLock reentrantLock;
    int num_permits;

    public ReentrantLockExample(int num_threads) {
        this.num_permits = num_threads;
        /**
         */
        reentrantLock = new ReentrantLock(true);
    }

    public void print(){

        try {
            /** max num_permits threads can execute this line of code. The num_permits+1 thread must
             * wait for a release
             */
            reentrantLock.lock();
            try{
                System.out.println("Thread[" + Thread.currentThread().getName() + "] inside");
                Thread.sleep(1000);
                System.out.println("Thread[" + Thread.currentThread().getName() + "] after sleep");
            }finally {
                reentrantLock.unlock();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of threads:");
        int num_threads = scanner.nextInt();
        scanner.close();

        ReentrantLockExample semaphoreExample = new ReentrantLockExample(num_threads);

        for (int i = 0; i < semaphoreExample.num_permits; i++){
            new MyThread("Thread_" + i + "", semaphoreExample).start();
        }

    }


    /**
     * Utility class
     */
    static class MyThread extends Thread{
        ReentrantLockExample semaphoreExample;

        public MyThread(String name, ReentrantLockExample semaphoreExample) {
            super(name);
            this.semaphoreExample = semaphoreExample;
        }

        @Override
        public void run() {
            super.run();
            semaphoreExample.print();
        }
    }
}
