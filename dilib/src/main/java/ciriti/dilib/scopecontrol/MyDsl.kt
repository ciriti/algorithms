package ciriti.dilib.scopecontrol

import javax.inject.Inject

/**
 * Created by Carmelo Iriti
 */

fun main(){

  val uman = Uman()
  println()

}

class Uman{
}

class Person @Inject constructor(val uman : Uman)