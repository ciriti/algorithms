package com.ciriti.kotlin

import com.ciriti.printAll

/**
 * Created by Carmelo Iriti
 */

fun main(args: Array<String>) {

    listOf(1, 2, 3, 4, 5, 6).printAll()

    /**
     * Map
     *
     * With map(), each input Array element is translated to exactly one output element.
     * That is, f returns a single value.
     *
     */
    listOf(1, 2, 3, 4, 5, 6)
            .map {
                if (it % 2 == 0) {
                    listOf(it * 2, 6)
                } else {
                    listOf(it * 2)
                }
            }.printAll()

    /**
     * FlatMap - https://martinfowler.com/articles/collection-pipeline/flat-map.html
     *
     * Map a function over a collection and flatten the result by one-level
     *
     */
    listOf(1, 2, 3, 4, 5, 6)
            .flatMap {
                if (it % 2 == 0) {
                    listOf(it * 2, 6)
                } else {
                    listOf(it * 2)
                }
            }
            .printAll()


}



