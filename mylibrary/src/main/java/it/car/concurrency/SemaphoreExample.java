package it.car.concurrency;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Created by carmeloiriti, 29/08/16.
 */
public class SemaphoreExample {

    /**
     * Semaphore – Use the concept of a permit to indicate a max number of allowed threads in a
     * place. When you use the value 1, the behavior its similar to synchronize, also called binary
     * semaphore. There is however a big difference here, you acquire a permit on the semaphore,
     * not a locking object, its just a variable to count when a thread acquires a permit and when
     * a thread releases a permit, some kind of a counter. The only thing you really have are
     * threads locking until a permit be available. In the example below, we define 3 as the number
     * of permits, so after 3 acquires the 4 thread will wait for a release before continue its
     * execution.
     */

    Semaphore semaphore;
    int num_permits;

    public SemaphoreExample(int num_threads) {
        this.num_permits = num_threads;
        /**
         * semaphore that allows max num_threads in the same time
         */
        semaphore = new Semaphore(num_threads, false);
    }

    public void print(){

        try {
            /** max num_permits threads can execute this line of code. The num_permits+1 thread must
             * wait for a release
             */
            semaphore.acquire();
            System.out.println("Thread[" + Thread.currentThread().getName() + "] inside");
            Thread.sleep(1000);
            System.out.println("Thread[" + Thread.currentThread().getName() + "] after sleep");

            /**
             * somewhere in the code a thread releases the mySemaphore,
             * and now the next waiting thread can acquire
             */

            semaphore.release();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of threads:");
        int num_threads = scanner.nextInt();
        scanner.close();

        SemaphoreExample semaphoreExample = new SemaphoreExample(num_threads);

        for (int i = 0; i < semaphoreExample.num_permits * 10; i++){
            new MyThread("Thread_" + i + "", semaphoreExample).start();
        }

    }


    /**
     * Utility class
     */
    static class MyThread extends Thread{
        SemaphoreExample semaphoreExample;

        public MyThread(String name, SemaphoreExample semaphoreExample) {
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
