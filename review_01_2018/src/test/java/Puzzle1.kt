import org.junit.Test

/**
 * Created by ciriti
 */
open class C {
    open fun sum(x: Int = 1, y: Int = 2): Int{
        return x + y
    }
}

class D : C() {
    override fun sum(y: Int, x: Int): Int{
        return super.sum(x, y)
    }
}

open class Parent(open val a: String) {
    init { print(a) }
}

class Children(override val a: String): Parent(a)

open class A(val x: Any?)

object B1 : A(C1)
object C1 : A(B1)

class Puzzle{

    @Test
    fun p1() {
        val d: D = D()
        val c: C = d
        print(c.sum(x = 0))
        print(d.sum(x = 0))
    }
    @Test
    fun p2() {
        Children("abc")
    }
    @Test
    fun p3() {
        println(B1.x)
        println(C1.x)
    }


}
