package com.ciriti.datastructure.dynamic

import com.ciriti.datastructure.printMatrix
import kotlin.math.max

/**
 * Created by ciriti
 */

fun main(args : Array<String>){

    val capacity = 10
    val goldBars = arrayOf(1, 4, 8)

    println(knapsackGoldBars(capacity, goldBars))

}

fun knapsackGoldBars(capacity : Int, goldBars : Array<Int>) : Int{

    val array = Array(goldBars.size + 1 ){ Array(capacity + 1) { 0 } }

    for(i in 1..goldBars.size){
        for(j in 1..capacity){
            if(goldBars[i - 1] <= j){
                array[i][j] = max(
                        array[i - 1][j],
                        goldBars[i - 1] + array[i - 1][j - goldBars[i - 1]]
                )
                /**
                 *  array[i][j] --> elemento da trovare
                 *
                 *  array[i - 1][j] -> elemento che sta subito sopra sopra
                 *
                 *  goldBars[i - 1] -> valore della barra correntemente in esame
                 *
                 *  array[i - 1][j - goldBars[i - 1] -> elemento della riga precedente con posizione
                 *                                      calcolata come "j - il valore della barra
                 *                                      trattato in questo momento"
                 */
            }else{
                array[i][j] = array[i - 1][j]
            }
        }
    }

    array.printMatrix()

    return array.last().last()
}

/**


        0   1   2   3   4   5   6   7   8   9   10

    0   0   0   0   0   0   0   0   0   0   0   0
    1   0   1   1   1   1   1   1   1   1   1   1
    4   0   1   1   1   4   5   5   5   5   5   5
    8   0   1   1   1   4   4   4   4   8   9   9

        i = 2
        j = 5

        max( 5, 8 + 1  )

        max ("Elemento subito sopra", "elemento della riga precedente con coordinata y ridotta del valore della barra corrente" )

        max( m[i-1, j], values[ i-1 ] +  M[ i-1, j - values[i-1]] )


    0   1   2
    1   4   8


*/