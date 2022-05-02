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
    val runner = arrayOf<String>("run", "run", "jump", "run");
    val stadium = charArrayOf('_','_','|','_');

    if (runner.size == stadium.size){
        println("El resultado de la carrera es: ${RaceResult(runner, stadium)}");
    }
    else {
        println("Faltan datos");
    }
}

private fun RaceResult(athlete: Array<String>, track: CharArray): Boolean{

    var result = "";

    val athleteBadActions = athlete.filter{
        it != "run" && it != "jump"
    }

    val trackBadStatus = track.filter{
        it.toString() != "_" && it.toString() != "|"
    }

    if (athleteBadActions.isNotEmpty() or trackBadStatus.isNotEmpty()){
        println("Hay acciones incorrectas o la pista no está bien")
        return false;
    }

    athlete.forEachIndexed{index, action ->
        when {
            action == "run" && track[index] == '_' -> result += '_';
            action == "run" && track[index] == '|' -> result += '/';
            action == "jump" && track[index] == '|' -> result += '|';
            action == "jump" && track[index] == '_' -> result += 'x';
        }

    }

    println ("La traza de la carrera es: $result")
    return !result.contains("x") or !result.contains("/") ;
}