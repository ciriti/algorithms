package it.car.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import it.car.graph.util.In;

import static android.R.attr.name;

/**
 * Created by ciriti on 05/09/16.
 */

public class ProducerConsumerWaitNotify {

    public static void main(String args[]){
        SyncObject<Integer> queue = new SyncObject<>();
        for(int i = 0; i < 5; i++){
            new Consumer("cons_" + i, queue).start();
        }

        new Producer("prod_" + 0, queue).start();


    }

    public static class Producer extends Thread{

        SyncObject<Integer> obj;
        String name;

        public Producer(String name, SyncObject<Integer> obj) {
            super(name);
            this.obj = obj;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5 ; i ++){
//                System.out.println("Th " + name + " inside synch");

                try {
                    Thread.sleep(2000);
                    System.out.println("Th " + name + " val " + obj.add(new Random().nextInt(100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("Th " + name + " outside synch");
            }
            obj.add(-1);
        }
    }

    public static class Consumer extends Thread{

        SyncObject<Integer> obj;
        String name;

        public Consumer(String name, SyncObject<Integer> obj) {
            super(name);
            this.obj = obj;
            this.name = name;
        }

        @Override
        public void run() {
                try {

                    Thread.sleep(1500);
                    Integer val = obj.getT();
//                    if(val == null) break;
                    if(val != null)
                        System.out.println("Consumer[" + Thread.currentThread().getName() + "] consume " + val);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

    }

    public final static class SyncObject<T>{
        Queue<T> queue;

        public SyncObject() {
            queue = new LinkedList<>();
        }

        public T getT() throws InterruptedException {

            synchronized (this){
                if(queue.isEmpty())
                    wait();
                return queue.poll();
            }

        }

        public T add(T t) {
            synchronized (this){
                queue.add(t);
                notifyAll();
                return t;
            }
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

}
