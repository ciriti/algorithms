package graph

import com.ciriti.printThis
import java.util.PriorityQueue

/**
 * Created by Carmelo Iriti
 */

fun main(){
  val p = PriorityQueue<Pair<Int, Int>>(
      Comparator<Pair<Int, Int>> { p1, p2 ->
        val c1 = p1.first.compareTo(p2.first)
        val c2 = p1.second.compareTo(p2.second)
        when{
          c1 != 0 ->c1
          c2 != 0 ->c2
          else -> 0
        }

  })
  p.add(Pair(9,0))
  p.add(Pair(8,0))
  p.add(Pair(7,4))
  p.add(Pair(7,2))
  p.add(Pair(6,0))

  (0 until p.size).forEach { p.poll().printThis() }

}