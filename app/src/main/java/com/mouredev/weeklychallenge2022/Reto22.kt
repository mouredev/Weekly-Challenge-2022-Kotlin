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
 */
 
fun main() {

    println(findInArray(arrayOf(2, 2, 5, 3), arrayOf(2, 8, 8, 10), true).contentToString())
    println(findInArray(arrayOf(2, 2, 5, 3), arrayOf(2, 8, 8, 10), false).contentToString())
    println(findInArray(arrayOf(2, 2, 5, 3, 21), arrayOf(2, 8, 8, 1, 10, 10), true).contentToString())

}

//Usando genericos no me dejaba xD, por eso uso Any
private fun findInArray(array1: Array<Any>, array2: Array<Any>, findCommons: Boolean): Array<Any> {
    val mapValues = HashMap<Any, Int>()
    addToMap(mapValues, array1)
    addToMap(mapValues, array2)
    println(mapValues)
    val listOfResult = ArrayList<Any>()
    mapValues.forEach{entry ->
        if(findCommons){
            if(entry.value >= 2) listOfResult.add(entry.key)
        } else {
            if(entry.value < 2) listOfResult.add(entry.key)
        }
    }
    var n = 0
    val resultArray = Array<Any>(listOfResult.size){
        listOfResult.get(n++)
    }
    return resultArray
}

private fun<T> addToMap(mapValues: HashMap<T, Int>, array: Array<T>){
    for(element in array){
        if(mapValues.containsKey(element)) {
            mapValues[element] = mapValues[element]!! + 1
        } else {
            mapValues[element] = 1
        }
    }
}