


/*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para indicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main(){
    var testMoves1 = arrayOf(10, 5, -2)
    var testMoves2 = arrayOf(10, 5, 10, 5)
    var testMoves3 = arrayOf(10, 10, -5, 5)
    var testMoves4 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    fun calculateFinalPosition(moves :Array<Int>){
        var rawMoves = IntArray(4){0}
        for (i in moves.indices)
            rawMoves[i%4]+=moves[i]
        println("The final robot position is x: ${rawMoves[3]-rawMoves[1]}, y: ${rawMoves[0]-rawMoves[2]}")
    }
    calculateFinalPosition(testMoves1)
    calculateFinalPosition(testMoves2)
    calculateFinalPosition(testMoves3)
    calculateFinalPosition(testMoves4)


}