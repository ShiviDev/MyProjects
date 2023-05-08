package com.example.dice

import org.junit.Assert.assertTrue
import org.junit.Test



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_num(){
        val dice= Dice(6)
        val rollresult= dice.roll()
        assertTrue("The value of roll result was not between one and six", rollresult in 1..6)
    }
}