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
    println("First Race\n")
    startRace(5)
    runnersNumber = 1
    println("\nSecond Race\n")
    startRace(10)

    // For Moure Dev solution
    println(checkRace(listOf(AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.RUN, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.RUN, AthleteState.JUMP, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.RUN, AthleteState.JUMP, AthleteState.JUMP, AthleteState.RUN), "_|_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN, AthleteState.JUMP), "_|_|_"))
    println(checkRace(listOf(AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN, AthleteState.JUMP, AthleteState.RUN), "_|_|_"))
    println(checkRace(listOf(AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP), "|||||"))
    println(checkRace(listOf(AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP, AthleteState.JUMP), "||?||"))
}


private var runnersNumber = 1
private enum class Runner(){
    RUN,JUMP
}
private fun wins(athleteActions : Array<Runner>, route : String): Boolean{

    val segmentedRoute = route.toCharArray()
    var finishTheRun = true
    for (x in athleteActions.indices) {
        when(athleteActions[x]){
            Runner.RUN ->
                if (segmentedRoute[x] == '_') {
                    segmentedRoute[x] = 'x'
                    finishTheRun = false
                }
            Runner.JUMP ->
                if (segmentedRoute[x] == '|') {
                    segmentedRoute[x] = '/'
                    finishTheRun = false
                }
        }
    }
    var resultRout = ""
    segmentedRoute.forEach {
        resultRout += it
    }
    print("Runner #${runnersNumber++}: $resultRout ")
    return finishTheRun
}
private fun competition(route: String, vararg runners : Array<Runner>){

    runners.forEach {
        println(" ${if (wins(it,route)) "Finish" else "Lose"}")
    }

}
private fun randomMoves(raceLength: Int) : Array<Runner>{
    val moves = arrayListOf<Runner>()
    for (x in 1..raceLength){
        val runJump = (0..10).random()
        if ( runJump >5 ){
            moves.add(Runner.RUN)
        } else
            moves.add(Runner.JUMP)
    }
    var movesArray = Array(raceLength-1 ){ Runner.RUN }
        movesArray = moves.toArray(movesArray)
    return movesArray
}
private fun randomRoute(raceLength: Int) : String{
    var route = ""
    for (x in 1..raceLength){
        val runJump = (0..10).random()
        route += if ( runJump >5 ){ "_" } else "|"
    }
    return route
}
private fun startRace(raceLength: Int) {
    val raceRunner1: Array<Runner> = randomMoves(raceLength)
    val raceRunner2: Array<Runner> = randomMoves(raceLength)
    val raceRunner3: Array<Runner> = randomMoves(raceLength)
    val raceRunner4: Array<Runner> = randomMoves(raceLength)
    val raceRunner5: Array<Runner> = randomMoves(raceLength)
    val raceRunner6: Array<Runner> = randomMoves(raceLength)
    val raceRunner7: Array<Runner> = randomMoves(raceLength)
    val raceRunner8: Array<Runner> = randomMoves(raceLength)
    val raceRunner9: Array<Runner> = randomMoves(raceLength)
    val raceRunner10: Array<Runner> = randomMoves(raceLength)

    val route = randomRoute(raceLength)
    println(route)
    competition(
        route, raceRunner1, raceRunner2, raceRunner3, raceRunner4, raceRunner5,
        raceRunner6, raceRunner7, raceRunner8, raceRunner9, raceRunner10
    )
}


// For Moure Dev solution
private enum class AthleteState(val segment: String) {
    RUN("_"),
    JUMP("|")
}

private fun checkRace(athlete: List<AthleteState>, track: String) : Boolean {

    val totalActions = if (athlete.count() > track.count()) athlete.count() else track.count()
    val minActions = if (athlete.count() > track.count()) track.count() else athlete.count()

    val trackSegments = track.toList()

    var athleteTrack = ""

    for (index in (0 until totalActions)) {
        athleteTrack += if (index >= minActions) {
            "?"
        } else {
            val segment = trackSegments[index]
            when (val state = athlete[index]) {
                AthleteState.RUN -> if (segment.toString() == state.segment) state.segment else "/"
                AthleteState.JUMP -> if (segment.toString() == state.segment) state.segment else "x"
            }
        }
    }

    println(athleteTrack)

    return track == athleteTrack
}

