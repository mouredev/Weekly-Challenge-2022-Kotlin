package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test

internal class Challenge47 {



    @Test
    fun `return vowel 'a' `() {
        val mostCommonVowel = mostCommonVowel("El ingenioso hidalgo Don Quijote de la Mancha\\\" En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor")
        Assert.assertEquals(mostCommonVowel,"a")
    }

    @Test
    fun `return vowel 'o' `() {
        val mostCommonVowel = mostCommonVowel("¿Son robos o sobornos?")
        Assert.assertEquals(mostCommonVowel,"o")
    }

}