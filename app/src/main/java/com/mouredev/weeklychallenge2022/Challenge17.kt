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
    printRace(arrayOf("jump", "run", "run", "jump", "run"), "|__|_")
    printRace(arrayOf("jump", "run", "run", "jump", "run"), "|_|__")
}

fun printRace(actions: Array<String>, runningTrack: String){
    println("Las acciones que realizó el atleta son: ${actions.contentToString()}")
    println("El estado inicial de la pista era: $runningTrack")
    println("El Atleta ${if(passTheRace(actions, runningTrack)) "" else "no "}pasó la carrera")
    println()
}

// Suponemos que los parámatros pasados por parámetro son correctos.
private fun passTheRace(actions: Array<String>, runningTrack: String): Boolean {
    var raceStatus = ""
    for (i in actions.indices){
        raceStatus += (
                when {
                    actions[i] == "run" && runningTrack[i] == '_' -> "_"
                    actions[i] == "run" && runningTrack[i] == '|' -> "/"
                    actions[i] == "jump" && runningTrack[i] == '_' -> "x"
                    actions[i] == "jump" && runningTrack[i] == '|' -> "|"
                    else -> {}
                }
                )
    }
    println("Fin de la carrera: $raceStatus")
    return !('x' in raceStatus || '/' in raceStatus)
}