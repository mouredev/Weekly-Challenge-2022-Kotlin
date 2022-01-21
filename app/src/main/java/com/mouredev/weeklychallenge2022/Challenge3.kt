package com.mouredev.weeklychallenge2022

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {


    if(numPrim(3)){
        println("El numero es prim")
    }else{
        println("El numero no es prim")
    }

    for (index in 1..100){
        if(numPrim(index)) println(index)
    }
}

fun numPrim (num : Int): Boolean{

    //Primo es cuando se divide solo entre 1 y entre el mismo entre ninguno mas
    //Indica el numero en la llamada de la funcion
    //Recorrer el array hasta el numero indicado
    //El 1 no es primo
    var prim = true
        for(index in 2 until num){
               if(num % index == 0){
                   prim = false
               }
        }
    return prim
}
