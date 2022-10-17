package com.mouredev.weeklychallenge2022

import org.junit.Assert
import org.junit.Test

internal class challenge {



    @Test
    fun `Ohm law V=1,0 , R=10,0`() {
        Assert.assertEquals("0.10", ohmLaw(1.0, 10.0))

    }

    @Test
    fun `Ohm law R=12,0 , I=10,0`() {
        Assert.assertEquals("120.00",ohmLaw(null,12.0, 10.0))

    }
    @Test
    fun `Ohm law V=1,4 , I=5,2`() {
        Assert.assertEquals("7.28",ohmLaw(1.4,null, 5.2))

    }
    @Test
    fun `Ohm law V=1,0`() {
        Assert.assertEquals("Params error or insufficient",ohmLaw(1.0,null))

    }
}