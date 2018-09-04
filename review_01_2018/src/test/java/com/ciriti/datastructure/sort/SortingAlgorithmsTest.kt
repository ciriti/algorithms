package com.ciriti.datastructure.sort

import org.junit.Assert
import org.junit.Test

/**
 * Created by ciriti
 */
class SortingAlgorithmsTest{

    @Test
    fun insertionSort(){
        Assert.assertArrayEquals(arrayOf(1, 2), arrayOf(2, 1).apply { insertionSort() })
        Assert.assertArrayEquals(arrayOf(1), arrayOf(1).apply { insertionSort() })
        Assert.assertArrayEquals(arrayOf(1,2,3,4,5,6,7,8,9), arrayOf(9,8,7,6,5,4,3,2,1).apply { insertionSort() })
    }

    @Test
    fun quicksortTest(){
        Assert.assertEquals(listOf(1, 2), listOf(2, 1).quickSort())
        Assert.assertEquals(listOf(1, 2, 3), listOf(2, 3, 1).mergeSort())
        Assert.assertEquals(listOf(1), listOf(1).quickSort())
        Assert.assertEquals(listOf(1,2,3,4,5,6,7,8,9), listOf(9,8,7,6,5,4,3,2,1).quickSort())
    }

    @Test
    fun mergesortTest(){
        Assert.assertEquals(listOf(1, 2), listOf(2, 1).mergeSort())
        Assert.assertEquals(listOf(1, 2, 3), listOf(2, 3, 1).mergeSort())
        Assert.assertEquals(listOf(1, 2, 3, 4), listOf(2, 4, 3, 1).mergeSort())
        Assert.assertEquals(listOf(1), listOf(1).mergeSort())
        Assert.assertEquals(listOf(1,2,3,4,5,6,7,8,9), listOf(9,8,7,6,5,4,3,2,1).mergeSort())
    }

}