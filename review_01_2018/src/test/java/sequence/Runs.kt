package sequence

/**
 * Created by carmeloiriti on 03.05.18.
 */

/*
 * Any array may be viewed as a number of "runs" of equal numbers.
 * For example, the following array has two runs:
 *   1, 1, 1, 2, 2
 * Three 1's in a row form the first run, and two 2's form the second.
 * This array has two runs of length one:
 *   3, 4
 * And this one has five runs:
 *   1, 0, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0
 * Your task is to implement the runs() function so that it returns the number
 * of runs in the given array.
 */

import junit.framework.Assert
import org.junit.Test

class Tests {

    @Test fun testRuns1() {
        test(0)
    }

    @Test fun testRuns2() {
        test(1, 1)
    }

    @Test fun testRuns3() {
        test(3, 1, 2, 3)
    }

    @Test fun testRuns4() {
        test(3, 1, 2, 2, 3)
    }

    @Test fun testRuns5() {
        test(3, 1, 1, 2, 3)
    }

    @Test fun testRuns6() {
        test(1, 1, 1, 1, 1)
    }

    @Test fun testRuns7() {
        test(3, 1, 1, 1, 0, 1, 1)
    }

    @Test fun testRuns8() {
        test(3, 1, 1, 1, 0, 1)
    }

    @Test fun testRuns9() {
        test(5, 1, 0, 1, 0, 1)
    }
}

fun runs(a: IntArray): Int {

    if(a.isEmpty()) return 0
    val iterator = a.iterator()
    var count = 1
    var temp = iterator.nextInt()

    iterator.forEach {
        if(it != temp){
            count++
            temp = it
        }
    }

    return count
}

fun test(expected: Int, vararg data: Int) {
    Assert.assertEquals(expected, runs(data))
}