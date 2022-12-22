package com.mouredev.weeklychallenge2022

/*
 * Mi enuciado es :
 * Esribir un programa que cuente el número de ocurrencias
 * de cada letra en una palabra leída como entrada.
 * Por ejemplo, "Mortimer" contiene dos "m",
 * una "o", dos "r", una "i", una "t" y una "e".
 *
 */

//mi solucion es 
fun main() {
    contarLetra("Mortimer")
    contarLetra("marioo")
}

private fun contarLetra(palabra: String) {

    print("$palabra tiene ")
    val veces = palabra.length - 1

    for (letra in 0..veces) {
        var cantidadLetra = 1

        for (contador in 0..palabra.length - 1) {

            if (contador != letra) {
                if (palabra[letra] == palabra[contador]) {
                    if (letra > contador) {
                        cantidadLetra = 0
                        break
                    } else {
                        cantidadLetra++
                    }
                }
            }
        }

        if (cantidadLetra != 0)
            print("[ " + cantidadLetra.toString() + " " + palabra[letra] + " ] ")
    }
}
