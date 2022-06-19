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


/**
 * constante que indica el número máximo de iteraciones
 */
const val MAX_NUMBER = 100

/**
 * Funcion principal
 */
fun main(){
    countFor()
    countDoWhile()
    countWhile()
    countInfixFunction()
    countForEach()
    countRepeat()
    countArrays()
    countRecursive(1)
}

/**
 * función que imprime del 1 a MAX_NUMBER de uno en uno con un bucle for simple
 */
fun countFor(){
    println("Bucle for")
    for (i in 1..MAX_NUMBER){
        printNumber(i)
    }
}

/**
 * función que imprime del 1 al MAX_NUMBER de uno en uno con un bucle do while
 */
fun countDoWhile(){
    var i = 1
    println("Bucle do - while")
    do{
        printNumber(i)
        i++
    }while (i <= MAX_NUMBER)
}

/**
 * función que imprime del 1 al MAX_NUMBER de uno en uno con un bucle while simple
 */
fun countWhile(){
    println("Bucle while")
    var i = 1
    while (i <= MAX_NUMBER){
        printNumber(i)
        i++
    }
}



/**
 * función que imprime del 1 al MAX_NUMBER de uno en uno con un bucle infix function until
 */
fun countInfixFunction(){
    println("Bucle until")
    for(i in 1..MAX_NUMBER){
        printNumber(i)
    }
}

/**
 * función que imprime del 1 al MAX_NUMBER de uno en uno con un bucle forEach
 */
fun countForEach(){

    println("Bucle forEach")
    val range = 1..MAX_NUMBER
    range.forEach{
        printNumber(it)
    }
}

/**
 * Funcion que imprime del 1 al MAX_NUMBER de uno en uno recorriendo un array
 */
fun countArrays(){
    println("Bucle arrays")
    val array = Array(MAX_NUMBER){
        it + 1
    }
    array.forEach{
        printNumber(it)
    }
}

/**
 * función que imprime del 1 al MAX_NUMBER de uno en uno con un bucle recursivo
 */
fun countRecursive(n:Int):Int{

    if(n==1){
        println("Recursividad")

    }

    return if(n<=MAX_NUMBER){
        printNumber(n)
        countRecursive(n+1)
    }
    else
        MAX_NUMBER

}
/**
 * función que imprime un número usando la funcion repeat
 */

fun countRepeat(){
    println("Bucle repeat")
    repeat(MAX_NUMBER){
        printNumber(it+1)
    }
}
/**
 * función que imprime un número por pantalla
 */
private fun printNumber(number: Int){
    print("$number" + if(number == MAX_NUMBER) "\n" else ",")
}