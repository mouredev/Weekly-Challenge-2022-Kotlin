package com.mouredev.weeklychallenge2022

import java.lang.Thread.sleep
import java.util.*

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


/**
 *  Constantes
 *
 */
private const val RUN = "run"
private const val JUMP = "jump"
private const val FLOOR = '_'
private const val FENCE = '|'
private const val FLOOR_FAIL = 'x'
private const val FENCE_FAIL = '/'


/** Funcion principal
 *
 */
fun main(){

    val track = "____|____|____|____|____"
    val actions = arrayOf(RUN,RUN,JUMP,RUN,RUN,RUN,RUN,RUN,RUN,JUMP,RUN,RUN,RUN,RUN,RUN,RUN,JUMP,RUN,RUN,JUMP,RUN,RUN,RUN,RUN)

    if(!runForrestRun(actions,track))
        print("el atleta no ha superado la carrera")
    else
        print("el atleta ha superado la carrera")
}

/**
 * Funcion que evalua si los parametros son correctos
 * @param actions Array de String que contiene las acciones
 * @param track String que contiene la pista
 * @return Boolean que indica si son correctos
 */
fun checkValues(track: String,actions: Array<String>):Boolean{
    return checkActions(actions) && checkTrack(track) && actions.size == track.length
}

/**
 * Funcion que evalua si el track es correcto
 */
fun checkTrack(track: String): Boolean = !track.none { it == FLOOR || it == FENCE }
/**
 * Funcion que evalua si el array de acciones es correcto
 */
fun checkActions(actions: Array<String>):Boolean = !actions.none { it == RUN || it==JUMP }

/**
 * Funcion que evalua si el atleta ha superado la carrera
 * @param actions Array de String que contiene las acciones
 * @param track String que contiene la pista
 * @return Boolean que indica si ha superado la carrera
 */
fun runForrestRun(actions: Array<String>, track: String): Boolean {

    var raceResult = ""
    var result = true
    val finalActions = actions.map { it.lowercase(Locale.getDefault()) }.toTypedArray()

    if(!checkValues(track,finalActions)) {
        println("los parametros no son correctos")
        return false
    }

    //Recorremos el track y comprobamos las acciones de cada casilla del track
    track.forEachIndexed { index, it ->

        when(it){
            FLOOR -> {
                raceResult += (if(finalActions[index] == RUN) FLOOR
                else  FLOOR_FAIL .also { result = false  })

            }
            FENCE -> {
                raceResult += (if(finalActions[index] == JUMP) FENCE
                else FENCE_FAIL .also { result = false })
            }
        }
    }

    printResult(track, raceResult, result)

    return result
}

/**
 * Funcion que imprime el resultado de la carrera
 * @param originalTrack String que contiene la pista original
 * @param finalTrack String que contiene la pista final que ha recorriedo el atleta
 * @param result Boolean que indica si ha superado la carrera
 */
fun printResult(originalTrack:String, finalTrack:String, result: Boolean){

    println(originalTrack)

    finalTrack.forEach {
        sleep(100)
        print(it)

    }
    println("")
    if(!result) println("FAILED")
    else println("SUCCESS")


}



