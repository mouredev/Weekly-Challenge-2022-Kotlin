package com.mouredev.weeklychallenge2022

import java.text.DecimalFormat

/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Funcion principal
 */
fun main(){
    println(ohmLaw(v=1.0, r=10.0))
    println(ohmLaw(v=null,r=12.0, i=10.0))
    println(ohmLaw(v=1.4,r=null, i=5.2))
    println(ohmLaw(v=1.0,r=null))
}

/**
 * Funcion que calcula la ley de Ohm , en funcion de los parametros que se le pasen.
 * I = V / R
 * V = I * R
 * R = V / I
 * @param V Valor del voltaje
 * @param R Valor de la Resistencia
 * @param I Valor de la Intensidad
 * @returns Devuelve el valor calculado en funcion de los parametros dados
 */
fun ohmLaw(v: Double? = null , r: Double? =null, i: Double? =null): String {


    v?.let {
        r?.let {
            return ((v / r).roundDecimal(2))

        }
        i?.let {
            return (v * i).roundDecimal(2)
        }
    }
    r?.let {
        i?.let {
            return (r*i).roundDecimal(2)

        }
    }

    return "Params error or insufficient"
}

fun Double.roundDecimal(digit: Int) = "%.${digit}f".format(this).replace(",", ".")

