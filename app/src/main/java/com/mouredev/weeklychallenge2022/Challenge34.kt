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


fun main(){


    println(missingNumbers(arrayOf(1,6,10)).toList())
    println(missingNumbers(arrayOf(16,1)).toList())
    println(missingNumbers(arrayOf(1,2,2,10,30)).toList())
}


/**
 * Función que calcula los números perdidos entre el mayor y el menor de un array de enteros ordenado y sin repetidos.
 * @param array Array de enteros ordenado y sin repetidos.
 * @return Array de enteros con los números no encontrados.
 */
fun missingNumbers(array: Array<Int>): Array<Int> {


    if(!checkArray(array))
        return arrayOf()


    val min = array.first()
    val max = array.last()

    val missing = mutableListOf<Int>()

    for (i in min..max){
        if (!array.contains(i)){
            missing.add(i)

        }
    }

    return missing.toTypedArray()

}

/**
 * Función que comprueba si un array es correcto.
 * Comprueba si es tiene al menos 2 elementos , que no tenga elementos repetidos y que este ordenado
 * @param array Array de enteros
 * @return True si es correcto, false en caso contrario.
 */
private fun checkArray(array: Array<Int>): Boolean{

    if(array.isEmpty()){
        print("Array vacío ")
        return false
    }


    if(array.size< 2) {
        print("El array debe tener al menos 2 elementos ")
        return false
    }


    if(array.distinct().size!= array.size) {
        print("El array no puede tener elementos repetidos ")
        return false
    }

    if(!array.copyOf().sortedArray().contentEquals(array)){
        print("El array debe estar ordenado ")
        return false
    }

    return true

}
