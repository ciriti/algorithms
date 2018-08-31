package com.ciriti.datastructure.dynamic

import org.junit.Assert
import org.junit.Test

/**
 * Created by Carmelo Iriti
 */
class MinimumCoinsChange {

    @Test
    fun MinimumCoinsChangeTest(){

        Assert.assertEquals(2, minimumNumberCoins(6, listOf(1,3,4)))
        Assert.assertEquals(2, minimumNumberCoins(2, listOf(1,3,4)))
        Assert.assertEquals(9, minimumNumberCoins(34, listOf(1,3,4)))

    }

}