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
    fun `test if the strings in the array have the same hashcode`(){

        val res = arr
                .map { it.hashCode() }
                .reduce{ acc, s -> acc xor s }

        Assert.assertEquals(0, res)
    }

    @Test
    fun `test single hashcode`(){

        val s = arr[0]
        val s1 = arr[1]

        val h = s.myhash()
        val h1 = s1.myhash()

        Assert.assertTrue( h != h1)
    }

}

fun String.myhash() : Long{
    val a = mutableListOf(17L)
    a.addAll(toCharArray().map { it.toLong() })
    return a
            .reduce {
                acc, i -> 31L * acc + i
            }
}