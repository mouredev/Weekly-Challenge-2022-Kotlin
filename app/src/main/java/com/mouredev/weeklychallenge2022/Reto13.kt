
fun main(){
    val nums = arrayOf(3, 5, 7, 9, 11)
    for(i in nums)
    println("El factorial de $i es: ${factorial(i)}")
}

/*fact: es el numero al que queremos conocer su factorial
result: es el resultado de la multiplicacion anterior, con valor inicial de 0
Ejemplo: 4! -> fact = 4, 4x3 (4-1)
result toma el valor de 12, ahora
fact = 3, result = 12, 12x2 (3-1)
fact = 2, result = 24
La funcion se detiene cuando llega a 1 (2-1), asi que retorna 24 a todas sus llamadas
*/
private fun factorial(fact: Int, result: Int = 0): Int {
    if(fact <= 1){
        return result
    } else if(result == 0){
        return factorial(fact - 1, fact * (fact-1))
    } else {
        return factorial(fact-1, result * (fact-1))
    }
}
