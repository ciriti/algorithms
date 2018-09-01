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
    }

}