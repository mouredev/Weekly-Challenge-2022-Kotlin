package com.mouredev.weeklychallenge2022

import kotlin.math.absoluteValue
import kotlin.math.pow

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

/* Solucion por Mourodev con Kotlin: 
fun main() {
    println(isArmstrong(371))
    println(isArmstrong(-371))
    println(isArmstrong(372))
    println(isArmstrong(0))
}

private fun isArmstrong(number: Int): Boolean {

    return if (number < 0) {
        false
    } else {
        var sum = 0
        val powValue = number.toString().length

        number.toString().forEach { character ->
            sum += character.toString().toDouble().pow(powValue).toInt()
        }

        number == sum
    }
}
*/

/*Mi Solución con python*/
n=int(input("Ingrese un numero para identificar si es narcicista: ")) #245
m=n
digitos=len(str(n)) #3

suma= 0
if n<0:
    n=n*-1

while n != 0:
   digito=n%10                    #5, 4, 2 
   suma=suma+((digito)**digitos)  #125, 189, 197
   n=n//10  #24, 2, 0

if m==suma:
    print("El numero "+str(m)+" es narcisista") 
else: 
    print("El numero "+str(m)+" no es narcisista") # el numero 245 no es narcisista
