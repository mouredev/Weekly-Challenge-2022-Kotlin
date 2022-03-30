package com.mouredev.weeklychallenge2022

/*
 * Reto #13
 * FACTORIAL RECURSIVO
 * Fecha publicación enunciado: 28/03/22
 * Fecha publicación resolución: 04/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Funcion main
 */
fun main() {

    /* Calcula el factoral de los 10 primeros números */
    for(i in 0..10){
        println("$i!: ${factorial(i)}")
    }
}

/**
 * Función que recibe un entero y devuelve el factorial de forma recursiva
 * El factorial de un numero se refiere a los numero naturales positivos n>0.
 * En el caso que sea 0 su factorial es 1 por definicion
 * Si el numero fuera negativo devuelve -1
 * @param num entero
 * @return factorial de num
 */
fun factorial(num: Int): Int {
    return if(num>=0){
        if (num == 1 || num == 0) {
            1
        } else {
            factorial(num - 1) * num
        }
    }else{
        -1
    }

}

