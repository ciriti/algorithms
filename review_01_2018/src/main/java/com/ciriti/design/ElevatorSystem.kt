package com.ciriti.design

import com.ciriti.design.Floor.THIRD
import java.lang.RuntimeException
import java.security.InvalidParameterException

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {
  val elevator = ElevatorController(THIRD)
  val view = View()
  elevator.onfloorListener {
    println(it)
  }
  view.onClickListener {
    elevator.selectFloor(0)
    elevator.selectFloor(1)
    elevator.selectFloor(3)
  }
  view.click()
}

class View {
  private var clickListener: ((view: View) -> Unit)? = null
  fun onClickListener(func: (view: View) -> Unit) {
    clickListener = func
  }

  fun click() {
    clickListener?.invoke(this)
  }
}

interface IElevator {
  fun selectFloor(floors: Int)
}

class ElevatorController(var floorState: Floor = Floor.GROUND) : IElevator {

  private var floorListener: ((floor: Floor) -> Unit)? = null

  fun onfloorListener(func: (floor: Floor) -> Unit) {
    floorListener = func
  }

  override fun selectFloor(floor: Int) {
    floor.checkRange(0, Floor.THIRD.ordinal)
    while (floorState.ordinal != floor) {
      when {
        floorState.ordinal < floor -> {
          floorState = floorState.next()
          floorListener?.invoke(floorState)
        }
        else -> {
          floorState = floorState.prev()
          floorListener?.invoke(floorState)
        }
      }
    }
  }
}

fun Int.checkRange(
  min: Int,
  max: Int,
  exception: RuntimeException = InvalidParameterException("Floor not valid")
) = when {
  this < min -> throw exception
  this > max -> throw exception
  else -> this
}

enum class Floor {

  GROUND {
    override fun prev() = NOTHING
    override fun next() = FIRST
  },
  FIRST {
    override fun prev() = GROUND
    override fun next() = SECOND
  },
  SECOND {
    override fun prev() = FIRST
    override fun next() = THIRD
  },
  THIRD {
    override fun prev() = SECOND
    override fun next() = NOTHING
  },
  NOTHING {
    override fun prev() = THIRD
    override fun next() = GROUND
  };

  abstract fun prev(): Floor
  abstract fun next(): Floor
}


fun main() {
  var state = Floor.GROUND
  while (state.next() != Floor.NOTHING) {
    println("$state -> ${state.next()}")
    println("${state.ordinal} -> ${state.next().ordinal}")
    state = state.next()
  }
  while (state.prev() != Floor.NOTHING) {
    println("$state -> ${state.prev()}")
    println("${state.ordinal} -> ${state.prev().ordinal}")
    state = state.prev()
  }
}

//sealed class Floor(val floor : Int){
//    abstract fun prev() : Floor
//    abstract fun next() : Floor
//}
//class Ground : Floor(0){
//    override fun prev(): Floor = Ground()
//    override fun next(): Floor = First()
//}
//class First : Floor(1){
//    override fun prev(): Floor = Ground()
//    override fun next(): Floor = Second()
//}
//class Second : Floor(2){
//    override fun prev(): Floor = Ground()
//    override fun next(): Floor = Third()
//}
//class Third : Floor(3){
//    override fun prev(): Floor = Ground()
//    override fun next(): Floor = Ground()
//}
