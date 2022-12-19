package com.openai.chat

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función en Kotlin que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Resuelto: Sí.
 * Iteracciones: 1
 * Explicación: La función toma dos cadenas como parámetros (str1 y str2) y utiliza la función filter de las cadenas para crear dos nuevas cadenas: out1 y out2.
 * Nota: es sensible a mayúsculas y minúsculas
 *
 */

fun printDifferences(str1: String, str2: String) {
    val out1 = str1.filter { c -> !str2.contains(c) }
    val out2 = str2.filter { c -> !str1.contains(c) }
    println("out1: $out1")
    println("out2: $out2")
}

fun main() {
    printDifferences("hello", "world")  // Esto imprimiría "out1: he" y "out2: wrd"
    printDifferences("abcde", "abcde")  // Esto imprimiría "out1: " y "out2: " (las cadenas vacías)
    printDifferences("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba")    // Esto imprimiría "out1: " y "out2: " (las cadenas vacías)

    // Brais cases
    printDifferences("brais","moure")   // Esto imprimiría "out1: bais" y "out2: moue"
    printDifferences("Me gusta Java","Me gusta Kotlin") // Esto imprimiría "out1: Jv" y "out2: Kolin"
    printDifferences("Usa el canal de nuestro discord (https://mouredev.com/discord) \"\uD83D\uDD01reto-semanal\" para preguntas, dudas o prestar ayuda a la comunidad".lowercase(),
        "Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.".lowercase())  // Esto imprimiría "out1: (:///)"🔁-"" y "out2: fkqqó"

    // Jaime cases
    printDifferences("Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).",
        "- out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.")  // Esto imprimiría "out1: Ei:Cfióqibmm(,)imimmi(,)" y "out2: -NOé"
    printDifferences("Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.",
        "Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.")   // Esto imprimiría "out1: PFkyPqqm" y "out2: éjTwb"
    printDifferences("- out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.",
        "- out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.")  // Esto imprimiría "out1: " y "out2: " (las cadenas vacías)
}

