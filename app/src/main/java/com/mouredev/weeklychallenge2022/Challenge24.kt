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

fun main(){
    CountWithFor()
    CountWithWhile()
    CountWithDoWhile()
    CountWithRepeat()
    CountWithRecursion(1)
    CountWithWhen(0)
    CountUsingArray()
}

private fun CountWithFor(){
    println("\n=== USANDO FOR ===\n")
    for (i in 1..100){
        print(i)
        print(", ")
    }
    println("\n")
    println("=== FIN USANDO FOR ===")
}

private fun CountWithWhile(){

    var count = 1
    println("\n=== USANDO WHILE ===\n")
    while (count <= 100){
        print(count)
        print(", ")
        count ++
    }
    println("\n")
    println("=== FIN USANDO WHILE ===")
}

private fun CountWithDoWhile(){

    var count = 1
    println("\n=== USANDO DO.. WHILE ===\n")
    do {
        print(count)
        print(", ")
        count ++
    } while (count <= 100)
    println("\n")
    println("=== FIN USANDO DO.. WHILE ===")
}

private fun CountWithRepeat(){

    println("\n=== USANDO REPEAT ===\n")
    repeat(100) { it ->
        print(it+1)
        print(", ")
    }
    println("\n")
    println("=== FIN USANDO REPEAT ===")
}

private fun CountWithRecursion(initial: Int){
    if (initial == 100) {
        print(initial)
        print(", ")
        println("\n")
        println("=== FIN USANDO RECURSIVIDAD ===")
    }
    else{
        if (initial == 1) {
            println("\n=== USANDO RECURSIVIDAD ===\n")
        }
        print(initial)
        print(", ")
        CountWithRecursion(initial + 1)
    }
}

private fun CountWithWhen(initial: Int){
    when (initial){
        0 -> {
            println("\n=== USANDO RECURSIVIDAD Y WHEN ===\n")
            CountWithWhen(initial+1)
        }
        in 1..100 -> {
            print(initial)
            print(", ")
            CountWithWhen(initial+1)
        }
        else-> {
            println("\n")
            println("=== FIN USANDO RECURSIVIDAD Y WHEN ===")
        }
    }
}

private fun CountUsingArray(){
    val numbers = IntArray(100) { it+1 }
    println("\n=== USANDO UN ARRAY ===\n")
    numbers.forEach {it ->
        print(it)
        print(", ")
    }
    println("\n")
    println("=== FIN USANDO UN ARRAY ===")
}