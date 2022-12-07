""" package com.mouredev.weeklychallenge2022

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

fun main() {
    println(mcd(56, 180))
    println(mcdRecursive(56, 180))
    println(mcm(56, 180))
}

private fun mcd(firstNumber: Int, secondNumber: Int): Int {

    var a = firstNumber
    var b = secondNumber

    while (a != 0 && b != 0) {
        val temp = b
        b = a % b
        a = temp
    }

    return a + b
}

private fun mcm(firstNumber: Int, secondNumber: Int): Int {
    return (firstNumber * secondNumber) / mcd(firstNumber, secondNumber)
}

private fun mcdRecursive(firstNumber: Int, secondNumber: Int): Int {
    return if (firstNumber == 0 || secondNumber == 0) (firstNumber + secondNumber)
        else mcdRecursive(secondNumber, firstNumber % secondNumber)
}

 """


def mcm (num1: int, num2: int):

    mcd = 0 # Solo para evitar que pylance marcara error ""mcd" is possibly unbound"

# Máximo común divisor

    if num1 > num2:
        a = num1
        b = num2

    else:
        a = num2
        b = num1

    while b != 0:

        mcd = b
        b = a % b
        a = mcd

# Mínimo común multiplo

    mcm = (num1 * num2) // mcd

    return f"El MCD de {num1} y {num2} es {mcd}. Y el mcm es {mcm}"


print(mcm(72, 16))