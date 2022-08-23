package com.mouredev.weeklychallenge2022

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */



fun main (){


    val array = intArrayOf(1,5,20,30,32,35)
    val array2 = intArrayOf(1,2,3)
    val array3 = intArrayOf(1,2,4,3)
    val array4 = intArrayOf(1,3,3,6,7,8,9,10)
    val array5 = intArrayOf(1,4)

    print(lostNumbers(array))
}


fun lostNumbers(array: IntArray):List<Int> {

    if(array.size==1){
        return array.toList()
    }

    val lostNumbers = mutableListOf<Int>()

    var arrayCounter=1

    var numCounter = array[0]


    while(arrayCounter<array.size){

        if(array[arrayCounter-1]>=array[arrayCounter])
        {
            throw Exception("The array is not correct")
        }
        if(numCounter+1<array[arrayCounter]){
            numCounter++
            lostNumbers.add(numCounter)
        }else {
            numCounter++
            arrayCounter++
        }
    }
    return lostNumbers
}
