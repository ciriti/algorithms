package com.ciriti.datastructure

import com.ciriti.printThis
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */

class Generictest {


    @Test
    fun t1() {
        listOf("A","B", "B", "A", "A").groupBy { it.first() }.flatMap { it.value }.printThis()
    }

}