package com.mouredev.weeklychallenge2022

/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Triángulo de Pascal
 */

fun main(){
    drawPascalTriangle(3)
    drawPascalTriangle(5)
    drawPascalTriangle(6)
}

/**
 * Funcion que realiza la operacion matematica de combinacion de dos elementos
 * @param n primer elemento que se quiere combinar
 * @param k segundo elemento que se quiere combinar
 * @return resultado de la combinacion de los dos elementos
 */
private fun combination(n: Int, k: Int): Int {
    return factorial(n) / (factorial(k) * factorial(n - k))
}

/**
 * Funcion que calcula el factorial de un numero
 * @param n numero del que se quiere calcular el factorial
 * @return factorial del numero
 */
private fun factorial(n: Int): Int {
    return if (n <= 1) 1 else n * factorial(n - 1)
}

/**
 * Funcion que calcula el triangulo de pascal
 * @param size tamaño del triangulo
 * @return triangulo de pascal
 */
fun pascalTriangle(size: Int): List<Int> {
    val triangle = mutableListOf<Int>()
    for (i in 0 until size) {
        for (j in 0..i) {
            triangle.add(combination(i, j))
        }
    }
    return triangle
}


/**
 * Funcion que dibuja el triangulo de pascal
 * @param size tamaño del triangulo
 * @return triangulo de pascal dibujado
 */
fun drawPascalTriangle(size: Int) {
    println("Pascal Triangle of size $size")
    val triangle = pascalTriangle(size)
    var index = 0
    for (i in 0 until size) {
        println(" ".repeat(size - i) + triangle.subList(index, index + i + 1).joinToString(" "))
        index += i + 1
    }
    println("*".repeat(size*3))
}



