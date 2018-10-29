package com.ciriti.kotlin

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

/**
 *  Bound references store the object on which the member can be later called,
 *  while unbound references might be called on any object of a given type.
 *
 * Bound reference means that you are storing in an object a bound reference( a bound reference is
 * when you are connecting a function, using its reference, to an object )
 */

fun main(args : Array<String>){
  val alice = Person("alice", 25)
  /** Non-bound reference: the corresponding lambda */
  val agePredicate : (Person, Int) -> Boolean = { person, ageLimit ->
    person.isOlder(ageLimit)
  }
  /** Bound reference */
  val agePredicate1 : (Int) -> Boolean = alice::isOlder
  /**
   * Test
   */
  agePredicate(alice, 34).printThis("Non-bound ref - ")
  agePredicate1(34).printThis("Bound ref - ")
}

class Person(val name : String, val age : Int){
  fun isOlder(ageLimit : Int) = age > ageLimit
}