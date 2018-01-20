package it.car.concurrency.example;

import java.util.HashMap;

/**
 * Created by ciriti on 03/12/16.
 */

public class ExampleSync {

    static class SharedObj {

        public synchronized void get() throws InterruptedException {
            System.out.println("xx get in");
            Thread.sleep(1000);
            System.out.println("xx get out");
        }

        public synchronized void set() throws InterruptedException {
            System.out.println("yy set in");
            Thread.sleep(1000);
            System.out.println("yy set out");
        }

    }

    static class MyThread extends Thread {

        SharedObj sharedObj;
        boolean selector;

        public MyThread(SharedObj sharedObj, boolean selector) {
            this.sharedObj = sharedObj;
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    if (selector)
                        sharedObj.get();
                    else
                        sharedObj.set();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String arg[]) {
            SharedObj sharedObj = new SharedObj();
            new MyThread(sharedObj, true).start();
            new MyThread(sharedObj, false).start();
        }

    }
}
