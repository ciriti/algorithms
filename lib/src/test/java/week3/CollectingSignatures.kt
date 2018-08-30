package week3

import java.util.*

/**
 * Created by ciriti
 */
data class Segment private constructor(val start : Int, val end : Int){
    companion object {
        fun create(pair : Pair<Int, Int>) = Segment(pair.first, pair.second)
    }
}

fun optimalPoints(segments : List<Segment>) : List<Int>{

    val sortedSegment = segments.sortedWith(Comparator { o1, o2 -> o1.end - o2.end })

    println(sortedSegment)

    val iterator = sortedSegment.iterator()

    var curr = iterator.next()
    val resArr = mutableSetOf<Int>()

    iterator.forEach { seg ->

        if(seg.start > curr.end){
            resArr.add(curr.end)
            curr = seg
        }else{
            resArr.add(Math.min(curr.end, seg.end))
        }

    }

    resArr.add(curr.end)

    return resArr.toList()
}

private fun optimalPointsTester(segments: Array<Segment>): IntArray {
    val points = IntArray(2 * segments.size)

    Arrays.sort(segments, object : Comparator<Segment> {
        override fun compare(s1: Segment, s2: Segment): Int {
            return Integer.compare(s1.end, s2.end)
        }
    })
    var point = segments[0].end
    points[0] = point

    var j = 1
    for (i in 1 until segments.size) {
        if (point < segments[i].start || point > segments[i].end) {
            point = segments[i].end
            points[j] = point
            j++
        }
    }
    val pointsFinal = IntArray(j)
    for (i in 0 until j) {
        pointsFinal[i] = points[i]
    }
    return pointsFinal
}

//class SegmentsTest{
//
//    @Test
//    fun stress(){
//        val start = laps()
//        var input = mutableListOf<Segment>()
//        while(laps() - start < 3000){
//            input.clear()
//            for(i in 0 until 5){
//                val a = Random().nextInt(100) + 1
//                input.add(Segment.create(Pair(a, (a + Random().nextInt(10) + 5))))
//            }
//            val res1 = optimalPoints(input)
//            val res2 = optimalPointsTester(input.toTypedArray())
//            println("input ${input.sortedWith(kotlin.Comparator { o1, o2 -> o1.start - o2.end })}")
//            println("res1 $res1 - res2 ${res2.toList()}")
//            Assert.assertTrue(res1.size == res2.size)
//            for(i in res1.indices){
//                Assert.assertTrue(res1[i] == res2[i])
//            }
//        }
//    }
//
//    @Test
//    fun t4(){
//        val input = listOf(
//                Segment.create(Pair(46, 58)),
//                Segment.create(Pair(48, 56))
//        )
//        println(optimalPoints(input))
//    }
//
//    @Test
//    fun t3(){
//        val input = listOf(
//                Segment.create(Pair(4,7)),
//                Segment.create(Pair(1,3)),
//                Segment.create(Pair(5,6)),
//                Segment.create(Pair(2,5))
//        )
//        println(optimalPointsTester(input.toTypedArray()).toList())
//    }
//
//    @Test
//    fun t2(){
//        val input = listOf(
//                Segment.create(Pair(4,7)),
//                Segment.create(Pair(1,3)),
//                Segment.create(Pair(5,6)),
//                Segment.create(Pair(2,5))
//        )
//        println(optimalPoints(input))
//    }
//
//    @Test
//    fun t2_1(){
//        val input = listOf(
//                Segment.create(Pair(15, 26)),
//                Segment.create(Pair(25, 38)),
//                Segment.create(Pair(44, 49)),
//                Segment.create(Pair(59, 71)),
//                Segment.create(Pair(75, 87))
//        )
//        val res = optimalPoints(input)
//        println(res)
//        Assert.assertEquals("[26, 49, 71, 87]", res.toString())
//    }
//
//    @Test
//    fun t2_2(){
//        val input = listOf(
//                Segment.create(Pair(46, 58)),
//                Segment.create(Pair(48, 56)),
//                Segment.create(Pair(60, 67)),
//                Segment.create(Pair(88, 93)),
//                Segment.create(Pair(98, 111))
//        )
//        val res = optimalPoints(input)
//        println(res)
//        Assert.assertEquals("[56, 67, 93, 111]", res.toString())
//    }
//
//    @Test
//    fun t1(){
//        val input = listOf(
//                Segment.create(Pair(1,3)),
//                Segment.create(Pair(2,5)),
//                Segment.create(Pair(3,6))
//        )
//        println(optimalPoints(input))
//    }
//}