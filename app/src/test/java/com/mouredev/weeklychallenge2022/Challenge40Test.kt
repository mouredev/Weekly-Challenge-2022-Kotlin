package com.mouredev.weeklychallenge2022

import org.junit.Assert
import org.junit.Test

internal class Challenge40Test {

    @Test
    fun `Pascal Triangle 3`() {
        Assert.assertArrayEquals(intArrayOf(1,1,1,1,2,1), pascalTriangle(3).toIntArray())

    }

    @Test
    fun `Pascal Triangle 7`() {
        Assert.assertArrayEquals(intArrayOf(1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, 1, 5, 10, 10, 5, 1, 1, 6, 15, 20, 15, 6, 1), pascalTriangle(7).toIntArray())

    }

}