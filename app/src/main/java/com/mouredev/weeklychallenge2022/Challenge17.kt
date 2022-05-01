package com.mouredev.weeklychallenge2022

import java.lang.Exception

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


fun main(){
    println("Pass the test? -> ${evaluateAthlete(arrayOf("run"), "_")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump"), "|")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("run", "jump"), "_|")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump", "run"), "|_")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump", "run", "run", "run"), "|___")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump", "run", "jump", "jump", "run"), "|_||_")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump", "run", "run", "jump", "jump", "run"), "|__||_")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("jump", "run", "jump", "jump"), "|___")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("Hola"), "_")}")
    println("Pass the test? -> ${evaluateAthlete(arrayOf("run"), "hola")}")
}

private fun evaluateAthlete(actions: Array<String>, tracks: String): Boolean{
    println("Actions -> ${actions.joinToString { it }}")
    println("Tracks -> $tracks")
    val actionResult = evaluateAthleteAction(actions)
    val tracksResult = evaluateTrack(tracks)
    return if (actions.size == tracks.length && actionResult && tracksResult){
        evaluateRace(tracks, actions)
    }else{
        false
    }
}

private fun evaluateRace(
    tracks: String,
    actions: Array<String>
): Boolean {
    val raceResult = evaluateSections(tracks, actions)
    println("Race result -> $raceResult")
    return !raceResult.contains(FLOOR_FAIL) && !raceResult.contains(FENCE_FAIL)
}

private fun evaluateSections(tracks: String, actions: Array<String>): String {
    var raceResult = ""
    tracks.forEachIndexed { index, track ->
        when {
            track == FLOOR && actions[index] == RUN_ACTION -> raceResult += FLOOR
            track == FLOOR && actions[index] == JUMP_ACTION -> raceResult += FLOOR_FAIL
            track == FENCE && actions[index] == JUMP_ACTION -> raceResult += FENCE
            track == FENCE && actions[index] == RUN_ACTION -> raceResult += FENCE_FAIL
        }
    }
    return raceResult
}

private fun evaluateAthleteAction(actions: Array<String>) : Boolean{
    val invalidActions = actions.filter{
        it != RUN_ACTION && it != JUMP_ACTION
    }
    if (invalidActions.isNotEmpty()){
        println("Not valid actions -> ${actions.joinToString { it }} Actions only can contain \"$RUN_ACTION\" or \"$JUMP_ACTION\"")

    }
    return invalidActions.isEmpty()
}

private fun evaluateTrack(tracks: String) : Boolean{
    val invalidTrack = tracks.filter{
        it != FLOOR && it != FENCE
    }
    if (invalidTrack.isNotEmpty()){
        println("Not valid track -> $tracks Track only can contain \"$FLOOR\" or \"$FENCE\"")
    }
    return invalidTrack.isEmpty()
}


private const val RUN_ACTION = "run"
private const val JUMP_ACTION = "jump"
private const val FLOOR = '_'
private const val FLOOR_FAIL = 'x'
private const val FENCE = '|'
private const val FENCE_FAIL = '/'