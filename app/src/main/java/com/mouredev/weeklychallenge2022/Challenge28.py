""" package com.mouredev.weeklychallenge2022

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

    println(buy(1, arrayOf(Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE)))
    println(buy(3, arrayOf(Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE)))
    println(buy(1, arrayOf(Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE, Money.FIFTY)))
    println(buy(5, arrayOf(Money.TWOHUNDRED)))

}

enum class Money(val money: Int) {

    FIVE(5),
    TEN(10),
    FIFTY(50),
    ONEHUNDRED(100),
    TWOHUNDRED(200)

}

private fun buy(code: Int, money: Array<Money>): Pair<String, Array<Money>> {

    val products = mapOf<Int, Pair<String, Int>>(
        1 to Pair("Agua", 50),
        2 to Pair("Coca-Cola", 100),
        4 to Pair("Cerveza", 155),
        5 to Pair("Pizza", 200),
        10 to Pair("Donut", 75)
    )

    products[code]?.let { product ->

        var totalMoney = 0
        money.forEach { coin ->
            totalMoney += coin.money
        }

        if (totalMoney < product.second) {
            return Pair("El producto con código [${code}] tiene un coste ${product.second}. Has introducido ${totalMoney}.", money)
        }

        val pendingMoney = totalMoney - product.second

        return Pair(product.first, returnMoney(pendingMoney))
    }

    return Pair("El producto con código [${code}] no existe.", money)
}

private  fun returnMoney(pendingMoney: Int, money: Array<Money> = arrayOf()): Array<Money> {

    if (pendingMoney == 0) {
        return money
    }

    var newPendingMoney = pendingMoney
    val newMoney = money.toMutableList()

    for (coin in Money.values().reversed()) {
        if (coin.money <= pendingMoney) {
            newPendingMoney -= coin.money
            newMoney.add(coin)
            break
        }
    }

    return returnMoney(newPendingMoney, newMoney.toTypedArray())
}
 """


from enum import Enum


class Money(Enum):

    FIVE = 5
    TEN = 10
    FIFTY = 50
    ONEHUNDRED = 100
    TWOHUNDRED = 200


class Vending():

    def __init__(self, moneys: list, product: str) -> None:

        self.moneys = moneys
        self.product = product
        self.products_price = {'Agua': 50, 'Coca-Cola': 100,
                               'Cerveza': 155, 'Pizza': 200, 'Donut': 75}

    def money_into(self):

        money_into = 0

        for money in self.moneys:
            money_into += money.value

        return money_into

    def money_return(self):

        rest_money = self.money_into() - self.products_price[self.product]

        money_return = []

        while rest_money > 0:

            if rest_money >= Money.TWOHUNDRED.value:
                money_return.append(Money.TWOHUNDRED.name)
                rest_money -= Money.TWOHUNDRED.value

            elif rest_money >= Money.ONEHUNDRED.value:
                money_return.append(Money.ONEHUNDRED.name)
                rest_money -= Money.ONEHUNDRED.value

            elif rest_money >= Money.FIFTY.value:
                money_return.append(Money.FIFTY.name)
                rest_money -= Money.FIFTY.value

            elif rest_money >= Money.TEN.value:
                money_return.append(Money.TEN.name)
                rest_money -= Money.TEN.value

            elif rest_money >= Money.FIVE.value:
                money_return.append(Money.FIVE.name)
                rest_money -= Money.FIVE.value

        return money_return

    def start_vending(self):

        money_into = self.money_into()

        if self.product not in self.products_price.keys():
            return f"El producto {self.product} no se encuentra en la lista"

        elif money_into < self.products_price[self.product]:
            return f"El dinero introducido es insuficiente. Le faltan {self.products_price[self.product] - money_into} céntimos"

        else:

            return self.product, self.money_return()


vending = Vending(
    [Money.TEN, Money.FIVE, Money.ONEHUNDRED, Money.FIFTY], "Cerveza")
print(vending.start_vending())

vending = Vending(
    [Money.TEN, Money.FIVE, Money.ONEHUNDRED, Money.FIFTY, Money.TEN, Money.TEN, Money.FIFTY], "Donut")
print(vending.start_vending())

vending = Vending(
    [Money.TEN, Money.FIVE, Money.ONEHUNDRED, Money.FIFTY], "Birra")
print(vending.start_vending())

vending = Vending(
    [Money.TEN, Money.FIVE, Money.FIFTY], "Cerveza")
print(vending.start_vending())