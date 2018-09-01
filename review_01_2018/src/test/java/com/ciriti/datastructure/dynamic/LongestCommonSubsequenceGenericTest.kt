package com.ciriti.datastructure.dynamic

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
class LongestCommonSubsequenceGenericTest {

    @Test
    fun lcs(){
        Assert.assertEquals(2, arrayOf(2, 7, 5).lcs(arrayOf(2, 5)).size)
        Assert.assertEquals(1, arrayOf(1).lcs(arrayOf(1, 2, 3, 4)).size)
        Assert.assertEquals(2, arrayOf(2, 7, 8, 3).lcs(arrayOf(5, 2, 8, 7)).size)
    }

}