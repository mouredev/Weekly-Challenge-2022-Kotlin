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

fun main(){

    val cashFromUser = listOf<Int>(5, 5, 20, 200)
    val product = 1
    val buy = buy(cashFromUser, product)
    print(buy)
}

fun buy(cashFromUser:List<Int>, productSelected: Int): Pair<String, MutableList<Int>> {

    val products = mapOf(
        1 to Pair("cookie",100),
        2 to Pair("snack", 200),
        3 to Pair("coffee",600),
        4 to Pair("water",700)
    )
    val (product, price) = products[productSelected] as Pair

    if (cashFromUser.sum() < price) print("You don't have enough cash")

    val cashBack = cashBack(cashFromUser, price)

    return Pair(product, cashBack)

}

fun cashBack(cashFromUser:List<Int>, price : Int): MutableList<Int> {

    var cashBackInt = cashFromUser.sum().minus(price)
    val allowedCash = listOf(200, 100, 50, 10, 5)
    val cashBack = mutableListOf<Int>()

    if (cashBackInt in allowedCash) {
        cashBack.add(cashBackInt)
    } else{
        while (cashBackInt > 0){
            for (money in allowedCash){
                if (cashBackInt >= money){
                    cashBack.add(money)
                    cashBackInt -= money
                    break
                }
            }
        }
    }

    return cashBack
}
