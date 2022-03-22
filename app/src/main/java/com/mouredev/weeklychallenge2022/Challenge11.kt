package com.mouredev.weeklychallenge2022

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 *
 */

fun main(){
    filter("camion","mi")
    //filterAux("camion","mi")
    //filterAuxAux("camion","mi")
}

fun filter(cadenaUno : String, cadenaDos : String ) {
    println(cadenaUno.filter { !cadenaDos.contains(it) } )
    println(cadenaDos.filter { !cadenaUno.contains(it) } )
}

fun filterAux(cadenaUno : String, cadenaDos : String ) {
    var cadenaUnoAux = ""
    var cadenaDosAux = ""

    cadenaUno.forEach {

        if(!cadenaDos.contains(it)){
            cadenaUnoAux += it
        }
    }
    println(cadenaUnoAux)

    cadenaDos.forEach {
        var cadenaDosAux = ""

        if(!cadenaDos.contains(it)){
            cadenaDosAux += it
        }
    }
    println(cadenaDosAux)
}

fun filterAuxAux(cadenaUno : String, cadenaDos : String ) {
    var cadenaUnoAux = ""

    cadenaUno.forEach {
        val currentCharCadenaUno = it
        var estaEnCadenaDos = false

        cadenaDos.forEach {
            val currentCharCadenaDos = it

            if (currentCharCadenaUno == currentCharCadenaDos){
                estaEnCadenaDos = true
            }
        }
        if (!estaEnCadenaDos){
            cadenaUnoAux += currentCharCadenaUno
        }
    }
    println(cadenaUnoAux)
}