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

fun main() {
    Circuit(r = 12.0, v = 150.0).ohmLaw()
    Circuit(i = 2.0, r = 200.0).ohmLaw()
    Circuit(v = 12.5, i = 0.5).ohmLaw()
    Circuit(v = 12.5).ohmLaw()
    Circuit(v = 12.5, i = 3.0, r = 20.0).ohmLaw()
}

private class Circuit(val r : Double? = null, val v: Double? = null, val i: Double? = null){

    fun ohmLaw(): Double{

        val twoDecimalFormat = DecimalFormat("#.##")
        var result = 0.0

        if(i == 0.0){
            println("No current, open circuit")
        } else if (v == 0.0){
            println("No voltage = no current")
        } else if (r == 0.0){
            println("No resistance, short circuit")
        } else {
            result =  when {
                (r == null && v != null && i != null ) -> {
                    print("With V = $v and I = $i the R = ")
                    v/i
                }
                (v == null && r != null && i != null ) -> {
                    print("With R = $r and I = $i the V = ")
                    r*i
                }

                (i == null && v != null && r != null ) -> {
                    print("With V = $v and R = $r the I = ")
                    v/r
                }

                else -> {
                    println("Wrong input")
                    0.0
                }
            }
        }

        if (result != 0.0)
            println(twoDecimalFormat.format(result))

        return result
    }

}