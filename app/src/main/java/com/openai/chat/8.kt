package com.openai.chat

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa en Kotlin que se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Resuelto: Sí. En 2 iteracciones.
 * Explicación:
 * · Este programa toma un número entero como entrada y devuelve su representación en binario como una cadena de caracteres. Para transformar el número, el programa utiliza un bucle while
 * que continúa hasta que el número sea menor que 0. Dentro del bucle, se calcula el resto de la división del número por 2 y se agrega como el primer carácter de la cadena binaria resultante.
 * Luego, se divide el número entero original por 2 y se continúa el bucle hasta que el número sea menor que 0.
 * Conversación:
 * - Para el caso del número 0 devuelve un resultado vacío, en lugar de 0
 * + Sí, es cierto que el programa que propuse anteriormente devolverá una cadena vacía para el caso del número 0. Para solucionar este problema, puedes agregar una comprobación especial para
 * el número 0 al principio del programa. De esta manera, en lugar de entrar en el bucle while, se devolverá directamente el valor 0 como resultado.
 * Nota: En Kotlin usa menos comentarios que en Swift.
 *
 */

fun decimalToBinary(number: Int): String {
    if (number == 0) {
        return "0"
    }

    var num = number
    var binary = ""

    while (num > 0) {
        val rem = num % 2
        binary = "$rem$binary"
        num /= 2
    }

    return binary
}

fun main() {
    println(decimalToBinary(12))    // Imprime "1100"

    // Brais cases
    println(decimalToBinary(387))     //110000011
    println(decimalToBinary(0))       //0

    // Jaime cases
    println(decimalToBinary(1024))    //10000000000
    println(decimalToBinary(432))     //110110000
    println(decimalToBinary(79))      //1001111
    println(decimalToBinary(25))      //11001
}

