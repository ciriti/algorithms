package com.ciriti.pattern

import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */
fun main(args : Array<String>){

  buildAuto {
    wheels = 5
    color = "red"
  }.printThis()
}

private inline fun buildAuto(config : Autos.() -> Unit) : Autos{
  val res = Autos()
  res.config()
  /**
   * or -> return Autos().apply(config)
   */

  return res
}

private data class Autos(var wheels : Int = 4, var color : String = "")