package com.ciriti.pattern

/**
 * Created by Carmelo Iriti
 */

abstract class SmartPhone{

    val battery : IBattery = makeBattery()

     init {
         battery.providePower()
     }

    abstract fun makeBattery() : IBattery

}

interface IBattery{
    fun providePower()
}

class Battery : IBattery{
    override fun providePower() {
        println("Provide power")
    }
}