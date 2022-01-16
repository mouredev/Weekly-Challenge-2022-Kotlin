package com.mouredev.weeklychallenge2022

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by amgdeveloper
 */
class challenge1Test {

    @Test
    fun `same word is not an anagram`() {
        assertFalse("night".isAnagramOf("night"))
    }

    @Test
    fun `reversed word is an anagram`() {
        assertTrue("night".isAnagramOf("thing"))
    }

    @Test
    fun `words with different length are not an anagram`() {
        assertFalse("night".isAnagramOf("thinga"))
    }

    @Test
    fun `all characters should be swapped`() {
        assertFalse("night".isAnagramOf("ngiht"))
    }

    @Test
    fun `all characters should be swapped, even if repeated characters`() {
        assertFalse("nighnt".isAnagramOf("nngiht"))
    }

    @Test
    fun `both words should contain the same characters`() {
        assertFalse("night".isAnagramOf("uhing"))
    }

}