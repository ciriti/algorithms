package com.ciriti.todelete

import kotlin.reflect.KClass

/**
 * Created by Carmelo Iriti
 */


fun main(args : Array<String>){
    var gui : IGuiFactory = WinGui()
    gui.provideButton().draw()
    gui = OsxGui()
    gui.provideButton().draw()
}

interface IButton{
    fun draw()
}

interface IGuiFactory{
    fun provideButton() : IButton

    fun b() = WinButton()
}

class OsxGui : IGuiFactory{
    override fun provideButton() = OsxButton()
}
class WinGui : IGuiFactory{
    override fun provideButton() = WinButton()
}

class WinButton : IButton {
    override fun draw() = println("Win btn")
}

class OsxButton : IButton {
    override fun draw() = println("Osx btn")
}