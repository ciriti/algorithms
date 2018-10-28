package com.ciriti.pattern

import com.ciriti.pattern.LightF.StateF.*
import com.ciriti.printThis

/**
 * Created by Carmelo Iriti
 */

/**
 * Four terms always associated with the command pattern are:
 *  - command
 *  - receiver
 *  - invoker
 *  - client
 */

fun (() -> Unit).execute() = this.invoke()

/** The Invoker class */
class RemoteControlF {

  val list = mutableListOf<() -> Unit>()

  fun storeAndExecute(command: () -> Unit) {
    list.add(command)
    command.execute()
  }

}

/** The Receiver class */
class LightF {
  enum class StateF { ON,
    OFF
  }

  var state = StateF.OFF
}

/** The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommandF(val light: LightF) : (() -> Unit) {
  override fun invoke() {
    light.state = ON
    println("light ${light.state}")
  }
}

/** The Command for turning off the light - ConcreteCommand #2 */
class FlipOffCommandF(val light: LightF) : (() -> Unit) {
  override fun invoke() {
    light.state = OFF
    println("light ${light.state}")
  }
}

fun main(args: Array<String>) {
  val light = LightF()
  val remoteControl = RemoteControlF()
  val commandUp = FlipUpCommandF(light)
  val commandDown = FlipOffCommandF(light)
  remoteControl.storeAndExecute(commandUp)
  remoteControl.storeAndExecute(commandDown)
  remoteControl.list.printThis()

}