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

fun main(){
    getMaxComDiv(10,20)
    getMaxComDiv(21,9)
    getMaxComDiv(70,10)

    getMinComMul(15,20)
    getMinComMul(12,9)
    getMinComMul(27,10)

}

// Gets the different divisors of the given number
private fun getDivisores(_num : Int) : List<Int>{
    var numDiv = 2

    var num = _num
    val divisores = mutableListOf<Int>()

    while (num > 1){
        try {
            if (num % numDiv == 0){
                divisores.add(numDiv)
                num /= numDiv
            } else {
                numDiv++
            }
        } catch ( e : ArithmeticException){
            print(e.message)
        }
    }
    println("Los divisores de $_num son: $divisores")
    return divisores
}

private fun getMaxComDiv(num1 : Int, num2 : Int) : Int{

    val divisores1 = getDivisores(num1).toMutableList()
    val divisores2 = getDivisores(num2).toMutableList()
    val commonDivs = mutableListOf<Int>()

    var numDiv = 2
    var notFound = true
    while (notFound){
        if (divisores1.isEmpty() || divisores2.isEmpty()){
            notFound = false
        } else {
            if (divisores1.contains(numDiv) && divisores2.contains(numDiv)){
                divisores1.remove(numDiv)
                divisores2.remove(numDiv)
                commonDivs.add(numDiv)
            } else {
                if (commonDivs.size >= divisores1.size || commonDivs.size >= divisores2.size){
                    notFound = false
                    divisores1.forEach{
                        if (divisores2.contains(it)){
                            notFound = true
                        }
                    }
                }
                numDiv++
            }
        }
    }

    val maxComDiv = commonDivs.reduce{ acc, i ->  acc * i }
    println("Max Com Div entre $num1 y $num2 es $maxComDiv \n")
    return maxComDiv
}

private fun getMinComMul(num1 : Int, num2 : Int) : Int{

    val divisores1 = getDivisores(num1).toMutableList()
    val divisores2 = getDivisores(num2).toMutableList()
    var minComMul = 1

    var numDiv = 2
    var notFound = true
    while (notFound){
        if (divisores1.isEmpty() && divisores2.isEmpty()){
            notFound = false
        } else if (divisores1.contains(numDiv) || divisores2.contains(numDiv)){
                divisores1.remove(numDiv)
                divisores2.remove(numDiv)
                minComMul *= numDiv
            } else numDiv++
        }

    println("Min Com Mul entre $num1 y $num2 es $minComMul \n")
    return minComMul
}