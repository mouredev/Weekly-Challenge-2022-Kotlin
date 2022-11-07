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
 fun main() {
    val blockArray = arrayOf(4, 0, 3, 6, 1, 3)
    var height = 0
    var waterCount = 0

    while (true){
        var firstBlock = -1
        var lastBlock = -1
        var foundBlocksInHeight = 0
        for (i in 0 until blockArray.size){

            if (blockArray[i] > height){
                if (firstBlock==-1)
                    firstBlock = i
                lastBlock = i
                foundBlocksInHeight++
            }
        }
        if (foundBlocksInHeight !=  lastBlock-firstBlock+1)
            waterCount +=  (lastBlock-firstBlock+1)-foundBlocksInHeight
        else
            break
        height++
    }
    println("There are $waterCount water blocks")





}