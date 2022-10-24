package com.mouredev.weeklychallenge2022

import org.junit.Assert
import org.junit.Test

internal class challenge {



    @Test
    fun `Convert Temperature 12°C to °F`() {
        Assert.assertEquals("53.6°F", temperatureConverter("12°C"))

    }

    @Test
    fun `Convert Temperature -4,2°F to °C`() {
        Assert.assertEquals("-20.11111111111111°C", temperatureConverter("-4.2°F"))

    }

}