package com.mouredev.weeklychallenge2022

/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

data class Kid (var Name: String, var Age: Int, var Height: Int)

fun main() {

    println("HALLOWEEN 2022. Selecciona Truco (1) o Trato (2)")
    println("Introduce el numero a convertir: ")
    var num =  readLine()?.toIntOrNull()
    if (num != null) {
        if (num == 1) {
            TrickOrTreating(listOf(Kid("Tom", 2, 80), Kid("John", 6, 120), Kid("Martha", 26, 165), Kid("Peter", 12, 135)), "Trick")
            TrickOrTreating(listOf(Kid("Harry", 11, 125), Kid("Hermione", 12, 120), Kid("Ron", 11, 119), Kid("Draco", 12, 135)), "Trick")
        }
        else if (num == 2)
        {
            TrickOrTreating(listOf(Kid("Tom", 2, 80), Kid("John", 6, 120), Kid("Martha", 26, 165), Kid("Peter", 12, 135)), "Threat")
            TrickOrTreating(listOf(Kid("Harry", 11, 125), Kid("Hermione", 12, 120), Kid("Ron", 11, 119), Kid("Draco", 12, 135)), "Threat")
        }
        else {
            println("Error: Introduce 1 o 2")
        }
    } else {
        println("¡Eso no es un número entero!")
    }
}

private fun TrickOrTreating(listKids: List<Kid>, action: String) {
    var numberOfReward = 0

    when(action) {
        "Threat", "Trick" -> {
            numberOfReward += NumberOfLettersInName(listKids, action)
            numberOfReward += AgesOfKids(listKids, action)
            numberOfReward += HeightOfKids(listKids, action)
        }
        else -> println("Error")
    }

    GiveReward(numberOfReward, action)
}

private fun NumberOfLettersInName(listKids: List<Kid>, action: String): Int {
    var reward = 0

    when(action) {
        "Threat" -> {
            listKids.forEach {
                reward += it.Name.length
            }
        }
        "Trick" -> {
            listKids.forEach {
                reward += it.Name.length / 2
            }
        }
    }

    return reward
}

private fun AgesOfKids(listKids: List<Kid>, action: String): Int {
    var reward = 0

    when(action) {
        "Threat" -> {
            listKids.forEach {
                if (it.Age % 2 == 0)
                    reward += 2
            }
        }
        "Trick" -> {
            listKids.forEach {
                if (it.Age >= 10)
                    reward += 3
                else
                    reward += it.Age / 3
            }
        }
    }

    return reward
}

private fun HeightOfKids (listKids: List<Kid>, action: String): Int {
    var reward = 0
    var totalHeight = 0

    when(action) {
        "Threat" -> {
            listKids.forEach {
                if (it.Height >= 150)
                    reward += 6
                else
                    reward += 2 * (it.Height / 50)
            }
        }
        "Trick" -> {
            listKids.forEach {
                totalHeight += it.Height
            }
            reward = 3 * totalHeight / 100
        }
    }

    return reward
}

private fun GiveReward(numberOfReward: Int , action: String){
    val Tricks = arrayOf("🎃","👻", "💀", "🕷", "🕸", "🦇")
    val Treats = arrayOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩")
    var Reward = ""

    for (i in 1..numberOfReward)
    {
        if (action =="Trick")
            Reward+= Tricks.random()
        else
            Reward+= Treats.random()
    }
    println(Reward)
}