package com.yts.tymodoro

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(){
    val nums = arrayOf(371, 51, 8208, 609, -609, -371, -51)
    for (i in nums){
        if(isArmstrongNum(i)) println("¡$i es un número de Armstrong!")
        else println("¡$i no es un número de Armstrong!")
    }
}
/*Resultados:
¡371 es un número de Armstrong!
¡51 no es un número de Armstrong!
¡8208 es un número de Armstrong!
¡609 no es un número de Armstrong!
¡-609 no es un número de Armstrong!
¡-371 es un número de Armstrong!
¡-51 no es un número de Armstrong!
* */

private fun isArmstrongNum(n: Int): Boolean {
    val splitted = n.split()
    var result = 0
    for (digit in splitted){
        result += digit.powerOf(splitted.size)
    }
    if(n < 0) result = "-$result".toInt() //Esto es para recuperar el negativo que se perdió en la función split
    return result == n
}

private fun Int.split(): Array<Int> {
    val stringNumber = this.toString()
    return if(this >= 0)
        Array(stringNumber.length) {
            stringNumber[it].digitToInt()
    } else { //Si es un negativo, se quita el símbolo "-"
        val nonNegativeStringNum = this.toString().replace("-", "")
        Array(nonNegativeStringNum.length) {
            nonNegativeStringNum[it].digitToInt()
        }
    }
}

private fun Int.powerOf(exponent: Int): Int{
    var result = this
    for (i in 1 until exponent){
        result *= this
    }
    return result
}
