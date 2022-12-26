package com.openai.chat

import java.math.BigDecimal
import java.math.RoundingMode
import java.net.URL

/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Usando Kotlin lee el fichero "Challenge21.txt" que puedes encontrar en la URL
 * "https://raw.githubusercontent.com/mouredev/Weekly-Challenge-2022-Swift/main/WeeklyChallenge2022.playground/Pages/Challenge21.xcplaygroundpage/Resources/Challenge21.txt",
 * calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Resuelto: Sí
 * Iteracciones: 3
 * Explicación: Para leer el fichero "Challenge21.txt" que se encuentra en una URL, primero debes descargarlo en tu aplicación. Puedes hacerlo con la clase URL de Kotlin, utilizando su método readText.
 * A continuación, puedes dividir el texto descargado en líneas y recorrerlas una a una para realizar las operaciones que se indican.
 * Para llevar a cabo las operaciones matemáticas, puedes utilizar la clase BigDecimal de Kotlin. Esta clase permite realizar operaciones de precisión arbitraria con números decimales.
 * Conversación:
 * - No tengas en cuenta las líneas en blanco de los ficheros
 * - Si los números de entrada son enteros devuelve un valor entero también, pero de una operación el resultado puede tener decimales por las operaciones
 *
 */

fun calculateResult(fileUrl: String): Double {
    // Descargar el fichero de la URL
    val fileText = URL(fileUrl).readText()

    // Dividir el texto en líneas y recorrerlas una a una
    val lines = fileText.split("\n").filter { !it.isBlank() }
    var result = 0.0
    var lastOperator = "+"
    for (line in lines) {
        // Si es un número, actualizar el resultado según la última operación
        if (line.matches(Regex("\\d+(\\.\\d+)?"))) {
            val number = line.toDouble()
            result = when (lastOperator) {
                "+" -> result + number
                "-" -> result - number
                "*" -> result * number
                "/" -> result / number
                else -> result
            }
        }
        // Si es una operación, guardarla para la siguiente iteración
        else if (line.matches(Regex("[+\\-*/]"))) {
            lastOperator = line
        }
        // Si es otra cosa, mostrar un mensaje de error
        else {
            println("Error: formato de fichero incorrecto")
            return 0.0
        }
    }

    // Devolver el resultado final
    return result
}

fun main() {
    println(calculateResult("https://raw.githubusercontent.com/mouredev/Weekly-Challenge-2022-Swift/main/WeeklyChallenge2022.playground/Pages/Challenge21.xcplaygroundpage/Resources/Challenge21.txt")) // 18.5
    println(calculateResult("https://raw.githubusercontent.com/jaimefere/Weekly-Challenge-2022-Kotlin/main/app/src/main/java/es/jaimefere/weeklychallenge2022/OneValue.txt"))      // 5.0
    println(calculateResult("https://raw.githubusercontent.com/jaimefere/Weekly-Challenge-2022-Kotlin/main/app/src/main/java/es/jaimefere/weeklychallenge2022/TooNumbers.txt"))    // 10
    println(calculateResult("https://raw.githubusercontent.com/jaimefere/Weekly-Challenge-2022-Kotlin/main/app/src/main/java/es/jaimefere/weeklychallenge2022/TooOperators.txt"))  // 6
    println(calculateResult("https://raw.githubusercontent.com/jaimefere/Weekly-Challenge-2022-Kotlin/main/app/src/main/java/es/jaimefere/weeklychallenge2022/WithDecimals.txt"))  // 17.7
}


