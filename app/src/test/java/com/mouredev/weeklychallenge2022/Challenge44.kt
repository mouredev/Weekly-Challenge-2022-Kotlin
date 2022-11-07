package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test

internal class Challenge44 {



    @Test
    fun `return 2 boomerangs {2, 1, 2}, {2,4,2} ,{4, 2, 4} `() {
        Assert.assertArrayEquals(arrayOf("{2, 1, 2}","{2, 4, 2}","{4, 2, 4}"), boomerangs(arrayOf(2,1,2,4,2,4)))
    }

    @Test
    fun `return 3 boomerangs {a, b, a}, {d, a, d}, {d, b, d} `() {
        Assert.assertArrayEquals(arrayOf("{a, b, a}","{d, a, d}","{d, b, d}"), boomerangs(arrayOf('a', 'b', 'a', 'c', 'c', 'd', 'a', 'd', 'b', 'd')))

    }

}