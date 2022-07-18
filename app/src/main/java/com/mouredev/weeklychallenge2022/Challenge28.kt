package com.mouredev.weeklychallenge2022

import org.omg.CORBA.ORB.init

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

private enum class Coin(val value: Int) {
    FIVE(5),
    TEN(10),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200)
}

private class Product(val name: String, val number: Int, val value: Int)

private fun getExchange(value: Int): Array<Coin> {
    var rest = value
    var result: MutableList<Coin> = mutableListOf()
    do {
        val biggestCoin = Coin.values().filter{ it.value <= rest }.sorted().last()
        rest -= biggestCoin.value
        result.add(biggestCoin)
    } while(rest > 0)
    return result.toTypedArray()
}

private fun getProduct(productNumber: Int, money: Array<Coin>): Pair<String, Array<Coin>> {
    val machineProducts = arrayOf(
        Product("Estrella Galicia", 1, 120),
        Product("Alhambra Lager Singular", 2, 120),
        Product("Estrella Galicia 1906", 3, 180),
        Product("Alhambra Reserva 1900", 4, 180),
        Product("Heineken", 5, 20)
    )

    val selectedProducts = machineProducts.filter{ it.number == productNumber}
    return if(selectedProducts.size == 0) {
        println("Ningún producto tiene el identificador $productNumber")
        Pair("", money)
    } else if(selectedProducts[0].value > money.sumOf{ it.value }) {
        println("Saldo insuficiente")
        Pair("", money)
    } else {
        Pair(selectedProducts[0].name, getExchange(money.sumOf{ it.value } - selectedProducts[0].value))
    }
}

fun main() {
    var product = getProduct(7, arrayOf(Coin.FIFTY))
    println(if(product.first.isEmpty()) "" else "Producto: ${product.first} - monedas: ${product.second.map{ it.value }}")
    product = getProduct(1, arrayOf(Coin.FIFTY, Coin.FIFTY))
    println(if(product.first.isEmpty()) "" else "Producto: ${product.first} - monedas: ${product.second.map{ it.value }}")
    product = getProduct(2, arrayOf(Coin.TWO_HUNDRED))
    println(if(product.first.isEmpty()) "" else "Producto: ${product.first} - monedas: ${product.second.map{ it.value }}")
}
