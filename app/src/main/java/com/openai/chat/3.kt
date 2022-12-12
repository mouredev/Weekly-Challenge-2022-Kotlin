package com.openai.chat

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función en Kotlin que se encargue de comprobar si un número es o no primo. Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Resuelto: Sí. A la primera.
 * Explicación:
 * · La función toma un entero como parámetro y devuelve un valor booleano indicando si el número es primo o no. Dentro de la función, primero se comprueba si el número es menor o igual a 1,
 * ya que los números menores o iguales a 1 no son considerados primos. A continuación, se itera desde el 2 hasta el número, excluyéndolo, y se comprueba si el número es divisible por algún otro número en ese rango.
 * Si se encuentra un número que lo divide, se devuelve false, ya que el número no es primo. Si se llega al final de la iteración y ningún número ha sido capaz de dividirlo, se devuelve true, ya que el número es primo.
 * · Para imprimir los números primos entre 1 y 100, puedes utilizar la función esPrimo() que acabamos de definir dentro de un bucle que itera desde el 1 hasta el 100, y dentro del bucle se imprime el número si
 * la función esPrimo() devuelve true para ese número.
 *
 */

fun esPrimo(num: Int): Boolean {
    if (num <= 1) {
        return false
    }

    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }

    return true
}

fun main() {
    for (i in 1..100) {
        if (esPrimo(i)) {
            println(i)
        }
    }
}



