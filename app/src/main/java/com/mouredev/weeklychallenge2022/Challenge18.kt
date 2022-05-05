package com.mouredev.weeklychallenge2022

import kotlin.math.abs

/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

enum class ResultadoPartida{
    Inicial,
    GanaX,
    GanaO,
    Empate,
    EnJuego,
    Error
}

/**
 * @param x0 puede contener un valor "x", "o", "-" (celda vacía)
 * @param x1 puede contener un valor "x", "o", "-" (celda vacía)
 * @param x2 puede contener un valor "x", "o", "-" (celda vacía)
 */
data class FilaTablero (val x0: String, val x1: String, val x2: String){
    val esValida: Boolean
        get() = !arrayOf(x0, x1, x2).any { x -> x.lowercase() != "x" && x.lowercase() != "o" && x.lowercase() != "-" }
}

class Partida(fila1: FilaTablero, fila2: FilaTablero, fila3: FilaTablero){
    private val tablero =   arrayOf(arrayOf ("-", "-", " -"),
        arrayOf ("-", "-", " -"),
        arrayOf ("-", "-", " -")
    )

    init {
        if (fila1.esValida && fila2.esValida && fila3.esValida){
            this.tablero[0][0] = fila1.x0
            this.tablero[0][1] = fila1.x1
            this.tablero[0][2] = fila1.x2

            this.tablero[1][0] = fila2.x0
            this.tablero[1][1] = fila2.x1
            this.tablero[1][2] = fila2.x2

            this.tablero[2][0] = fila3.x0
            this.tablero[2][1] = fila3.x1
            this.tablero[2][2] = fila3.x2

        }else{
            // Como alguna de las filas no es válida, "rompemos el tablero"
            tablero[0][0] = "#"
        }
    }

    /**
     * Determina si una partida es o no válida, como mucho la diferencia entre x y o puede ser de 1
     */
    private val partidaValida: Boolean
        get(){
            val nX = this.tablero.flatten().filter { x -> x.lowercase() == "x" }.size
            val nO = this.tablero.flatten().filter { x -> x.lowercase() == "o" }.size
            val nSharp = this.tablero.flatten().filter { x -> x.lowercase() == "#" }.size
            return  (abs(nX - nO) == 1 || (nX == 0 && nO == 0)) && nSharp == 0
        }

    private fun checkGanador(jugador: String): Boolean{
        val flatTablero = this.tablero.flatten()
        val idxTablero = flatTablero.mapIndexed { idx, jugada -> Pair(idx, jugada) }
        val jugadasX = idxTablero.filter { xo -> xo.second.lowercase() == jugador.lowercase() }

        return jugadasX.count { x -> x.first in 0..2 } == 3 ||
                jugadasX.count { x -> x.first in 3..5 } == 3 ||
                jugadasX.count { x -> x.first in 6..8 } == 3 ||
                jugadasX.count { x -> arrayOf( 0, 3, 6).any {i -> i == x.first} } == 3 ||
                jugadasX.count { x -> arrayOf( 1, 4, 7).any {i -> i == x.first} } == 3 ||
                jugadasX.count { x -> arrayOf( 2, 5, 8).any {i -> i == x.first} } == 3 ||
                jugadasX.count { x -> arrayOf( 0, 4, 8).any {i -> i == x.first} } == 3 ||
                jugadasX.count { x -> arrayOf( 2, 4, 6).any {i -> i == x.first} } == 3

    }
    val resultado: ResultadoPartida
        get(){
            var returnValue = ResultadoPartida.Error

            if (this.partidaValida){
                val flatTablero = this.tablero.flatten()

                if (this.checkGanador("x"))
                    returnValue = ResultadoPartida.GanaX
                else if (this.checkGanador("o"))
                    returnValue = ResultadoPartida.GanaO
                else if(flatTablero.count { xo -> xo.lowercase() == "x" } in 1..3)
                    returnValue = ResultadoPartida.EnJuego
                else if(flatTablero.count { xo -> xo.lowercase() == "x" || xo.lowercase() == "o" }  == 0)
                    returnValue = ResultadoPartida.Inicial
                else
                    returnValue = ResultadoPartida.Empate
            }

            return returnValue
        }
}

fun main(){
    // Empate
    val partida1 = Partida(
        FilaTablero("o","x","o"),
        FilaTablero("o","x","o"),
        FilaTablero("x","o","x")
    )
    // Error
    val partida2 = Partida(
        FilaTablero("o","x","-"),
        FilaTablero("o","x","-"),
        FilaTablero("o","x","-")
    )
    // Gana X
    val partida3 = Partida(
        FilaTablero("x","o","o"),
        FilaTablero("o","x","o"),
        FilaTablero("x","o","x")
    )
    // Gana O
    val partida4 = Partida(
        FilaTablero("o","o","o"),
        FilaTablero("x","x","o"),
        FilaTablero("x","o","x")
    )
    // Inicial
    val partida5 = Partida(
        FilaTablero("-","-","-"),
        FilaTablero("-","-","-"),
        FilaTablero("-","-","-")
    )
    // Error
    val partida6 = Partida(
        FilaTablero("-","0","-"),
        FilaTablero("-","-","-"),
        FilaTablero("-","-","-")
    )
    // Gana O
    val partida7 = Partida(
        FilaTablero("o","x","o"),
        FilaTablero("x","o","-"),
        FilaTablero("o","x","-")
    )

    println("Resultado Partida1: ${partida1.resultado}")
    println("Resultado Partida2: ${partida2.resultado}")
    println("Resultado Partida3: ${partida3.resultado}")
    println("Resultado Partida4: ${partida4.resultado}")
    println("Resultado Partida5: ${partida5.resultado}")
    println("Resultado Partida6: ${partida6.resultado}")
    println("Resultado Partida7: ${partida7.resultado}")
}