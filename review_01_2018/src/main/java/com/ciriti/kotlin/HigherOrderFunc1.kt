package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
var counter1 = 0
var counter2 = 0

fun main(args : Array<String>){
  val v = View()
  (0 until 4).forEach {
    v.setListener(object : OnClickListener{
      init { println("counter1: ${counter1++}") }
      override fun onClick(view: View) {
        println("first listener")
      }
    })
    v.cLick()
    v.setListener {
      println("second listener")
    }
    v.cLick()

    println()
  }

}

interface OnClickListener{
  fun onClick(view : View)
}

class OnClickListener_ : OnClickListener{

  private var func : ((view: View) -> Unit)? = null

  init { println("counter2: ${counter2++}") }

  override fun onClick(view: View) {
    func?.invoke(view)
  }

  fun onClick_(f : (view: View) -> Unit) {
    func = f
  }
}

fun View.setListener(init : OnClickListener_.() -> Unit){
  val listener = OnClickListener_()
  listener.init()
  setListener(listener)
}

class View {
  private var listener : OnClickListener? = null
  fun setListener(l : OnClickListener?) {
    listener = l
  }

  fun cLick() = listener?.onClick(this)
}




