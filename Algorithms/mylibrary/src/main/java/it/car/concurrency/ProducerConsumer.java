package it.car.concurrency;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by carmeloiriti, 29/08/16.
 */
public class ProducerConsumer {

    public static void main(String args[]){

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of consumer:");
        int consumers = scanner.nextInt();
        scanner.close();

        for(int i = 0; i < consumers; i++){
            new Consumer("Consumer_" + i, blockingQueue).start();
        }

        new Producer("Producer", blockingQueue).start();

    }

    /**
     * Produce that generate value
     */
    public static class Producer extends Thread{
        final BlockingQueue<Integer> blockingQueue;

        public Producer(String threadName, BlockingQueue<Integer> blockingQueue) {
            super(threadName);
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            super.run();

            for (int i = 0; i < 10 ; i ++){
                try {
                    System.out.println("Producer: " + 1);
                    blockingQueue.put(i);
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Consumer that generate value
     */
    public static class Consumer extends Thread{
        final BlockingQueue<Integer> blockingQueue;

        public Consumer(String threadName, BlockingQueue<Integer> blockingQueue) {
            super(threadName);
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            super.run();

            for (int i = 0; i < 10 ; i ++){
                try {
                    int val = blockingQueue.poll(5000, TimeUnit.MILLISECONDS);
                    System.out.println("Consumer[" + Thread.currentThread().getName() + "] consume " + val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
