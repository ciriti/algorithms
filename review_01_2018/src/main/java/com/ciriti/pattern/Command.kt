package com.ciriti.pattern

import com.ciriti.pattern.Light.State.OFF
import com.ciriti.pattern.Light.State.ON
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

/** The Command interface */
interface Command {
  fun execute()
}

/** The Invoker class */
class RemoteControl {

  val list = mutableListOf<Command>()

  fun storeAndExecute(command: Command) {
    list.add(command)
    command.execute()
  }

}

/** The Receiver class */
class Light {
  enum class State { ON,
    OFF
  }

  var state = State.OFF
}

/** The Command for turning on the light - ConcreteCommand #1 */
class FlipUpCommand(val light: Light) : Command {
  override fun execute() {
    light.state = ON
    println("light ${light.state}")
  }
}

/** The Command for turning off the light - ConcreteCommand #2 */
class FlipOffCommand(val light: Light) : Command {
  override fun execute() {
    light.state = OFF
    println("light ${light.state}")
  }
}

fun main(args: Array<String>) {
  val light = Light()
  val remoteControl = RemoteControl()
  val commandUp = FlipUpCommand(light)
  val commandDown = FlipOffCommand(light)
  remoteControl.storeAndExecute(commandUp)
  remoteControl.storeAndExecute(commandDown)
  remoteControl.list.printThis()

}