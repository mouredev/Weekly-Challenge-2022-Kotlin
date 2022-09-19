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

enum class FRIENDLY_FORCES(val value: Int) {
    PELOSOS(1),
    SURENOS_BUENOS(2),
    ENANOS(3),
    NUMENOREANOS(4),
    ELFOS(5)
}

enum class EVIL_FORCES(val value: Int) {
    SURENOS_MALOS(2),
    ORCOS(2),
    GOGLINS(2),
    HUARGOS(3),
    TROLL(5)
}

//Ejercito buenos y cantidad de efectivos
val mapFriendlyForce = hashMapOf(
    FRIENDLY_FORCES.PELOSOS to 1,
    FRIENDLY_FORCES.SURENOS_BUENOS to 0,
    FRIENDLY_FORCES.ENANOS to 0,
    FRIENDLY_FORCES.NUMENOREANOS to 0,
    FRIENDLY_FORCES.ELFOS to 0
)

//Ejercito malos y cantidad de efectivos
val mapEvilForce = hashMapOf(
    EVIL_FORCES.SURENOS_MALOS to 0,
    EVIL_FORCES.ORCOS to 1,
    EVIL_FORCES.GOGLINS to 0,
    EVIL_FORCES.HUARGOS to 0,
    EVIL_FORCES.TROLL to 0
)

fun main() {
    println(battle(mapFriendlyForce, mapEvilForce))
}

fun battle(
    friendlyForces: HashMap<FRIENDLY_FORCES, Int>,
    evilForces: HashMap<EVIL_FORCES, Int>
): String {
    val sumFriendlyForces = friendlyForces.map { it.key.value * it.value }.sum()
    val sumEvilForces = evilForces.map { it.key.value * it.value }.sum()

    if (sumFriendlyForces > sumEvilForces) {
        return "Han ganado los buenos"
    }
    if (sumFriendlyForces < sumEvilForces) {
        return "Han ganado los malos"
    }
    return "La batalla ha terminado en empate"
}
