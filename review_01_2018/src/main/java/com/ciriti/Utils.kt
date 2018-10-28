package com.ciriti

/**
 * Created by Carmelo Iriti
 */

fun<T> List<T>.printAll() = println(this)
fun<T> T.printThis(prefix : String = "", postfix : String = "") = println("$prefix $this $postfix")