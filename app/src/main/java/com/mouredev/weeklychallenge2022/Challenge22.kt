package com.mouredev.weeklychallenge2022

/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Funcion Principal
 */
fun main(){
    print("Elementos comunes: " )
    printArray(checkElements(arrayOf(3, 1,"ff","a"), arrayOf(3, 4, 3, "a", 7), true))
    print("Elementos NO comunes: " )
    printArray(checkElements(arrayOf("a", "b", "c", "d", "e"), arrayOf("a", "b"), false))

}

/**
 * Funcion que imprime por pantalla un array
 * @param array Array a imprimir
 */
private fun printArray(array: Array<Any>) {

    for (i in array.indices) {
        print("${array[i]} ")
    }
    println()
}

/**
 * Funcion que devuelve los elementos comununes o no comunes de dos arrays
 * @param arrayOne Array de elementos 1
 * @param arrayTwo Array de elementos 2
 * @param commonElements Booleano que indica si se quiere los elementos comunes o no comunes
 * @return Array de elementos comunes o no comunes
 */
inline fun <reified T> checkElements(arrayOne: Array<T>, arrayTwo: Array<T>, commonElements: Boolean): Array<T> {
    val commonArray = mutableListOf<T>()
    val notCommonArray = mutableListOf<T>()

    arrayOne.forEach{
        if(arrayTwo.myContains(it)){
                commonArray.addElement(it)
            }else
                notCommonArray.addElement(it)
        }

    return if(commonElements){
        commonArray.toTypedArray()
    }else notCommonArray.toTypedArray()


}

/**
 * Funcion de extension que añade un elemento a una lista pero si ya existe no lo añade
 * @param element Elemento a añadir
 * @return Booleano que indica si se ha añadido o no el elemento
 */
fun <T> MutableList<T>.addElement(element: T): Boolean {
        if(!this.contains(element)){
            this.add(element)
            return true
        }
        return false
}

/**
 * Funcion de extension que comprueba si un elemento esta en un array
 * @param value Elemento a comprobar
 * @return Booleano que indica si el elemento esta en el array
 */
fun <T>Array<T>.myContains(value:T):Boolean{
    this.forEach {
        if(it == value){
            return true
        }
    }
    return false
}

