package com.ciriti.rxjava

import io.reactivex.Flowable

/**
 * Created by Carmelo Iriti
 */
fun main(args : Array<String>){
  Flowable.range(1, 1000)
      .buffer(10)//Optional you can process single event
      .flatMap({ buf ->
      System.out.println(String.format("100ms for sending events to server: %s ", buf));
    Thread.sleep(100);
    Flowable.fromIterable(buf)
  }, 1)

}