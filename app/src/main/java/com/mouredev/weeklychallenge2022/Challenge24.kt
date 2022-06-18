package com.mouredev.weeklychallenge2022

/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
 fun main() {
    val numMax = 5
    //forma1()
    //forma2(numMax)
    //forma3(numMax)
    //forma4(numMax)
    //forma5(numMax)
    //forma6(1, numMax)
    //println(Int.forma7(numMax))
}

fun forma1() {
    var i = 1
    println(i)
    println(++i)
    println(++i)
    println(++i)
    println(++i)
    //... y asi hasta 100
}

fun forma2(numMax: Int) {
    for (i in 1..numMax) {
        println(i)
    }
}

fun forma3(numMax: Int) {
    var i = 1
    while (i <= numMax) {
        println(i)
        i++
    }
}

fun forma4(numMax: Int) {
    var i = numMax - 1

    while (i >= 0) {
        println(numMax - i)
        i--
    }
}

fun forma5(numMax: Int) {
    val nums = 1..numMax

    nums.forEach {
        println(it)
    }
}

fun forma6(i: Int, numMax: Int) {
    if (i <= numMax) {
        println(i)
        forma6(i + 1, numMax)
    }
}

fun Int.Companion.forma7(numMax: Int): List<Int>  {
    val ml = mutableListOf<Int>()
    var i = 1

    do {
        ml.add(i)
        i++
    } while (i <= numMax)

    return ml
}