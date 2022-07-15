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

fun main() {
    buy(listOf(10, 200, 50, 50, 20, 20, 10), 2)
    //buy(listOf(50, 20, 5), 2)
}

data class Product(
    val id: Int = 0,
    val description: String = "",
    val price: Int = 0,
)

val validCoin = listOf(5, 10, 20, 50, 100, 200)

val products = listOf(
    Product(1, "Chocolatina", 150),
    Product(2, "Chicle", 75),
    Product(3, "Gominola", 50),
    Product(4, "Bolsa de Snaks", 150),
    Product(5, "Bebida Energetica", 370),
    Product(6, "Donut", 150),
    Product(7, "Refresco", 150),
    Product(8, "Agua", 100),
    Product(9, "Berlina", 220),
    Product(10, "Tabaco", 530)
)

val errors = mapOf(
    // 1xx- payment error
    101 to "Introduce importe del producto o superior",
    102 to "Moneda desconocida. Solo se admiten monedas de $validCoin",
    // 2xx - product error
    201 to "Producto no valido"
)

fun buy(pay: List<Int>, product: Int) {
    var productSelected = Product()

    if (products.filter { it.id == product }.isNotEmpty()) {
        productSelected = products.filter { it.id == product }.first()
    }

    val error: Int = validateInput(pay, productSelected)

    if (error == 0) {
        val totalRefund = pay.sum() - productSelected.price

        val refund = calculateRefund(totalRefund, validCoin)

        println("Importe introducido  : ${pay.sum()}")
        println("Producto seleccionado: " +
                "${productSelected.id}-" +
                "${productSelected.description} " +
                "(${productSelected.price}\$)"
        )
        println("Importe devolución   : $totalRefund")
        println("Devolución           : $refund")
        println("\nSu ${productSelected.description}, GRACIAS!!!")
    } else if (error in errors.keys) {
        println("$error - ${errors.getValue(error)}")
        println("Devolución: ${pay.sorted()}")
    }
}

fun validateInput(pay: List<Int>, product: Product): Int {
    var error = 0

    if (pay.isEmpty() || pay.sum() == 0 || pay.sum() < product.price) error = 101

    if (error == 0 && pay.minus(validCoin).isNotEmpty()) error = 102

    if (error == 0 && product.id == 0) error = 201

    return error
}

fun calculateRefund(totalRefund: Int, validCoin: List<Int>): List<Int> {
    val refund: MutableList<Int> = mutableListOf()

    if (totalRefund == 0) return refund

    var tRefund = totalRefund

    validCoin.reversed().forEach {
        if (it <= tRefund) {
            do {
                refund.add(it)
                tRefund -= it
            } while (it <= tRefund)
        }
    }

    return refund.sorted()
}