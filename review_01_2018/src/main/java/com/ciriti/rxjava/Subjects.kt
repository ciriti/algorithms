package com.ciriti.rxjava

import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.Subject

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){

  /**
   * PUBLISH: The subscriber will receive only the elements emitted aftrr the subscription
   */
  val publish : Subject<Int> = PublishSubject.create()
  publish.subscribe { println("1 sub: $it") }
  publish.apply { onNext(1) }.apply { onNext(2) }.apply { onNext(3) }
  publish.subscribe { println("2 sub: $it") }
  publish.onNext(4).apply { println("\n \n") }

  /**
   * REPLAY: The subscriber will receive all the elements from the begin
   */
  val replay : Subject<Int> = ReplaySubject.create()
  replay.apply { onNext(1) }.apply { onNext(2) }.apply { onNext(3) }
  replay.subscribe { println("1 replay: $it") }
  replay.onNext(4).apply { println("\n \n") }

  /**
   * Behavior: The subscriber will receive the most recent element emitted
   */
  val behavior : Subject<Int> = BehaviorSubject.create()
  behavior.apply { onNext(1) }.apply { onNext(2) }.apply { onNext(3) }
  behavior.subscribe { println("1 behavior: $it") }

}
