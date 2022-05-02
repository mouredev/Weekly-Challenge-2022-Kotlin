package com.mouredev.weeklychallenge2022

/*
 * Reto #17
 * LA CARRERA DE OBSTÁCULOS
 * Fecha publicación enunciado: 25/04/22
 * Fecha publicación resolución: 02/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
 *        variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val athlete1 = listOf("run", "run", "run", "jump", "run", "jump", "run", "jump", "jump", "run")
    val athlete2 = listOf("run", "run", "jump", "run", "run", "jump", "run", "run", "jump", "run")
    val athlete3 = listOf("run", "run", "jump", "run", "jump", "jump", "run", "run", "run", "run")
    val course = listOf("_", "_", "|", "_", "_", "|", "_", "_", "|", "_")

    println("Athlete 1:")
    println("Succeeded: ${athleteSucceeded(athlete1, course)}")
    println("\nAthlete 2:")
    println("Succeeded: ${athleteSucceeded(athlete2, course)}")
    println("\nAthlete 3:")
    println("Succeeded: ${athleteSucceeded(athlete3, course)}")
}

fun athleteSucceeded(athlete: List<String>, course: List<String>): Boolean {
    val courseResult = mutableListOf<String>()
    for ((index, athleteStep) in athlete.withIndex()) {
        if (athleteStep == "run") {
            if (course[index] == "_") {
                courseResult.add("_")
            } else {
                courseResult.add("/")
            }
        } else {
            if (course[index] == "|") {
                courseResult.add("|")
            } else {
                courseResult.add("x")
            }
        }
    }
    println(courseResult)
    return !(courseResult.contains("/") or courseResult.contains("x"))
}
