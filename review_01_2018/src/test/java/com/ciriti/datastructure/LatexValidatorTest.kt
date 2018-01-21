package com.ciriti.datastructure

import org.junit.Assert
import org.junit.Test
import util.ResourcesReader.Companion.file2Rows
import util.ResourcesReader.Companion.tex

/**
 * Created by ciriti
 */
class LatexValidatorTest {

    val validator = LatexValidator()

    @Test(expected = RuntimeException::class)
    fun verifyTEX(){
        validator.verifyTEX("MA-Arbeit_16.1.ERROR.tex")
    }
    @Test
    fun file2Rows(){
        var list = file2Rows("line_reader.txt")
        Assert.assertEquals(3, list.size)
    }

    @Test
    fun rowWithError(){
        var list = file2Rows("line_reader.txt")
        var pair = validator.rowWithError(list, 8)
        Assert.assertEquals(1, pair.first)
    }

    @Test
    fun text_reader(){
        Assert.assertTrue(validator.isValidPair(tex("MA-Arbeit_16.1..tex")).first)
        Assert.assertFalse(validator.isValidPair(tex("MA-Arbeit_16.1.ERROR.tex")).first)
    }

    @Test
    fun isValid(){
        Assert.assertTrue(validator.isValidPair("() ").first)
        Assert.assertFalse(validator.isValidPair(") ").first)
        Assert.assertFalse(validator.isValidPair("( ").first)
        Assert.assertTrue(validator.isValidPair("lahjksdgf(fdgafdg) jha{asdfga[f]f} ").first)
        Assert.assertTrue(validator.isValidPair("").first)
        Assert.assertTrue(validator.isValidPair("\\section{Introduction}").first)
        Assert.assertFalse(validator.isValidPair("\\section{Introduction").first)
        Assert.assertTrue(validator.isValidPair("blabla blabla blabla.\\\\").first)
        Assert.assertFalse(validator.isValidPair("blabla blabla blabla.)\\\\").first)

    }

}