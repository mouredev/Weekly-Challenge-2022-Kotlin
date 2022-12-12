package com.mouredev.weeklychallenge2022


import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

internal class Challenge49 {



    @Test
    fun ` return moure handlers `() {
        val handlers = handleDetector("Retos de programacion : (https://mouredev.com/discord) #reto-semanal #reto49 #MoureDev @malopezrom @mouredev https://mouredev.com .moure.es https://retosdeprogramacion.com/semanales2022 #retosdeprogramacion")
        Assert.assertEquals(handlers, listOf("@malopezrom","@mouredev", "#reto-semanal", "#reto49", "#MoureDev", "#retosdeprogramacion", "https://mouredev.com/discord)","https://mouredev.com", "https://retosdeprogramacion.com/semanales2022"))
    }

    @Test
    fun `return relax handlers `() {
        val handlers = handleDetector("Hola a todos! Hoy es un día hermoso y estoy muy emocionada. #feliz #sol #playa.Estoy disfrutando de un día de descanso en la playa con mis amigos @paula @juan @maria.No puedo esperar para compartir fotos en mis redes sociales con todos ustedes. #friends #beachday #relax")
        Assert.assertEquals(handlers, listOf("@paula", "@juan", "@maria", "#feliz", "#sol", "#playa", "#friends", "#beachday", "#relax"))
    }

}