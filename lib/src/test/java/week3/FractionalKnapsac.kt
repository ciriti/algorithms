package week3

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */
fun getOptimalValue(capacity : Int, products : Array<Bean>) : Double{

    var weighBag = capacity
    var sum = 0.0
    println(products.toList())
    val sList = products.sortedWith(Comparator { o1, o2 -> o2.unitPrice.toInt() - o1.unitPrice.toInt() })
    var index = 0
    while(weighBag > 0 && index < sList.size){
        if(weighBag < sList[index].weigh){
            sum += weighBag * sList[index].unitPrice
            break
        }else{
            sum += sList[index].weigh * sList[index].unitPrice
            weighBag -= sList[index].weigh.toInt()
        }
        index++
    }
    return sum

}

data class Bean(val value : Double, val weigh : Double){
    val unitPrice : Double
    get() { return value / weigh }
}

class FractionalKnapsacTest{

    @Test
    fun stress(){
        var dim = Random().nextInt(100) + 10
        var mutArr = mutableListOf<Bean>()
        while(dim-- > 0){
            mutArr.add(Bean((Random().nextInt(60) + 60).toDouble(), (Random().nextInt(40) + 20).toDouble()))
        }
        val capacity = Random().nextInt(60) + 30
        val res = getOptimalValue(capacity, mutArr.toTypedArray())
        val res1 = getOptimalValueTester(capacity, mutArr.map { it.value.toInt() }.toIntArray(), mutArr.map { it.weigh.toInt() }.toIntArray())
        println("res: $res - res1: $res1")
        Assert.assertTrue(res.toInt() == res1.toInt())
    }
    @Test
    fun t1(){
        println(12)
    }

}

private fun getMaxIndex(weights: IntArray, values: IntArray): Int {
    var max_i = 0
    var max = 0.0

    for (i in weights.indices) {
        if (weights[i] != 0 && values[i].toDouble() / weights[i] > max) {
            max = values[i].toDouble() / weights[i]
            max_i = i
        }
    }
    return max_i
}

private fun getOptimalValueTester(capacity: Int, values: IntArray, weights: IntArray): Double {
    var capacity = capacity
    var value = 0.0

    for (i in weights.indices) {
        if (capacity == 0)
            return value
        val index = getMaxIndex(weights, values)
        val a = Math.min(capacity, weights[index])
        value += a * values[index].toDouble() / weights[index]
        weights[index] -= a
        capacity -= a
    }
    return value
}