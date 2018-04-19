@file:Suppress("IllegalIdentifier")
package com.ciriti.datastructure

import org.junit.Assert
import org.junit.Test

/**
 * Created by carmeloiriti on 19.04.18.
 */
class HashCodeTest {

    val arr = arrayOf("AaAaAaAa", "AaAaBBBB", "AaAaAaBB", "AaAaBBAa",
            "BBBBAaAa", "BBBBBBBB", "BBBBAaBB", "BBBBBBAa",
            "AaBBAaAa", "AaBBBBBB", "AaBBAaBB", "AaBBBBAa",
            "BBAaAaAa", "BBAaBBBB", "BBAaAaBB", "BBAaBBAa")

    @Test
    fun hashCodeTest(){

        val res = arr
                .map { it.hashCode() }
                .reduce{ acc, s -> acc xor s }

        Assert.assertEquals(0, res)
    }

    @Test
    fun `test single hashcode`(){

        val res = arr
                .map { it.hashCode() }
                .reduce{ acc, s -> acc xor s }

        Assert.assertEquals(0, res)
    }

}