package com.ciriti.datastructure

/**
 * Created by ciriti
 */
object L {
  operator fun <T> get (vararg a : T) = listOf(*a)
}