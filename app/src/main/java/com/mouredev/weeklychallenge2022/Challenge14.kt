package com.mouredev.weeklychallenge2022

import kotlin.math.pow

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/**
 * Funcion principal
 */
fun main(){

    printArmstrongNumber(153)
    printArmstrongNumber(370)
    printArmstrongNumber(8208)
    printArmstrongNumber(4210818)

}

/**
 * Funcion que imprime si un numero es armstrong o no
 * @param number numero a comprobar si es armstrong
 */
fun printArmstrongNumber(number:Int){
    if(number.isArmstrong()){
        println("$number Es un número de Armstrong")}
    else{
        println("$number No es un número de Armstrong")
    }
}

/**
 * Funcion de extension sobre Int que calcula si un numero es armstrong o no.
 * @return true si es armstrong, false si no lo es
 */
fun Int.isArmstrong():Boolean{
    var value=0
    this.toString().forEach {
        value += it.toString().toDouble().pow(this.toString().length.toDouble()).toInt()
    }

    return value==this
}


