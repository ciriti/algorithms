package it.car.concurrency.example;

/**
 * Created by ciriti on 03/12/16.
 */

public class LockExample {

    public static class SharedObj {

        /**
         * This object avoid to execute multiple times the SharedObj's constructor
         */
        private static final String lock = new String();

        /**
         * instance to return
         */
        private static SharedObj instance;
        /**
         * countet just for example
         */
        private static int counter = 0;

        private SharedObj() {
            counter++;
        }

        /**
         * This method is not sync, called from multiple thread
         * it will execute multiple times the constructor
         *
         * @return
         */
        public static SharedObj getInstanceNoSync() {
            if (instance == null) {
                instance = new SharedObj();
            }
            return instance;
        }

        /**
         * INTRINSIC LOCK
         *
         * Intrinsic locks in Java act as mutexes (or mutual exclusion locks)
         *
         * In this method is used an intrinsic lock
         * it will work fine and if you need to synchronize
         * this method with other methods it is possible
         *
         * @return
         */
        public static SharedObj getInstance() {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SharedObj();
                }
            }
            return instance;
        }

        /**
         * This method is declared synchronized, it will work
         *
         * @return
         */
        public synchronized static SharedObj getInstanceII() {
            if (instance == null) {
                instance = new SharedObj();
            }
            return instance;
        }

        @Override
        public String toString() {
            return String.valueOf(counter);
        }
    }

    /**
     * Thread used to test the lock
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            SharedObj.getInstanceII();
        }
    }

    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("counter: " + SharedObj.getInstance().toString());
    }

}
