package com.mouredev.weeklychallenge2022

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import kotlin.math.abs
/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    var num1 = "12/04/2022"
    var num2 = "14/11/1968"

    println("Entre $num1 y $num2 hay " + diferenciaDias (num1, num2) + " días")

    num1= "12-04/2022"
    num2= "14/11/1968"

    println("Entre $num1 y $num2 hay " + diferenciaDias (num1, num2) + " días")

    num1= ""
    num2= "14/11/1968"

    println("Entre $num1 y $num2 hay " + diferenciaDias (num1, num2) + " días")

    num1 = "20/04/1969"
    num2 = "14/11/1968"

    println("Entre $num1 y $num2 hay " + diferenciaDias (num1, num2) + " días")

}

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
fun diferenciaDias (num1: String, num2: String): Int? {
    val magic = 86400000L // millisec * sec * min * hours
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    try {
        val date1 = formatter.parse(num1)!!.time
        val date2 = formatter.parse(num2)!!.time

        val days = if ((date1<=0 && date2>0) ||
                        (date2<=0 && date1>0) ) {// para corregir si alguno es menor del 01/01/1970 que es el 0
            1 + (abs(date1 - date2)) / magic  // y no si lo son los dos
        }else{
            (abs(date1 - date2)) / magic
        }

        return days.toInt()

    } catch (e: Exception){
        print(e)
    }
    return null
}


