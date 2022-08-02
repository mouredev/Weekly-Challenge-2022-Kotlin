package com.mouredev.weeklychallenge2022

/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val anno = 2020
    print(bisiestos(anno))
}

fun bisiestos(anno: Int): MutableList<Int> {
    var a = anno
    val bisiestos = mutableListOf<Int>()
    while (bisiestos.size != 30) {
        if (es_bisiesto(a)) {
            bisiestos.add(a)
        }
        a += 1;
    }

    return bisiestos
}

fun es_bisiesto(anno: Int): Boolean {
    return anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0)
}