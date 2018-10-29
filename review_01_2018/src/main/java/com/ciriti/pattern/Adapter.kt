package com.ciriti.pattern

/**
 * Created by Carmelo Iriti
 */

/** adapter class */
class GermanToUKPlugConnector(val plug: IGermanPlugConnector) : IUKPlugConnector {
  override fun receiveElectricity() = plug.receiveElectricity()
}

class GermanSocket(val plug: IGermanPlugConnector) {
  fun giveElectricity() = plug.receiveElectricity()
}

class UKSocket(val plug: IUKPlugConnector) {
  fun giveElectricity() = plug.receiveElectricity()
}

interface IGermanPlugConnector {
  fun receiveElectricity()
}

class GermanPlugConnector : IGermanPlugConnector {
  override fun receiveElectricity() = println("connected!")
}

class UKPlugConnector : IUKPlugConnector {
  override fun receiveElectricity() = println("connected!")
}

interface IUKPlugConnector {
  fun receiveElectricity()
}

fun main(args: Array<String>) {
  val plug = GermanPlugConnector()
  val deToUkAdapter = GermanToUKPlugConnector(plug)
  val socket = UKSocket(deToUkAdapter)
  socket.giveElectricity()
}