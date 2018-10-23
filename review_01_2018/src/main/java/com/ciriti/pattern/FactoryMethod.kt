package com.ciriti.pattern

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){
    val smartPhone : ASmartPhone = SmartPhone()
}

class SmartPhone : ASmartPhone(){
    override fun makeBattery(): IBattery = Battery()
}

abstract class ASmartPhone{

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