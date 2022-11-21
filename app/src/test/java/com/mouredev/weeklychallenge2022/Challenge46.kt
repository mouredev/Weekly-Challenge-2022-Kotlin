package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test

internal class Challenge46 {



    @Test
    fun `return position x = -5 , y = 12  `() {
        val robot = Robot()
        robot.move(arrayOf(10, 5, -2))
        Assert.assertEquals(Pair(-5,12),robot.coordenates())
    }

    @Test
    fun `return position x = 0 , y = 10  `() {
        val robot = Robot()
        robot.move(arrayOf(5,10,-5,10))
        Assert.assertEquals(Pair(0,10),robot.coordenates())

    }

}