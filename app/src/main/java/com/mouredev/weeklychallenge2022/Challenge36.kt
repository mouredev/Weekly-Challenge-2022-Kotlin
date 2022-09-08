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


fun main(){


    val sauronsArmy = buildSauronsArmy(1,2,0,1,4)
    val goodArmy = buildGoodArmy(1,2,0,1,3)

    middleEarthFight(sauronsArmy,goodArmy)


}


enum class RACES(val attackValue:Int){
    HARFOOTS(1),
    GOOD_SOUTHRONS(2),
    DWARVES(3),
    NUMENOREANS(4),
    ELVES(5),
    BAD_SOUTHRONS(2),
    ORCS(2),
    GOBLINS(2),
    HUARGOS(3),
    TROLLS(5),
}


fun buildSauronsArmy(badSouthrons:Int, orcs:Int, goblins:Int, huargos:Int, trolls:Int ):Int {

var sauronsArmyAttackValue= 0

    sauronsArmyAttackValue+=badSouthrons*RACES.BAD_SOUTHRONS.attackValue
    sauronsArmyAttackValue+=orcs*RACES.ORCS.attackValue
    sauronsArmyAttackValue+=goblins*RACES.GOBLINS.attackValue
    sauronsArmyAttackValue+=huargos*RACES.HUARGOS.attackValue
    sauronsArmyAttackValue+=trolls*RACES.TROLLS.attackValue

return sauronsArmyAttackValue
}

fun buildGoodArmy(badSouthrons:Int, orcs:Int, goblins:Int, huargos:Int, trolls:Int ):Int {

    var goodArmyAttackValue = 0

    goodArmyAttackValue+=badSouthrons*RACES.HARFOOTS.attackValue
    goodArmyAttackValue+=orcs*RACES.GOOD_SOUTHRONS.attackValue
    goodArmyAttackValue+=goblins*RACES.DWARVES.attackValue
    goodArmyAttackValue+=huargos*RACES.NUMENOREANS.attackValue
    goodArmyAttackValue+=trolls*RACES.ELVES.attackValue

    return goodArmyAttackValue
}


fun middleEarthFight(sauronsAttack:Int, goodArmyAttack:Int){

    if(sauronsAttack>goodArmyAttack){
        print("Evil wins, fatality")
    }else if(sauronsAttack<goodArmyAttack){
        print("Good always wins against evil, babalality")
    }
    else{
        print("Tie, no one wins in war")
    }


}