package week1

import utils.FastScanner

/**
 * Created by ciriti
 */

fun main(args : Array<String>){
    val scanner = FastScanner(System.`in`)
    val dim = scanner.nextInt()

    if (dim < 2){
        System.out.println("No pairs exists")
        return
    }

    val arr = IntArray(dim)
    for( i in 0..(dim-1)){
        arr[i] = scanner.nextInt()
    }
    println(maxPairWiseProduct2(arr))
}

fun maxPairWiseProduct2(arr : IntArray) : Long{
    val copy = arr.copyOf().sortedDescending()
    return copy[0].toLong() * copy[1].toLong()
}

fun maxPairWiseProduct(arr : IntArray) : Long{
    var maxIndex1 : Int = -1
    var maxIndex2 : Int = -1

    for(i in 0..(arr.size-1)){
        if(maxIndex1 == -1 || arr[i] > arr[maxIndex1]){
            maxIndex1 = i
        }else{
            maxIndex2 = i
        }
    }

    for(i in 0..(arr.size-1)){
        if(arr[i] > arr[maxIndex2] && i != maxIndex1){
            maxIndex2 = i
        }
    }

    return arr[maxIndex2].toLong() * arr[maxIndex1].toLong()
}
