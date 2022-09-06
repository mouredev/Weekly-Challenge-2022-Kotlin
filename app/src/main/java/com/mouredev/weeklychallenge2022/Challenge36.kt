package com.mouredev.weeklychallenge2022

/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    val g = arrayListOf(Pair(20, Good.Elfos), Pair(0, Good.Enanos))
    val b = arrayListOf(Pair(20, Bad.Huargos))
    println(battle(g, b))
}

enum class Good(val valor: Int) {
    Pelosos(1),
    Sureñosbuenos(2),
    Enanos(3),
    Númenóreanos(4),
    Elfos(5)
}

enum class Bad(val valor: Int) {
    Sureñosmalos(2),
    Orcos(2),
    Goblins(2),
    Huargos(3),
    Trolls(5)
}

fun battle(g: List<Pair<Int, Good>>, b: List<Pair<Int, Bad>>): String {

    var puntos_g = 0;
    var puntos_b = 0;
    g.forEach {
        puntos_g += it.first * it.second.valor
    }

    b.forEach {
        puntos_b += it.first * it.second.valor
    }


    if (puntos_g - puntos_b > 0) {
        return "ganan los buenos"
    } else if (puntos_g - puntos_b < 0) {
        return "ganan los malos"
    }
    return "empate"
}
