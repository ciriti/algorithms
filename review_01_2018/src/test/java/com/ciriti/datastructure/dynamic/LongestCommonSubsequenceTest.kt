package com.ciriti.datastructure.dynamic

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
class LongestCommonSubsequenceTest {

    @Test
    fun lcs(){
        Assert.assertEquals("oorld", "Hello World".longestCommonSubsequence("Bonjour le monde"))
        Assert.assertEquals("ABCB", "ABCBX".longestCommonSubsequence("ABDCAB"))
        Assert.assertEquals(3, "ports".longestCommonSubsequence(" short").length)
        Assert.assertEquals(5, "editing".longestCommonSubsequence(" distance").length)
    }

}