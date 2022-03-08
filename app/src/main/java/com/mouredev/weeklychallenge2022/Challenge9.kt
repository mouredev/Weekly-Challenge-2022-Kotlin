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
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


fun main() {

    println(morseCodeToText("....  ---  .-..  .-  --  ..-  -.  -..  ---"))
    println(textToMorseCode("hola mundo"))
}

private fun textToMorseCode(input: String): String {

    val splitText = input.uppercase().split(" ")
    val morseCodeHM = getHashMap()

    var morseCode = ""

    splitText.forEach { text ->
        text.forEach { key ->
            morseCode += "${(morseCodeHM.entries.filter { code -> code.key == key.toString() })[0].value}  "
         }
    }

    return morseCode
}

private fun morseCodeToText(morseCode: String): String {

    val splitMorseCode = morseCode.split("  ")
    val morseCodeHM = getHashMap()

    var textGenerate = ""
    splitMorseCode.forEach { text ->
        textGenerate += (morseCodeHM.entries.filter { code -> code.value == text })[0].key
    }

    return textGenerate
}

private fun getHashMap(): HashMap<String, String> {
    val hashMap: HashMap<String, String> = HashMap()

    hashMap["A"] = ".-"
    hashMap["B"] = "-..."
    hashMap["C"] = "-.-."
    hashMap["CH"] = "----"
    hashMap["D"] = "-.."
    hashMap["E"] = "."
    hashMap["F"] = "..-."
    hashMap["G"] = "--."
    hashMap["H"] = "...."
    hashMap["I"] = ".."
    hashMap["J"] = ".---"
    hashMap["K"] = "-.-"
    hashMap["L"] = ".-.."
    hashMap["M"] = "--"
    hashMap["N"] = "-."
    hashMap["Ñ"] = "--.--"
    hashMap["O"] = "---"
    hashMap["P"] = ".--."
    hashMap["Q"] = "--.-"
    hashMap["R"] = ".-."
    hashMap["S"] = "..."
    hashMap["T"] = "-"
    hashMap["U"] = "..-"
    hashMap["V"] = "...-"
    hashMap["W"] = ".--"
    hashMap["X"] = "-..-"
    hashMap["Y"] = "-.--"
    hashMap["Z"] = "--.."
    hashMap["0"] = "-----"
    hashMap["1"] = ".----"
    hashMap["2"] = "..---"
    hashMap["3"] = "...--"
    hashMap["4"] = "....-"
    hashMap["5"] = "....."
    hashMap["6"] = "-...."
    hashMap["7"] = "--..."
    hashMap["8"] = "---.."
    hashMap["9"] = "----."
    hashMap["."] = ".-.-.-"
    hashMap[","] = "--..--"
    hashMap["?"] = "..--.."
    hashMap["/"] = "-..-."
    hashMap["\""] = ".-..-."


    return hashMap
}