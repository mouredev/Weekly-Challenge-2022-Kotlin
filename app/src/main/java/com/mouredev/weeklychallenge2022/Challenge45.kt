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

/**
* Emojis para representar el agua y los bloques y el vacio
*/
enum class Emojis(val emoji: String?) {
    BLOCK("⏹︎"),
    WATER("\uD83D\uDCA7"),
    EMPTY(" ")
}

fun main(){
    println("`Numero de bloques ${calculateWaterBlocks(arrayOf(3, 1, 6, 3, 0, 4))}")
    println("`Numero de bloques ${calculateWaterBlocks(arrayOf(3, 0, 0, 2, 0, 4))}")
    println("`Numero de bloques ${calculateWaterBlocks(arrayOf(1,0,3,4,0,0,2,1,0,1,2,1,0,1,0,3,2,1,2,1))}")
}

/**
 * Funcion que calcula las unidades de agua que se quedan atrapads entre los bloques
 * Se recorre empezando por los extremos del array comparando cada elemento.
 *  - Si el de la izquierda es mayor y es el mayor encontrado por la derecha , entonces ponemos
 * como maximo bloqque de altura ese valor.Si no contamos como bloques de agua , los bloques de altura maxima menos los que tiene
 * esa columna ya que son los que quedan atrapados , avanzamos a la siguiente columna y repetimos el proceso
 *  - Si la derecha es mayor que la izquierda y es el mayor de la izquierda , entonces ponemos
 *  como maximo bloque de altura por la izquierda ese valor.Si no contamos como bloques de agua los bloques de altura maxima menos
 *  los que tiene esa columna , avanzamos a la siguiente columna y repetimos el proceso.
 *  Avanzamos y repetimos hasta que la izquierda y la derecha se crucen.
 *
 * @param blocks Array de bloques de altura
 * @returns Numero de bloques de agua que quedan atrapados
 */

fun calculateWaterBlocks(blocks: Array<Int>): Int {
    val matrix = Array(blocks.size) { emptyArray<String?>()  }
    var water = 0
    var left = 0
    var right = blocks.size-1

    var maxLeft = 0
    var maxRight = 0
    var maxTotal = 0

    while (left<right){

        if(blocks[left]<blocks[right]){
            if(blocks[left]>maxLeft){
                maxLeft = blocks[left]
            }else{
                water += maxLeft - blocks[left]
            }
            matrix[left] = fillRow(maxLeft,blocks[left])
            left++
        }else{
            if(blocks[right]>maxRight){
                maxRight = blocks[right]
            }else{
                water += maxRight - blocks[right]
            }
            matrix[right] = fillRow(maxRight,blocks[right])
            right--
        }

        if(maxTotal < maxLeft){
            maxTotal = maxLeft;
        } else if(maxTotal < maxRight){
            maxTotal = maxRight;
        }
    }

    matrix[right] = fillRow(blocks[left],blocks[right]);

    if(maxTotal < blocks[right]){
        maxTotal = blocks[right];
    }


    drawMatrix(matrix, maxTotal)
    return water
}
/**
 * Funcion que rellena una fila con los emojis correspondientes de agua 💧 o bloque 🕋
 * @param maxValue Valor maximo de altura del bloque para el agua
 * @param value  Numero de bloques total que hay
 */
private fun fillRow(maxValue:Int,value:Int): Array<String?> {
    val row = Array(maxValue) { Emojis.EMPTY.emoji }
    for (i in 0 until value){
        row[i] = Emojis.BLOCK.emoji
    }
    for(i in 0 until maxValue-value){
        row[i] = Emojis.WATER.emoji
    }
    return row
}

/**
 * Funcion que rellena la matriz de bloques y agua relleando las columnas que no tienen valor
 * para poder pintarla correctamente
 * @param matrix Matriz de bloques y agua
 * @param max Total de bloques de altura maxima
 */
private fun calculateMatrix(matrix: Array<Array<String?>>,max:Int): Array<Array<String>> {
    val newMatrix = Array(max) { emptyArray<String>()  }

    for(i in 0 until max){
        newMatrix[i] = Array(matrix.size) { Emojis.EMPTY.emoji!! }

        for(j in 0 until matrix.size){
            if(j<matrix[j].size){
                if(i<matrix[j].size){
                matrix[j][i]?.let {
                    newMatrix[i][j] = it }
                }
            }

        }
    }
    return newMatrix

}
/**
 * Funcion que pinta la matriz de bloques y agua ya rellenada por consola
 * @param matrix Matriz de bloques y agua
 * @param maxTotal Total de bloques de altura maxima
 */
private fun drawMatrix(matrix: Array<Array<String?>>,maxTotal:Int) {

    val array = calculateMatrix(matrix,maxTotal)
    array.reverse()
    array.map {
        var row=""
        it.map {
            row += it
        }
        println(row)
    }


}