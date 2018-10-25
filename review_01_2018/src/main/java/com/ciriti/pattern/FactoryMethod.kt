package com.ciriti.pattern

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){
    val smartPhone : ASmartPhone = SmartPhone()
    smartPhone.powerOn()
    val smartPhone2 = SmartPhoneKt()
    smartPhone2.makeBattery { Battery() }
    smartPhone2.powerOn()

}

class SmartPhone : ASmartPhone(){
    override fun makeBattery(): IBattery = Battery()
}

/**
 * Classical pattern
 */
abstract class ASmartPhone{

    val battery : IBattery = makeBattery()

     fun powerOn() {
         battery.providePower()
     }

    abstract fun makeBattery() : IBattery

}

/**
 * Pattern with kotlin
 */
class SmartPhoneKt{

    private var battery : (() -> IBattery)? = null

    fun powerOn()  {
         battery?.invoke()?.providePower()
     }

    fun makeBattery(func : () -> IBattery){
        battery = func
    }

}

interface IBattery{
    fun providePower()
}

class Battery : IBattery{
    override fun providePower() {
        println("Provide power")
    }
}