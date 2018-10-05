package com.ciriti.puzzle

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
    println(longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(longestConsecutive2(intArrayOf(100, 4, 200, 1, 3, 2)))
}

fun longestConsecutive(nums: IntArray): List<Int> {

    val set = HashSet<Int>()
    set.addAll(nums.toList())
    var res = mutableListOf<Int>()

    set.forEach {
        val tempList = mutableListOf(it)
        while (set.contains(tempList.last() + 1)) {
            tempList.add(tempList.last() + 1)
        }
        res = tempList.let { if (it.size > res.size) it else res }
    }

    return res

}

fun longestConsecutive2(nums: IntArray): List<Int> {

    var res = mutableListOf<Int>()
    nums.sort()
    var tmp = mutableListOf<Int>()
    tmp.add(nums[0])
    (0 until nums.lastIndex).forEach {
        when {
            nums[it] + 1 == nums[it + 1] -> tmp.add(nums[it + 1])
            else -> {
                res = if (tmp.size > res.size) tmp else res
                tmp = mutableListOf()
                tmp.add(nums[it + 1])
            }
        }
    }
    return res
}

fun t1() {

    val array = Array<Int>(0) { 0 }
    val array1 = arrayOf<Int>()
    val map = hashMapOf<>()

}