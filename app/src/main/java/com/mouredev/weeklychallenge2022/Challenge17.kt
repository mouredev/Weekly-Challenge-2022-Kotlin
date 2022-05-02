package com.mouredev.weeklychallenge2022

fun main() {
    val acciones = arrayOf("run", "jump", "RUN", "JUMP")
    val pista = arrayOf("_", "|", "_", "|")

    println(carreraSuperada(acciones, pista))
}

private fun carreraSuperada(acciones: Array<String>, pista: Array<String>): Boolean {
    if (accionesCorrectas(acciones) && carreraCorrecta(pista) && acciones.size == pista.size) {
        for (i in acciones.indices) {
            if (acciones[i].lowercase().compareTo("jump", ignoreCase = true) == 0 && pista[i] === "_") {
                pista[i] = "x"
            } else if (acciones[i].lowercase().compareTo("run", ignoreCase = true) == 0 && pista[i] === "|") {
                pista[i] = "/"
            }
            print(pista[i])
        }
    } else {
        return false
    }
    println("")
    return carreraCorrecta(pista)
}

private fun accionesCorrectas(acciones: Array<String>): Boolean {
    val numAcciones = acciones.size
    var numAccionesCorrectas = 0
    for (accion in acciones) {
        if (accion.lowercase().compareTo("run", ignoreCase = true) == 0 || accion.lowercase().compareTo("jump", ignoreCase = true) == 0) {
            numAccionesCorrectas++
        } else {
            return false
        }
    }
    return numAcciones == numAccionesCorrectas && numAcciones > 0
}

private fun carreraCorrecta(carrera: Array<String>): Boolean {
    val numPasos = carrera.size
    var numPasosCorrectos = 0
    for (paso in carrera) {
        if (paso === "_" || paso === "|") {
            numPasosCorrectos++
        } else {
            return false
        }
    }
    return numPasos == numPasosCorrectos && numPasos > 0
}
