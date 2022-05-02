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

fun main(){
    gameRunningRace(arrayOf("run", "r", "run","jump","run"), "__k|_")
    gameRunningRace(arrayOf("jump","run","run","run","jump"), "__|_|_|_")
    gameRunningRace(arrayOf("run","jump","run","run","jump","run","jump","run", "run","jump","run"), "_|__|_|__|_")
}

private fun gameRunningRace(listActions: Array<String>, runningRace: String){
    val (actions, race) = isCorrectInfo(listActions, runningRace)

    if(actions and race)
        println("¿El atleta ha superado la carrera? ${start(listActions, runningRace)}")

    else println("Los datos ingresados son incorrectos")
}

private fun isCorrectInfo(actions: Array<String>, runningRace: String): Pair<Boolean, Boolean> {
    var countAction = 0; var countRace = 0

    actions.forEach { action ->
        if((action == "run") or (action == "jump")) countAction++ }

    runningRace.forEach { element ->
        if((element == '_') or (element == '|')) countRace++ }

    return Pair((countAction == actions.size) and (actions.isNotEmpty()),
        (countRace == runningRace.length) and (runningRace.isNotEmpty()))
}

private fun start(actions: Array<String>, race: String): Boolean{
    var result = ""; var action: String

    for(index in race.indices){
        action = if(index < actions.size) actions[index] else ""

        when {
            ((action == "run") and (race[index] == '_')) or
                    ((action == "jump") and (race[index] == '|')) ->  result += race[index]
            race[index] == '_' -> result += 'x'
            race[index] == '|'-> result += '/'
        }
    }
    println("Carrera Finalizada: $result")
    return ('x' !in result) and ('/' !in result)
}