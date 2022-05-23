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
 */

fun main(){
    val actions = arrayOf("run", "jump", "perro")
    val athleticsRaceTrack = "_|_"
    /*
    TEST MARTINEZ
    */
    println(racePassed(actions, athleticsRaceTrack))

    /*
    TEST MOURE
    */
    println(checkRace(listOf(AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.RUN, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.RUN, AthleteState.JUMP, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
}

/*
BLOQUE MARTINEZ
 */
fun racePassed(actions : Array<String>, athleticsRaceTrack : String) : Boolean{
    val filteredActions = actions.filter { it != "run"  || it != "jump"}
    var filteresAthleticsRaceTrack = athleticsRaceTrack.filter { it != '_'  || it != '|'}
    var succesful = true

    for(i in filteresAthleticsRaceTrack.indices){

        if (filteresAthleticsRaceTrack[i] == '_' && filteredActions[i] != "run"){
            filteresAthleticsRaceTrack = filteresAthleticsRaceTrack.substring(0, i) +
                    'X' + filteresAthleticsRaceTrack.substring(i+1)
            succesful = false
        }
        if ((filteresAthleticsRaceTrack[i] == '|' && filteredActions[i] != "jump")){
            filteresAthleticsRaceTrack = filteresAthleticsRaceTrack.substring(0, i) +
                    '/' + filteresAthleticsRaceTrack.substring(i+1)
            succesful = false
        }
    }
    println(filteresAthleticsRaceTrack)
    return succesful
}

/*
BLOQUE MOURE
 */
private enum class AthleteState(val segment: String) {
    RUN("_"),
    JUMP("|")
}

private fun checkRace(athlete: List<AthleteState>, track: String) : Boolean {

    val totalActions = if (athlete.count() > track.count())  athlete.count() else track.count()
    val minActions = if (athlete.count() > track.count()) track.count() else athlete.count()

    val trackSegments = track.toList()

    var athleteTrack = ""

    for (index in (0 until totalActions)) {
        athleteTrack += if (index >= minActions) {
            "?"
        } else {
            val segment = trackSegments[index]
            when(val state = athlete[index]) {
                AthleteState.RUN -> if (segment.toString() == state.segment) state.segment else "/"
                AthleteState.JUMP -> if (segment.toString() == state.segment) state.segment else "x"
            }
        }
    }

    println(athleteTrack)

    return track == athleteTrack
}

