package com.mouredev.weeklychallenge2022

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(counter("Hola Mundo.!,"))
    println(counter(testText()))
}

private fun counter(text: String) : String {
    val re = "[^A-Za-z0-9 ]".toRegex()
    val textAux = re.replace(text, "").lowercase().split(" ")

    val mapWorld = mutableMapOf<String, Int>()

    for (world in textAux) {
        if (mapWorld.containsKey(world)){
            mapWorld[world] = mapWorld[world]!! + 1
        }else{
            mapWorld[world] = 1
        }
    }

    return mapWorld.toString()
}

private fun testText() : String {
    return "Kotlin es un lenguaje de programación de tipado estático que corre sobre la máquina virtual de Java y que también puede ser compilado a código fuente de JavaScript. Es desarrollado principalmente por JetBrains en sus oficinas de San Petersburgo (Rusia). El nombre proviene de la isla de Kotlin, situada cerca de San Petersburgo. Kotlin fue nombrado lenguaje del mes por la revista Dr. Dobb' Journal en su edición de enero de 2016. Aunque no tiene una sintaxis compatible con Java, Kotlin está diseñado para interoperar con código Java y es dependiente del código Java de su biblioteca de clases, tal como pueda ser el entorno de colecciones de Java (Java collections framework). Kotlin ha sido conocido por ser utilizado en la creación de aplicaciones de Android."
}