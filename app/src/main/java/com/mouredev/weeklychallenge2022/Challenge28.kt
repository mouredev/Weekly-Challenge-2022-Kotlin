package com.mouredev.weeklychallenge2022

import java.lang.NumberFormatException
import java.util.*

/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

val availableCoins = listOf(5, 10, 50, 100, 200)

val products = linkedMapOf(
    "Natural water 1L" to 50,
    "Cold water 1L" to 60,
    "Coca-Cola" to 80,
    "Chips" to 135,
    "Chocolate bar" to 100,
    "Sandwich" to 225,
    "Salad" to 650,
)

fun main() {
    showMenu()
    val coins = enterCoins()
    val option = selectOption()
    if (option == 0) {
        exitMachine(coins)
        return
    }
    manageProduct(products.entries.elementAt(option - 1), coins)
}

private fun showMenu() {
    println("Welcome to Gecko's machine!")
    println("To get a product, enter your coins one by one.")
    println("When you're done, hit enter again (with an empty input) and select your product number.")
    println("Supported coins: ${getCoins(availableCoins)}\n")
    println("--PRODUCTS--")
    for (index in products.entries.indices) {
        println(
            "${index + 1}.- ${products.keys.elementAt(index)} for ${
                products.values.elementAt(
                    index
                )
            } cents."
        )
    }
}

private fun enterCoins(): List<Int> {
    val coins = mutableListOf<Int>()
    var total = 0
    val reader = Scanner(System.`in`)
    println("\nEnter your coins: ")
    while (true) {
        try {
            print("Input (Press enter without a coin to select product): ")
            val num = reader.nextLine()
            if (num.equals("")) {
                if (total == 0) {
                    println("Before selecting a product, please, enter coins")
                } else {
                    break
                }
            } else if (availableCoins.contains(num.toInt())) {
                coins.add(num.toInt())
                total += num.toInt()
                println("Total entered: $total")
            } else {
                throw InputMismatchException()
            }
        } catch (e: InputMismatchException) {
            println("Please, enter a supported coin.")
        } catch (e: NumberFormatException) {
            println("Please, enter only numbers")
        }
    }
    return coins
}

private fun selectOption(): Int {
    return try {
        println("\nType the number of your product or press 0 to exit and get your coins back.")
        print("Enter product number: ")
        val num = Scanner(System.`in`).nextInt()
        if (num <= products.size && num >= 0) {
            println()
            num
        } else {
            throw InputMismatchException()
        }
    } catch (e: InputMismatchException) {
        println("Wrong number, please select a proper input.")
        selectOption()
    }
}

private fun exitMachine(coins: List<Int>) {
    println("We are sorry to see you going away without a product.")
    println("Here are your coins back: ${getCoins(coins)}")
    println("Have a good day! =)")
}

private fun manageProduct(product: MutableMap.MutableEntry<String, Int>, coins: List<Int>) {
    var total = 0
    coins.forEach { coin ->
        total += coin
    }
    if (total >= product.value) {
        print("Preparing to eject ${product.key}. Cost: ${product.value}")
        (0..2).forEach { num ->
            Thread.sleep(1000)
            print(".")
            if (num == 2) {
                println()
            }
        }
        if (total != product.value) {
            var diff = total - product.value
            val returnCoins = mutableListOf<Int>()
            for (i in availableCoins.lastIndex downTo 0) {
                while (diff >= availableCoins[i]) {
                    returnCoins.add(availableCoins[i])
                    diff -= availableCoins[i]
                }
            }
            println("Please, don't forget your returned coins: ${getCoins(returnCoins)}")
        }
        println("Please, get your ${product.key}.")
        println("Thanks for your purchase at the Gecko's machine!")
        println("Have a good day! =)")
    } else {
        println("Oops! Looks like you entered not enough money to purchase the product.")
        println("Needed -> ${product.value} cts.")
        println("Given -> $total cts.")
        println("Returning given coins: ${getCoins(coins)}")
    }
}

private fun getCoins(coins: List<Int>): String {
    var str = ""
    coins.forEachIndexed { index, coin ->
        str += if (index != coins.lastIndex) {
            "$coin, "
        } else {
            "$coin."
        }
    }
    return str
}