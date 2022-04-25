package com.mouredev.weeklychallenge2022

/*
 * Reto #17
 * LA CARRERA DE OBSTÁCULOS
 * Fecha publicación enunciado: 25/04/22
 * Fecha publicación resolución: 02/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
 *        variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
data class ResultadoCarrera(val resultado: Boolean, val carrera: String)

fun String.carreraCorredor(pasosCorredor: Array<String>): ResultadoCarrera{
    // Sacamos los pasos de la carrera a un array
    val pasosCarrera = this.asIterable().map{ c -> c.toString() }.toMutableList()
    // Preparamos la carrera teórica del corredor
    val carreraTeorica = pasosCorredor.map { p -> if(p.lowercase() == "run") "_" else "|" }.toMutableList()

    // Si la carrera del corredor tiene la misma longitud que la real...
    if (carreraTeorica.size != pasosCarrera.size){

        // Si la longitud de la carrera teórica no es igual a la real...
        if (carreraTeorica.size > pasosCarrera.size){
            val subCarrera = carreraTeorica.slice(pasosCarrera.size until carreraTeorica.size)
                .map { x -> if (x == "run") "|" else "_" }
            pasosCarrera.addAll(subCarrera)
        }else{
            val subCarreraCorredor = pasosCarrera.slice(carreraTeorica.size until pasosCarrera.size)
                .map { x -> if (x == "_") "jump" else "run" }
            carreraTeorica.addAll(subCarreraCorredor)
        }
    }

    val resultadoCarrera = pasosCarrera.mapIndexed { idx, str ->
        if (carreraTeorica[idx] == str)
            str
        else
            "${if(str == "_") "x" else "/"}"
    }
    val carreraValida = !resultadoCarrera.any { x -> x == "x" || x == "/" }

    return ResultadoCarrera(carreraValida, resultadoCarrera.joinToString(""))
}

fun main() {
    val resultado1 = "__|_|__||__".carreraCorredor(arrayOf("run",
        "run",
        "jump",
        "run",
        "jump",
        "run",
        "run",
        "jump",
        "jump",
        "run","run"))

    println("Resultado corredor 1: ${resultado1.resultado} -> ${resultado1.carrera}")

    val resultado2 = "__|_|__||__".carreraCorredor(arrayOf("run",
        "run",
        "run",
        "run",
        "jump",
        "run",
        "run",
        "jump",
        "jump",
        "run","run"))

    println("Resultado corredor 2: ${resultado2.resultado} -> ${resultado2.carrera}")

    val resultado3 = "__|_|__||__".carreraCorredor(arrayOf("run",
        "jump",
        "run",
        "run",
        "run",
        "run",
        "run",
        "jump",
        "jump",
        "run","run"))

    println("Resultado corredor 3: ${resultado3.resultado} -> ${resultado3.carrera}")

    val resultado4 = "__|_|__||__".carreraCorredor(arrayOf("run",
        "run",
        "jump",
        "run",
        "jump",
        "run",
        "run",
        "jump"))

    println("Resultado corredor 4: ${resultado4.resultado} -> ${resultado4.carrera}")
}