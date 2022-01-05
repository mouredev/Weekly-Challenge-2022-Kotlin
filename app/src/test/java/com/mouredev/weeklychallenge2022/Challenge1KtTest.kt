package com.mouredev.weeklychallenge2022


import junit.framework.TestCase.assertEquals
import org.junit.Test



class Challenge1KtTest {
    @Test
    fun `"Trama" es un anagrama de "Marta"`() {
        assertEquals(isAnagram("Trama", "Marta"), true)
    }

    @Test
    fun `"Licúa" es una anagrama de "Lucía"`() {
        assertEquals(isAnagram("Licúa", "Lucía"), true)
    }

    @Test
    fun `"Ácido" es un anagrama de "acido"`() {
        assertEquals(isAnagram("Ácido", "acido"), true)
    }

    @Test
    fun `"Planeta" no es un anagrama de "tierra"`() {
        assertEquals(isAnagram("PLaneta", "tierra"), false)
    }

    @Test
    fun `"Nómade" es una anagrama de "Moneda"`() {
        assertEquals(isAnagram("Nómade", "Moneda"), true)
    }

    @Test
    fun `"El huevo de chocolate" es un anagrama de "hecho de vate locuelo"`() {
        assertEquals(isAnagram("El huevo de chocolate", "hecho de vate locuelo"), true)
    }
}
