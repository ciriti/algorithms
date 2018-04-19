package com.ciriti.datastructure

import org.junit.Assert
import org.junit.Test

/**
 * Created by carmeloiriti on 19.04.18.
 */
class HashCodeTest {

    @Test
    fun hashCodeTest(){
        val arr = arrayOf("AaAaAaAa", "AaAaBBBB", "AaAaAaBB", "AaAaBBAa",
                "BBBBAaAa", "BBBBBBBB", "BBBBAaBB", "BBBBBBAa",
                "AaBBAaAa", "AaBBBBBB", "AaBBAaBB", "AaBBBBAa",
                "BBAaAaAa", "BBAaBBBB", "BBAaAaBB", "BBAaBBAa")

        val res = arr
                .map { it.hashCode() }
                .reduce{ acc, s -> acc xor s }

        Assert.assertEquals(0, res)
    }

}