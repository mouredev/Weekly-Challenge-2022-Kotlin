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
    val naturalText = "Esto es una prueba en lenguaje natural"
    val morseText = ".... .- ...  .-. . -.-. .. -... .. -.. ---  . ... - --- ..--.."

    println(EvaluateString(naturalText))
    println(EvaluateString(morseText))
}

private fun EvaluateString(string: String): String {
    // Esta función detecta el contenido de la cadena pasada y en función de ello, codifica o decodifica

    var resultString = ""
    val regex = Regex(pattern = "[A-Z]")
    val dict = hashMapOf (".-" to "A", "-..." to "B", "-.-." to "C", "----" to "CH", "-.." to "D", "." to "E",
                          "..-." to "F", "--." to "G", "...." to "H", ".." to "I", ".---" to "J", "-.-" to "K",
                          ".-.." to "L", "--" to "M", "-." to "N", "---" to "O", ".--." to "P", "--.-" to "Q",
                          ".-." to "R", "..." to "S", "-" to "T", "..-" to "U", "...-" to "V", ".--" to "W",
                          "-..-" to "X", "-.--" to "Y", "--.." to "Z", "-----" to "0", ".----" to "1",
                          "..---" to "2", "...--" to "3", "....-" to "4", "....." to "5", "-...." to "6",
                          "--..." to "7", "---.." to "8", "----." to "9", ".-.-.-" to ".", "--..--" to ",",
                          "..--.." to "?", ".-..-." to "\"", "-..-. " to "/")

    if (regex.containsMatchIn(input= string.uppercase()))
        resultString = TextToMorse(string, dict)
    else
        resultString = MorseToText(string, dict)

    return resultString
}

private fun TextToMorse (string: String, dict: HashMap<String, String>): String {

    var morseString = ""
    var step = false
    val reversedDict = dict.entries.associate{(k,v)-> v to k}

    string.forEachIndexed{index, element ->
        if (step){
            step = false
        }
        else {
            if (element in " ")
                morseString += " "
            else if (element.uppercase().equals("C")) { // Comprobacion para la CH
                if ((string[index + 1].uppercase().equals("H")) and (index + 1 < string.length )) {
                    // La siguiente letra es una H, asi que hay que poner el caracter CH
                    morseString += reversedDict.getValue("CH") + " "
                    step = true
                }
                else
                    morseString += reversedDict.getValue("C") + " "
            }
            else
                morseString += reversedDict.getValue(element.toString().uppercase()) + " "
        }
    }

    return morseString
}

private fun MorseToText (string: String, dict: HashMap<String, String>): String {

    var naturalString = ""
    var word = ""

    string.forEachIndexed{index, element ->
        if (element in " ") {
            if ((string[index + 1] in " ") and (index + 1 < string.length ))
                naturalString += dict.getValue(word) + " "
            else
                if (word !in " ")
                    naturalString += dict.getValue(word)
                else
                    naturalString += " "
            word = ""
        }
        else
            word += element
    }
    naturalString += dict.getValue(word)

    return naturalString
}