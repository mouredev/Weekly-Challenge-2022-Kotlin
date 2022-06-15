/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 */

import kotlin.math.abs

fun main() {
    contar(100)
    contar(-54)
}

fun contar(max: Int){
    val absMax = abs(max) //Por si se pasa un negativo
    val listOfCounts = ArrayList<Int>() //Lista para obtener los números que pueden llegar hasta el máximo
    var count = 1
    while(count <= absMax){
        if((absMax % count) == 0){
            val list = ArrayList<Int>() //Lista para obtener la cuenta
            for(i in count..absMax step count) list.add(i)
            println(list) //Imprimir toda la cuenta
            listOfCounts.add(count)
        }
        count++
    }
    println("Los numeros que pueden llegar al $max son $listOfCounts")
}
