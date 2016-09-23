package it.car.concurrency;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by carmeloiriti, 29/08/16.
 */
public class CyclicBarrierExample {

    /**
     * CyclicBarrier  – This class behaves somehow as the inverse of the CountDownLatch.
     * After N await() the threads blocked can follow their way.
     * N.B. A CyclicBarrier can be reused!!!
     */


    CyclicBarrier barrier;
    int barrierNum;

    public CyclicBarrierExample(int barrierNum) {
        this.barrierNum = barrierNum;
        barrier = new CyclicBarrier(barrierNum);
    }

    public void print(){

        try {
            /**
             * threads they block here until the barrierNum is reached
             */
            Thread.sleep(new Random().nextInt(9) * 100);
            System.out.println("Thread[" + Thread.currentThread().getName() + "] is waiting on barrier");
            barrier.await();
            System.out.println("Thread[" + Thread.currentThread().getName() + "] has crossed the barrier");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of barrier:");
        int barrierNum = scanner.nextInt();
        scanner.close();

        CyclicBarrierExample cyclicBarrierExample = new CyclicBarrierExample(barrierNum);

        for (int i = 0; i < cyclicBarrierExample.barrierNum * 2; i++){
            new MyThread("Thread_" + i + "", cyclicBarrierExample).start();
        }

    }


    /**
     * Utility class
     */
    static class MyThread extends Thread{
        CyclicBarrierExample semaphoreExample;

        public MyThread(String name, CyclicBarrierExample semaphoreExample) {
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
