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


/**
 * Enumerado que representa las razas buenas de la Tierra Media
 */
enum class FreeLegion(val race:String,val value:Int) {
    harfoots("Pelosos",1),
    freevariags("Sureños buenos",2),
    dwarves("Enanos",3),
    numenoreans("Númenóreanos",4),
    elves("Elfos",5),
}

/**
 * Enumerado que representa las razas malas de la Tierra Media leales a Sauron
 */
enum class DarkLegion(val race:String,val value:Int ){
    darkvariags("Sureños malos",2),
    orcs("Orcos",2),
    goblins("Goblins",2),
    wargs("Huargos",3),
    trolls("Trolls",5)

}

enum class BattleResult(val legion:String){
    good("El bien"),
    evil("El mal"),
    tie("Empate")
}


/**
 * Funcion Principal
 */
fun main() {

    println("Batalla de la Tierra Media")
    println(middleEarthBattle(listOf(FreeLegion.harfoots,FreeLegion.dwarves), listOf(DarkLegion.trolls,DarkLegion.orcs)).legion)
    println(middleEarthBattle(listOf(FreeLegion.elves,FreeLegion.numenoreans,FreeLegion.dwarves), listOf(DarkLegion.trolls,DarkLegion.goblins)).legion)
}


/**
 * Funcion que calcula el resultado de la batalla entre los ejercitos de la Tierra Media
 * @param freeLegion ejercito de razas buenas
 * @param darkLegion ejercito de razas malas
 * @return resultado de la batalla BattleResult
 */
private fun middleEarthBattle(freeArmy : List<FreeLegion>,darkLegion: List<DarkLegion>): BattleResult{

    val freeArmyValue = freeArmy.sumOf { it.value } + freeArmy.size
    val darkLegionValue = darkLegion.sumOf { it.value } + darkLegion.size

    return if(freeArmyValue > darkLegionValue){
        BattleResult.good

    } else if(freeArmyValue < darkLegionValue){
        BattleResult.evil
    } else {
        BattleResult.tie
    }
}