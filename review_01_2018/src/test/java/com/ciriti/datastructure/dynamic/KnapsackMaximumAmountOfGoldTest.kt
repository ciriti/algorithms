package com.ciriti.datastructure.dynamic

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
class KnapsackMaximumAmountOfGoldTest {

    @Test
    fun knapsackWithoutRepetitions(){
        Assert.assertEquals(9, knapsackGoldBars(capacity = 10, goldBars = arrayOf(1, 4, 8)))
    }

}