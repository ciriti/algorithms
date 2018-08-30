package com.ciriti.datastructure

/**
 * Created by Carmelo Iriti
 */

object L {
    operator fun <T> get (vararg a : T) = listOf(*a)
}