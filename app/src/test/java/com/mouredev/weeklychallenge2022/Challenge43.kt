package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test

internal class Challenge43 {



    @Test
    fun `return length treat array 40 `() {
        Assert.assertEquals(40, trickOrTreat(
            TrickOrTreat.TREAT, arrayOf(
                Person("Angel", 10, 145),
                Person("Miguel Angel", 42, 178)
            )
        ).size)

    }

    @Test
    fun `return length trick array 19`() {
        Assert.assertEquals(19, trickOrTreat(
            TrickOrTreat.TRICK, arrayOf(
                Person("Carmen", 7, 124),
                Person("Brais", 38, 170)
            )
        ).size)

    }

}