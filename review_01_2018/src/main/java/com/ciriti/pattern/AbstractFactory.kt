package com.ciriti.pattern

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){
    var factory : IGUIFactory = WinFactory()
    factory.createButton().paint()
    factory = OSXFactory()
    factory.createButton().paint()
}

/**
 * Abstract product
 */
interface IButton {
    fun paint()
}

/**
 * Abstract factory
 */
interface IGUIFactory {
    fun createButton(): IButton
}

/**
 * Concrete factory 1
 */
class WinFactory : IGUIFactory {
    override fun createButton(): IButton {
        return WinButton()
    }
}

/**
 * Concrete factory 2
 */
class OSXFactory : IGUIFactory {
    override fun createButton(): IButton {
        return OSXButton()
    }
}

/**
 * Concrete product 1
 */
class WinButton : IButton {
    override fun paint() {
        println("WinButton")
    }
}

/**
 * Concrete product 2
 */
class OSXButton : IButton {
    override fun paint() {
        println("OSXButton")
    }
}

