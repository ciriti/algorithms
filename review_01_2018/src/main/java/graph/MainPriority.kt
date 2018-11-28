package graph

import com.ciriti.printThis
import java.util.PriorityQueue

/**
 * Created by Carmelo Iriti
 */

fun main(){
  val p = PriorityQueue<MapPoint>(
      Comparator<MapPoint> { p1, p2 ->
        val c1 = p1.heuristicDistance.compareTo(p2.heuristicDistance)
//        val c2 = p1.second.compareTo(p2.second)
//        when{
//          c1 != 0 ->c1
//          c2 != 0 ->c2
//          else -> 0
//        }
        c1

  })

  (0 until p.size).forEach { p.poll().printThis() }

}