package com.mouredev.weeklychallenge2022

/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/**
 * Metodo principal que ejecuta el programa
 */
fun main(){

    println("Dados a = 270 y b = 192  -> MCD : ${MCD(270,192)} y mcm : ${mcm(270,192)}")
    println("Dados a = 150 y b = 39  -> MCD : ${MCD(150,39)} y mcm : ${mcm(150,39)}")
    println("Dados a = 1032 y b = 180  -> MCD : ${MCD(1032,180)} y mcm : ${mcm(1032,180)}")

}

/**
 * Funcion que calcula el maximo comun divisor de dos numeros utilizando el algoritmo de Euclides
 * @param a numero entero para calcular el MCD
 * @param b numero entero para calcular el MCD
 * @return el maximo comun divisor de a y b
 */
fun MCD(a: Int, b: Int): Int {
    if(b==0) return a
    return algoritmoEuclides(b, a % b)
}

/**
 * Funcion que calcula el minimo comun multiplo de dos numeros utilizando el algoritmo de Euclides
 * @param a numero entero para calcular el mcm
 * @param b numero entero para calcular el mcm
 * @return el minimo comun multiplo de a y b
 */
fun mcm(a: Int, b: Int): Int {
    return a * b / algoritmoEuclides(a, b)
}

/**
 * Funcion que implementa el algoritmo de Euclides utlizando recursividad
 * Algoritmo de Euclides: Metodo para calcular rapidamente el MCD de dos numeros y de forma eficiente
 * @param a: Primer numero entero para aplicar el algoritmo
 * @param b: Segundo numero entero para aplicar el aloritmo
 * @return: Retorna el resultado de aplicar el algoritmo de Euclides a los numeros dados
 */
private fun algoritmoEuclides(a: Int, b: Int): Int {
    if(a == 0) return b
        return algoritmoEuclides(b % a, a)

}

