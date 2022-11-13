package com.mouredev.weeklychallenge2022

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main(){
    drawPool(arrayOf(4, 0, 3, 6, 1, 3))
    drawPool(arrayOf(5, 3, 7, 1, 1, 9, 2, 4))
    drawPool(arrayOf(10, 1, 1, 8, 8, 1, 1, 10))
}

private fun drawPool(blueprint : Array<Int>) : Int{
    val design = mutableListOf<Array<Boolean?>>()

    var y = 0
    val x = blueprint.size
    var centerPoint = 0

    blueprint.forEachIndexed { index , it ->
        if (y < it ) {
            y = it
            centerPoint = index
        }
    }

    // Set the blocks
    repeat(x){
        design.add(arrayOfNulls(y))
        for (i in 0 until blueprint[it]){
            design[it][i] = true
        }
    }

    var numOfBlockInTheLeft = blueprint.first()
    for (i in 1 ..centerPoint){
        if (numOfBlockInTheLeft > blueprint[i])
            repeat(numOfBlockInTheLeft){
                if (design[i][it] == null  )
                    design[i][it] = false
            }
        else
            numOfBlockInTheLeft = blueprint[i]
    }

    var numOfBlockInTheRight = blueprint.last()
    for (i in x-1 downTo centerPoint){
        if (numOfBlockInTheRight > blueprint[i])
            repeat(numOfBlockInTheRight){
                if (design[i][it] == null )
                    design[i][it] = false
            }
        else
            numOfBlockInTheRight = blueprint[i]
    }

    var waterCounter = 0
    repeat(y){  it_y ->
        repeat(x){ it_x ->
            print( when(design[it_x][(y-1)-it_y]){
                false -> {
                    waterCounter++
                    "💧"
                }
                true -> "⏹"
                null -> "\uD83D\uDCA6"
            })
        }
        println()
    }
    repeat(x){ print("\"\'")}
    println( "\nIt has a total of $waterCounter water blocks contained")

    return waterCounter
}

