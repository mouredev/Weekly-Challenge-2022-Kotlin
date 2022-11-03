package es.jaimefere.weeklychallenge2022

import kotlin.math.floor
import kotlin.math.min
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

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

private enum class HalloweenAction { TRICK, TREAT }

private class Child(val name: String, val age: Int, val height: Int)

private fun showScares(counter: Int) {
    val scares = arrayOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    (1..counter).forEach { _ -> print(scares[nextInt(0, scares.size)]) }
}

private fun showSweets(counter: Int) {
    val sweets = arrayOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩")
    (1..counter).forEach { print(sweets[nextInt(0, sweets.size)]) }
}

private fun trickOrTreat(children: Array<Child>, halloweenAction: HalloweenAction) {
    if(halloweenAction == HalloweenAction.TRICK) {
        var totalHeight = 0
        children.forEach { child ->
            showScares(child.name.length / 2)       // 11
            if(child.age % 2 == 0){ showScares(2) } // 4
            totalHeight += child.height
        }
        showScares((totalHeight / 100) * 3)         // 15
    } else {
        children.forEach { child ->
            showSweets(child.name.length)                           // 23
            showSweets(min(child.age, 10) / 3)          // 11
            showSweets(min(child.height, 150) / 50 * 2) // 18
        }
    }
    println()
}

fun main() {
    trickOrTreat(arrayOf(Child("Juan", 9, 140), Child("Arturo", 11, 121), Child("Rodrigo", 8, 162), Child("Javier", 12, 136)), HalloweenAction.TRICK)
    trickOrTreat(arrayOf(Child("Juan", 9, 140), Child("Arturo", 11, 121), Child("Rodrigo", 8, 162), Child("Javier", 12, 136)), HalloweenAction.TREAT)
}
