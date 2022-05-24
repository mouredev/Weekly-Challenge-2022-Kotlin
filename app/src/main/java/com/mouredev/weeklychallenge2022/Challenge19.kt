package com.mouredev.weeklychallenge2022

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 */

fun main(){
    println(toMiliseconds(2,180, 4500, 2344323))
}

fun toMiliseconds(days : Int, hours : Int,minutes : Int, seconds : Int) : Long{
    val daysToMiliseconds = days.toLong() * 24 * 60 * 60 * 1000
    val hoursToMiliseconds = hours.toLong() * 60 * 60 * 1000
    val minutesToMiliseconds = minutes.toLong() * 60 *1000
    val secondsToMiniSeconds = seconds.toLong() * 1000
    return daysToMiliseconds + hoursToMiliseconds + minutesToMiliseconds + secondsToMiniSeconds
}