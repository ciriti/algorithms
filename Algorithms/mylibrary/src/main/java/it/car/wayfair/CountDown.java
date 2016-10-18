package it.car.wayfair;

import java.util.concurrent.CountDownLatch;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by ciriti on 16/10/16.
 */

public class CountDown {


    public static void main(String args[]){
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i = 0; i < 5; i ++){
            new MyThread(countDownLatch, "T_"+i).start();
        }
    }

    public static class MyThread extends Thread{

        CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch, String name) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " on run");

            if(countDownLatch.getCount() > 0)
                countDownLatch.countDown();
            try {

                countDownLatch.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " executed");

        }
    }

}
