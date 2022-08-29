package com.mouredev.weeklychallenge2022

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(){
    val number = 14
    val codeBinary = toCodeBinary(number)
    print("The number: $number is equal to: ${codeBinary.asReversed()} in binary")
}

// My solution
fun toCodeBinary(number: Int ): ArrayList<Byte>{
    val codeBinary :ArrayList<Byte> = arrayListOf()
    var modNumber = number
    if (number>0){
        do {
            if (modNumber == 1){
                codeBinary.add(1)
            }else if (modNumber % 2 == 1){
                codeBinary.add(1)
            } else {
                codeBinary.add(0)
            }
            modNumber /= 2
        }while (modNumber >=1)
    }

    return codeBinary
}