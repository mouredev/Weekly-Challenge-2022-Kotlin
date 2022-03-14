package com.mouredev.weeklychallenge2022

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun main() {

    removeChars("MoureDev by Brais Moure", "Building MoureCorcho from Galicia with love")
    removeChars("En COBOL esto no pasa!", "Flutter es lo mejor?")
    removeChars("Este es un reto facilito", "A los de Android les va a costar el doble")
}

private fun removeChars(str1: String, str2: String) {

    var out1 = arrayListOf<Char>()
    var out2 = arrayListOf<Char>()

    str1.replace(" ", "").lowercase().forEach {
        if (!str2.replace(" ", "").lowercase().contains(it)) {
            if (!out1.contains(it)) {
                out1.add(it)
            }
        }
    }
    str2.replace(" ", "").lowercase().forEach {
        if (!str1.replace(" ", "").lowercase().contains(it)) {
            if (!out2.contains(it)) {
                out2.add(it)
            }
        }
    }
    println("out1 -> $out1")
    println("out2 -> $out2")
}