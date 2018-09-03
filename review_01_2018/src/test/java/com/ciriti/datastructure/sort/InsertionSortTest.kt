package com.ciriti.datastructure.sort

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
class InsertionSortTest{

    @Test
    fun t1(){
        Assert.assertArrayEquals(arrayOf(1, 2), arrayOf(2, 1).apply { insertionSort() })
        Assert.assertArrayEquals(arrayOf(1), arrayOf(1).apply { insertionSort() })
        Assert.assertArrayEquals(arrayOf(1,2,3,4,5,6,7,8,9), arrayOf(9,8,7,6,5,4,3,2,1).apply { insertionSort() })
    }

}