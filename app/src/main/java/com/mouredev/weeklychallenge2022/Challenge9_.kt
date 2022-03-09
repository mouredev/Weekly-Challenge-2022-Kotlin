package com.mouredev.weeklychallenge2022

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios
 * entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas,
 * dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución
 * aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun main() {
    morseTranslate("Hola mundo, Hay alguien alli?")
    morseTranslate(".... ——— .—.. .—   —— ..— —. —.. ——— ——..——   .... .— —.——   .— .—.. ——. ..— .. . —.   .— .—.. .—.. .. ..——..")
}

fun morseTranslate(text: String){
    val diccionario = mapOf("A" to ".—", "N" to "—.", "0" to "—————",
        "B" to "—...", "Ñ" to "——.——", "1" to ".————",
        "C" to "—.—.", "O" to "———", "2" to "..———",
        "CH" to "————", "P" to ".——.", "3" to "...——",
        "D" to "—..", "Q" to "——.—", "4" to "....—",
        "E" to ".", "R" to ".—.", "5" to ".....",
        "F" to "..—.", "S" to "...", "6" to "—....",
        "G" to "——.", "T" to "—", "7" to "——...",
        "H" to "....", "U" to "..—", "8" to "———..",
        "I" to "..", "V" to "...—", "9" to "————.",
        "J" to ".———", "W" to ".——", "." to ".—.—.—",
        "K" to "—.—", "X" to "—..—", "," to "——..——",
        "L" to ".—..", "Y" to "—.——", "?" to "..——..",
        "M" to "——", "Z" to "——..", "\"" to ".—..—.", "/" to "—..—.")

    val regex = Regex("[a-zA-Z0-9]")
    if(text.contains(regex)) {
        //Convertir a morse
        text.uppercase().forEach {
            if (!it.equals(' '))
                print("${diccionario[it.toString()]} ")
            else
                print("  ")
        }
    }else {
        text.split("  ").forEach { word ->
            word.split(" ").forEachIndexed{index, it ->
                for ((key, value) in diccionario) {
                    if (it == value)
<<<<<<< HEAD
                        print(key)
                        //print(if (index == 0) key else key.lowercase())
=======
                        print(if (index == 0) key else key.lowercase())
>>>>>>> 9500d7c (challenge 7)
                }
            }
            print(" ")
        }
    }
    println()
}