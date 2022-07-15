package com.mouredev.weeklychallenge2022

import java.lang.Exception
import java.util.*

/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de coins) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de coins).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las coins.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con coins de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las coins enviadas estén dentro de las soportadas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */



fun main() {

    val coinsD1 = intArrayOf(10, 5, 5,200,200,100,5,5,5,5,50,10)
    val coinsD2 = intArrayOf(10,5,5,5,5)
    val coinsA1 = intArrayOf(100)
    val coinsA2 = intArrayOf(200)
    val coinsB1 = intArrayOf(50,10,5)
    val coinsB2 = intArrayOf(50,10,5)
    val coinsB1test2 = intArrayOf(10,10,5,5)
    val invalidCoins = intArrayOf(15,35,25)

    println(expendingMachine(coinsD2, "D2"))
    println(expendingMachine(coinsD1, "D1"))
    println(expendingMachine(coinsA1, "A1"))
    println(expendingMachine(coinsA2, "A2"))
    println(expendingMachine(coinsB1, "B1"))
    println(expendingMachine(coinsB2, "B2"))
    println(expendingMachine(coinsD2, "D3"))
    println(expendingMachine(coinsB1test2, "B1"))
    println(expendingMachine(invalidCoins, "B1"))
    
}

enum class Product(val price: Int, val numero: String) {

    BUBULUBU(10, "D1"),
    PANDITAS(15, "D2"),
    NETFLIX_CARD(150, "A1"),
    SABRITAS(25, "A2"),
    COCACOLA(20, "B1"),
    PAQUETAXO(55, "B2");

    companion object {
        fun getByNumero(numero: String): Product? {
            return values().find { it.numero == numero }
        }
    }
}

fun expendingMachine(coins: IntArray, numero: String): Pair<String, String> {

    if (!validateCoins(coins)) {
        println("Not valid coins")
        return Pair(numero, coins.contentToString())
    }

    val product: Product? = Product.getByNumero(numero)
    val pay = coins.sum()
    var resultado = Pair(numero, coins.contentToString())
    if (null == product || pay < product?.price) {
        println("No se encontro el producto o falta dinero para el pago")
    } else if (pay == product.price) {
        resultado = Pair(product.name, IntArray(0).contentToString())
    } else {
        resultado = Pair(product.name, getChange(pay,product.price).contentToString())
    }
    return resultado
}

fun getChange(pay: Int, price: Int): IntArray {
    var change = (pay - price) / 5
    val arrayList = mutableListOf<Int>()

    while (change > 0) {

        when {
            change >= 40 -> {
                arrayList.add(200)
                change -= 40
            }
            change >= 20 -> {

                arrayList.add(100)
                change -= 20
            }
            change >= 10 -> {
                arrayList.add(50)
                change -= 10
            }
            change >= 2 -> {
                arrayList.add(10)
                change -= 2
            }
            else -> {
                arrayList.add(5)
                change -= 1
            }
        }
    }
    return arrayList.toIntArray()
}
    fun validateCoins(coins: IntArray): Boolean {
        val validCoins = arrayListOf(5, 10, 50, 100, 200)
        for (i in coins) {
            if (!validCoins.contains(i)) {
                return false
            }
        }
        return true
    }

