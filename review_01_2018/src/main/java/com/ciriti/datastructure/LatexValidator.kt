package com.ciriti.datastructure

import com.google.common.io.ByteSource
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

/**
 * Created by ciriti
 */
class LatexValidator {

    var stack : Deque<Char> = ArrayDeque<Char>()

    fun verifyTEX(fileName : String) : String {
        var s = readFile(fileName)
        var pair = isValidPair(s)
        if(!pair.first){
            var list = file2Rows(fileName)
            var row = rowWithError(list, pair.second).first
            throw RuntimeException("FILE NOT VALID!!! error in row $row")
        }
        return "FILE is VALID!"
    }

    fun file2Rows(jsonName : String) : List<String>{
        val inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonName)
        val br = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
        var line: String?
        var res = mutableListOf<String>()

        do{
            line = br.readLine() ?: break
            res.add(line)
        }while ( line != null)

        br.close()

        return res
    }

    fun readFile(fileName : String) : String{
            val inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)
            val byteSource = object : ByteSource() {
                override fun openStream(): InputStream {
                    return inputStream
                }
            }

            return byteSource.asCharSource(Charsets.UTF_8).read()
    }

    fun isValid(s: String): Boolean {

        stack.clear()

        for(c in s.toCharArray()){
            detector(c) ?: return false
        }

        return stack.isEmpty()
    }

    fun isValidPair(s: String): Pair<Boolean, Int> {

        stack.clear()

        for(c in 0 .. (s.toCharArray().size - 1)){
//            detector(s[c]) ?: return Pair(false, c)
            if(detector(s[c])== null){
                println()
                return Pair(false, c)
            }
        }
        println()
        return Pair(stack.isEmpty(), -1)
    }

    fun rowWithError(rowsList : List<String>, errorPos : Int) : Pair<Int, String>{
        var rowNumber = 0
        var count = 0
        var row = ""

        for(s in rowsList){
            count += s.length
            if(errorPos < count) break
            row = s
            rowNumber++
        }

        return Pair(rowNumber, row)
    }

    fun detector(c : Char) : Boolean?{
        return when(c){
            '[', '{', '(' -> {
                stack.push(c)
                true
            }

            ']' -> when(stack.peek()){
                '[' -> {
                    stack.pop()
                    true
                }
                else -> null
            }
            '}' -> when(stack.peek()){
                '{' -> {
                    stack.pop()
                    true
                }
                else -> null
            }
            ')' -> when(stack.peek()){
                '(' -> {
                    stack.pop()
                    true
                }
                else -> null
            }
            else -> true
        }
    }

}