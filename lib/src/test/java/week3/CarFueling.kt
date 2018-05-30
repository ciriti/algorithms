package week3

import org.junit.Assert
import org.junit.Test
import java.util.*

/**
 * Created by ciriti
 */
/**
    * Week 3 , Algorythm Design Course Coursera
    *
    * Design an algorythm that computes the minimum Number of Refills that a car must make to reach
    * the destination .
    *
    * INPUT :
    *       An Integer Array giving the distance of the GasStations from the Starting point ,
    *       An Integer that gives the maximum distance that the car can travel on a full refill
    *
    *  OUTPUT:
    *      The Minimum Number of refills , that the car must make.
    *
    *  Link: https://codereview.stackexchange.com/questions/129941/implementation-of-the-minimum-stop-algorithm-in-javascript
    */
fun getLeastRefills(stationDist : Array<Int>, maxDistance : Int) : Int{

    var kmPercorsi = 0
    var refillNumber = 0
    var index = 1
    do{
        if(maxDistance + kmPercorsi < stationDist[index]){
            kmPercorsi = stationDist[index-1]
            refillNumber++
        }
        index++
    }while(index < stationDist.size)

    return refillNumber
}
fun getLeastRefillsTester(stationDist : Array<Int>, maxDistance : Int) : Int{
    var curPos = 1
    var minRefill = 0
    var curDistance = maxDistance
    var numRefillStations = stationDist.size - 1

    while (curPos <= numRefillStations) {
        while(curPos < stationDist.size && stationDist[curPos] <= curDistance){
            curPos += 1
        }

        if (curPos > numRefillStations) return minRefill

        curPos -= 1
        minRefill += 1
        curDistance = stationDist[curPos] + maxDistance;
    }

    if (stationDist[curPos] < curDistance)
        minRefill += 1

    return minRefill
}

class CarFueling{

    @Test
    fun stress(){
        var maxIncr = 10
        var start = System.currentTimeMillis()
        while(System.currentTimeMillis() - start < 5000){
            var dim = Random().nextInt(100) + 10
            var arr = IntArray(dim)
            arr[0] = 0
            for(i in 1 until dim){
                var inc = Random().nextInt(maxIncr) + 1
                arr[i] = arr[i-1] + inc
            }
            maxIncr += (Random().nextInt(10) + 2)
            println("dim $dim arr ${arr.toList()}")
            var speed1 = System.currentTimeMillis()
            var res1 = getLeastRefills(arr.toTypedArray(), maxIncr)
            speed1 = System.currentTimeMillis() - speed1
            var speed2 = System.currentTimeMillis()
            var res2 = getLeastRefillsTester(arr.toTypedArray(), maxIncr)
            speed2 = System.currentTimeMillis() - speed2
            println("$res1 $res2")
            println("my: $speed1 tester: $speed2")
            Assert.assertTrue(res1 == res2)
        }
    }

    @Test
    fun t2(){
        Assert.assertEquals( 6, getLeastRefillsTester(arrayOf(0, 5, 8, 9, 12, 16, 20, 23, 24, 28), 6))
        Assert.assertEquals( 6, getLeastRefills(arrayOf(0, 5, 8, 9, 12, 16, 20, 23, 24, 28), 6))
    }
    @Test
    fun t1(){
        Assert.assertEquals(2, getLeastRefillsTester(arrayOf(0, 200, 375, 550, 750, 950), 400))
        Assert.assertTrue(getLeastRefills(arrayOf(0, 200, 375, 550, 750, 950), 400) == getLeastRefillsTester(arrayOf(0, 200, 375, 550, 750, 950), 400))
    }

}