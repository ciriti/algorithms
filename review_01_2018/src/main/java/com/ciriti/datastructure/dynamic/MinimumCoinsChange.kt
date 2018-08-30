package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.L

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    println(minimumNumberCoins(6, L[1,3,4]))
    println(minimumNumberCoins(2, L[1,3,4]))
    println(minimumNumberCoins(34, L[1,3,4]))
}

/**
 * I'm building a support vector that contains the minimum number of coins required for each value
 * of money till the requested value
 */
fun minimumNumberCoins(money :Int, coins : List<Int>) : Int{

    val mnc = IntArray(money + 1 ).apply { this.fill(Int.MAX_VALUE) }
    mnc[0] = 0
    var calculatedCoin = 0

    (1..money).forEach money@{ money ->
        coins.forEach { coin ->
            if(money >= coin){
                calculatedCoin = money - coin
                if(mnc[money] > mnc[calculatedCoin]){
                    mnc[money] = mnc[calculatedCoin] + 1
                }

            }else return@money
        }
    }

    return mnc[money]
}

