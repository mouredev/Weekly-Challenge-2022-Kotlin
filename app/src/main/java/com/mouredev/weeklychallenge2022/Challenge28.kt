package com.mouredev.weeklychallenge2022

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

object VendingMachine {

    data class Product(val id: Int, val name: String, val price: Int)

    private val products = listOf(
        Product(1, "product 1", 235),
        Product(2, "product 2", 50),
        Product(3, "product 3", 470),
        Product(4, "product 4", 115),
    )

    private val allowedCoins = listOf(200, 100, 50, 10, 5)

    sealed class Result(val change: List<Int>) {
        class Failure(val message: String, change: List<Int>) : Result(change)
        class Success(val productName: String, change: List<Int>) : Result(change)
    }

    fun purchase(productId: Int, coins: List<Int>): Result {
        val product = products.firstOrNull { product ->
            product.id == productId
        } ?: return Result.Failure("Invalid product id", coins)
        if (coins.any { coin -> coin !in allowedCoins }) {
            return Result.Failure("At least one of the coins isn't allowed", coins)
        }
        if (product.price > coins.sum()) {
            return Result.Failure("Coins aren't enough to pay for the product", coins)
        }

        val change = mutableListOf<Int>()
        var leftToReturn = coins.sum() - product.price
        for (coin in allowedCoins) {
            if (leftToReturn == 0) break

            change += List(leftToReturn / coin) { coin }
            leftToReturn %= coin
        }

        return if (leftToReturn != 0) {
            // Won't ever happen with this product prices and allowed coins
            Result.Failure("Couldn't form a valid change with the allowed coins", coins)
        } else {
            Result.Success(product.name, change)
        }
    }
}

fun main() {
    val testCases = listOf(
        2 to listOf(100, 20, 50),   // Invalid coin
        3 to listOf(50, 50, 10, 5), // Insufficient amount
        0 to listOf(200, 50, 200),  // Invalid id
        1 to listOf(50, 50, 200),   // Inexact amount
        4 to listOf(5, 5, 5, 100),  // Exact amount
    )

    testCases.forEach { (productId, coins) ->
        println("Purchasing product with id: $productId using coins: ${coins.joinToString()}")
        when (val result = VendingMachine.purchase(productId, coins)) {
            is VendingMachine.Result.Failure -> {
                println("Error purchasing: ${result.message}")
                println("Returned change: ${result.change.joinToString()}")
            }
            is VendingMachine.Result.Success -> {
                println("Purchased product: ${result.productName}")
                println("Returned change: ${result.change.joinToString()}")
            }
        }
        println()
    }
}