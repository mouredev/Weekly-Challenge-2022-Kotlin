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
    val nums = arrayOf(371, 51, 8208, 609)
    for (i in nums){
        if(isArmstrongNum(i)) println("¡$i es un número Armstrong!")
        else println("¡$i no es un número Armstrong!")
    }
}

private fun isArmstrongNum(n: Int): Boolean {
    val splitted = n.split()
    var result = 0
    for (digit in splitted){
        result += digit.powerOf(splitted.size)
    }
    return result == n
}

private fun Int.split(): Array<Int> {
    val stringNumber = this.toString()
    return Array(stringNumber.length){
        stringNumber[it].digitToInt()
    }
}

private fun Int.powerOf(exponent: Int): Int{
    var result = this
    for (i in 1 until exponent){
        result *= this
    }
    return result
}
