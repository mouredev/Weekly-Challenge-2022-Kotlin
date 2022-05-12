package com.mouredev.weeklychallenge2022

import android.widget.Toast

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(){
    milisegundador(1,2,30,50)
    milisegundador()
    milisegundador(-20,70,5,10)
}

private fun milisegundador(dias : Int = 0, horas : Int = 0, minutos : Int = 0, segundos : Int = 0) : Long {
    var totalMilli : Long = 0
    var errorMessage = ""
    var resultMessage = "En |"

    if (dias in 1..364){
        totalMilli += dias*24*60*60*1000
        resultMessage += "$dias dias "
    }else if (dias !=0){
        errorMessage += "|dias fuera de rango|"
    }

    if (horas in 1..23){
        totalMilli += horas*60*60*1000
        resultMessage += "$horas horas "
    }else if (horas !=0){
        errorMessage += "|horas fuera de rango|"
    }

    if (minutos in 1..59){
        totalMilli += minutos*60*1000
        resultMessage += "$minutos minutos "
    }else if (minutos !=0){
        errorMessage += "|minutos fuera de rango|"
    }

    if (segundos in 1..59){
        totalMilli += segundos*1000
        resultMessage += "$segundos segundos "
    } else if (segundos !=0){
        errorMessage += "|segundos fuera de rango|"
    }

    if (errorMessage.isNotEmpty())
        println("Error : $errorMessage")

    if (resultMessage.length >4){
        resultMessage += "| Hay un total de $totalMilli ms"
        println(resultMessage)
    } else {
        println("No data")
    }

    return totalMilli
}
