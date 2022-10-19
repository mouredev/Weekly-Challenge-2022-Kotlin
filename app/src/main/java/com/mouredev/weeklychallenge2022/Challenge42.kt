package com.mouredev.weeklychallenge2022

/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main(){

    temperatura("30ºC")//86ºF
    temperatura("86ºF")//30ºC
    temperatura("hola")//error
    temperatura("234ºW")
    temperatura("hola mundo F")//error
    temperatura("paracetamolºC")//error
    temperatura("50ºtonto")//error
}

private fun temperatura(temp: String) {

    if(temp.matches(Regex("[0-9]+º[FC]"))){
        val num = Integer.parseInt(temp.split("º")[0])

        if(temp.endsWith("ºF")){
            println(""+((num-32)/1.8).toInt()+"ºC")
        }else if(temp.endsWith("ºC")){
            println(""+((num*9/5)+32).toInt()+"ºF")
        }

    }else{
        println("ERROR DE ESCRITURA")
    }

//Mi primer ejercicio en Kotlin
}




