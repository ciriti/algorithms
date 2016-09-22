package it.car.concurrency;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by carmeloiriti, 29/08/16.
 */
public class CountDownLatchExample {

    /**
     * CountDownLatch – Initialize this class with a number (to countdown), and when reaches 0 the
     * thread waiting unblocks and follows its way.
     * N.B:  After the await the latch CANNOT be reused!!!
     */

    CountDownLatch latch;
    int countdown;

    public CountDownLatchExample(int countdown) {
        this.countdown = countdown;
        /**
         * Initializes a countdown starting from #countdown
         */
        latch = new CountDownLatch(countdown);
    }

    public void print(){

        try {
            Thread.sleep(new Random().nextInt(9) * 100);
            if(latch.getCount() > 0){
                System.out.println("Thread[" + Thread.currentThread().getName() + "] decremnts the count down");
                latch.countDown();
            }
            /**
             * Some thread blocks and waits for the latch countdown to reach "0"
             */
            latch.await();
            System.out.println("Thread[" + Thread.currentThread().getName() + "] is running, the min number of thread (" + countdown + ") has been reached");
            /**
             * decrementing the latch.. when it reachs 0  the blocked thread with the "await()" follows its way
             */
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the countdown:");
        int countdown = scanner.nextInt();
        scanner.close();

        CountDownLatchExample countDownLatchExample = new CountDownLatchExample(countdown);

        for (int i = 0; i < countdown * 2; i++){
            new MyThread("Thread_" + i + "", countDownLatchExample).start();
        }

    }


    /**
     * Utility class
     */
    static class MyThread extends Thread{
        CountDownLatchExample semaphoreExample;

        public MyThread(String name, CountDownLatchExample semaphoreExample) {
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
