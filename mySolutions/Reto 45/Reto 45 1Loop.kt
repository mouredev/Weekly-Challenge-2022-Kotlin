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
    val wallArray = arrayOf(4, 0, 0, 0, 0, 4)
    val wallArray2 = arrayOf(4, 3, 1, 6, 1, 3)
    val wallArray3 = arrayOf(1, 4, 3, 2, 1, 3)
    val wallArray4 = arrayOf(0, 1, 2, 3, 4, 5)
    val wallArray5 = arrayOf(5, 4, 3, 2, 3, 0)
    val wallArray6 = arrayOf(6, 0, 5, 0, 4)




    fun calculateWater(walls :Array<Int>){
        var Count = 0;
        var negCount = 0;
        var maxHeight = walls[0]
        var topWall = 0
        var sideTopWall = 0
        var lastTop = 0
        for (i in 1..walls.size-1){
            if (walls[i] > topWall)
                topWall = i
        }
        for (i in 0..topWall-1){
            if (walls[i] < sideTopWall)
                sideTopWall = walls[i]
            else
                Count +=  sideTopWall - walls[i]
        }
        for (i in 0..topWall-1){
            CheckWall()
        }
        sideTopWall = 0
        for (i in walls.size downTo topWall-1)
            if (walls[i] < sideTopWall)
                sideTopWall = walls[i]
            else
                Count +=  sideTopWall - walls[i]
        fun CheckWall()
        {
            if (walls[i] < sideTopWall)
                sideTopWall = walls[i]
            else
                Count +=  sideTopWall - walls[i]
        }


        println("There are $Count water units")}

    calculateWater(wallArray)
    calculateWater(wallArray2)
    calculateWater(wallArray3)
    calculateWater(wallArray4)
    calculateWater(wallArray5)
    calculateWater(wallArray6)
}






}
