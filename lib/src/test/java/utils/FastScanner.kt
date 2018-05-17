package utils

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

/**
 * Created by ciriti
 */
class FastScanner(stream : InputStream) {

    var br : BufferedReader
    var st : StringTokenizer? = null

    init {
        br = BufferedReader(InputStreamReader(stream))
    }

    fun next() : String {
        while(st == null || !(st!!.hasMoreTokens())) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e : IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }


    fun nextInt() : Int {
        return Integer.parseInt(next())
    }

    fun nextLong() : Long {
        return next().toLong()
    }
}