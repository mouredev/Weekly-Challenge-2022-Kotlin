package es.jaimefere.weeklychallenge2022

import es.jaimefere.weeklychallenge2022.getBinary

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

fun toMorse(alphabet: Map<String,String>, input: String): String {
    var output = input
    alphabet.keys.forEach {
        output = output.replace(it, "${alphabet[it]!!} ")
    }
    return output
}

fun toStandard(alphabet: Map<String,String>, input: String): String {
    var output = ""
    input.split("  ").forEach { word ->
        word.split(" ").filter { it.isNotEmpty() }.forEach { morseSecuence ->
            output += alphabet.filterValues { it == morseSecuence }.keys.first()
        }
        output += " "
    }
    return output
}

fun translate(text: String): String {
    val alphabet = mutableMapOf<String,String>()
    alphabet[" "] = ""
    alphabet["CH"] = "————"
    alphabet["A"] = "·—"
    alphabet["B"] = "—···"
    alphabet["C"] = "—·—·"
    alphabet["D"] = "—··"
    alphabet["E"] = "·"
    alphabet["F"] = "··—·"
    alphabet["G"] = "——·"
    alphabet["H"] = "····"
    alphabet["I"] = "··"
    alphabet["J"] = "·———"
    alphabet["K"] = "—·—"
    alphabet["L"] = "·—··"
    alphabet["M"] = "——"
    alphabet["N"] = "—·"
    alphabet["Ñ"] = "——·——"
    alphabet["O"] = "———"
    alphabet["P"] = "·——·"
    alphabet["Q"] = "——·—"
    alphabet["R"] = "·—·"
    alphabet["S"] = "···"
    alphabet["T"] = "—"
    alphabet["U"] = "··—"
    alphabet["V"] = "···—"
    alphabet["W"] = "·——"
    alphabet["X"] = "—··—"
    alphabet["Y"] = "—·——"
    alphabet["Z"] = "——··"
    alphabet["0"] = "—————"
    alphabet["1"] = "·————"
    alphabet["2"] = "··———"
    alphabet["3"] = "···——"
    alphabet["4"] = "····—"
    alphabet["5"] = "·····"
    alphabet["6"] = "—····"
    alphabet["7"] = "——···"
    alphabet["8"] = "———··"
    alphabet["9"] = "————·"
    alphabet["."] = "·—·—·—"
    alphabet[","] = "——··——"
    alphabet["?"] = "··——··"
    alphabet["\""] = "·—··—·"
    alphabet["/"] = "—··—·"

    return if(alphabet.keys.filter { it != " " && it in text }.count() > 0) {
        toMorse(alphabet, text.uppercase())
    } else {
        toStandard(alphabet, text.uppercase())
    }
}


fun main() {
    println(translate("De texto a Morse"))
    println(translate("—·· ·  —— ——— ·—· ··· ·  ·—  — · —··— — ——— "))
}