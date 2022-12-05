package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

internal class Challenge48 {



    @Test
    fun ` return gift  `() {
        val gift = getGift(LocalDateTime.parse("2022-12-01T00:00:00"))
        Assert.assertEquals(gift,"🍰")
    }

    @Test
    fun `return 10 days `() {
        val days = daysLeft(LocalDateTime.parse("2022-12-11T00:00:00"),LocalDateTime.parse("2022-12-01T00:00:00"))
        Assert.assertEquals(days,10)
    }

}
