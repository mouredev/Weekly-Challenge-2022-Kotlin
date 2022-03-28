/*

 * Reto #13

 * FACTORIAL RECURSIVO

 * Fecha publicación enunciado: 28/03/22

 * Fecha publicación resolución: 04/04/22

 * Dificultad: FÁCIL

 *

 * Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.

 *

 * Información adicional:

 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.

 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.

 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.

 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.

 *

 */

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
