import java.util.*

/**
 * Created by ciriti
 */
fun main(args: Array<String>){
    val scan = Scanner(System.`in`)
    val pair = scan.nextIntPair()
    val dim = pair.first
    val cap = pair.second
    val list = mutableListOf<Bean>()
    for(i in 0 until dim){
        val a = scan.nextIntPair()
        list.add(Bean(a.first.toDouble(), a.second.toDouble()))
    }
    println(getOptimalValue(cap, list.toTypedArray()).fourDecimal())
}

data class Bean(val value : Double, val weigh : Double){
    val unitPrice : Double
        get() { return value / weigh }
}

private fun getOptimalValue(capacity : Int, products : Array<Bean>) : Double{

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