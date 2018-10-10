package com.ciriti.design

/**
 * Created by Carmelo Iriti
 */

fun main(args : Array<String>){
    var state = Floor_.GROUND
    while(state.next() != Floor_.NOTHING){
        println("$state -> ${state.next()}")
        println("${state.ordinal} -> ${state.next().ordinal}")
        state = state.next()
    }
    while(state.prev() != Floor_.NOTHING){
        println("$state -> ${state.prev()}")
        println("${state.ordinal} -> ${state.prev().ordinal}")
        state = state.prev()
    }
}

class  Elevator{

    var floorState : Floor_ = Floor_.GROUND
    var floorSelected : MutableSet<Floor_> = mutableSetOf()

    var floorListener : ((floor : Floor_)-> Unit)? = null
    var stateListener : ((floor : Floor_)-> Unit)? = null

    fun selectFloor(nextFloor : Int){

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

enum class Floor_{

    GROUND{
        override fun prev() = NOTHING
        override fun next() = FIRST
    },
    FIRST{
        override fun prev() = GROUND
        override fun next() = SECOND
    },
    SECOND{
        override fun prev() = FIRST
        override fun next() = THIRD
    },
    THIRD{
        override fun prev() = SECOND
        override fun next() = NOTHING
    },NOTHING{
        override fun prev() = THIRD
        override fun next() = GROUND
    };

    abstract fun prev() : Floor_
    abstract fun next() : Floor_
}
