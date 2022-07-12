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
    val primeraCompra = Compra(4, arrayOf(5, 10, 50, 200))
    primeraCompra.verCompra()

    val segundaCompra = Compra(1, arrayOf(5, 10, 50, 200))
    segundaCompra.verCompra()

    val terceraCompra = Compra(7, arrayOf(5, 10, 5, 100))
    terceraCompra.verCompra()
}

class Compra(numeroDeProducto: Int, private val monedas: Array<Int>) {

    private val nombreDelProducto: String? = Productos.lista[numeroDeProducto]

    private val precioDelProducto: Int? = Productos.precio[numeroDeProducto]

    private val monedasFinales = mutableListOf<Int>()

    private lateinit var estadoDeCompra: ESTADO_DE_COMPRA

    init {
        checkearTransaccion()
    }

    private fun checkearTransaccion() {
        if (nombreDelProducto.isNullOrBlank()) {
            estadoDeCompra = ESTADO_DE_COMPRA.NUMERO_INCORRECTO
            return
        } else if (!haySuficienteDinero()) {
            estadoDeCompra = ESTADO_DE_COMPRA.DINERO_INSUFICIENTE
            return
        }
        realizaTransaccion()
    }

    private fun realizaTransaccion() {
        monedasFinales.addAll(monedas)
        monedasFinales.sortDescending()

        var suma = 0
        for (moneda in monedasFinales) {
            suma += moneda
            if (suma >= precioDelProducto!!) {
                monedasFinales.remove(moneda)
                break
            }
        }
        estadoDeCompra = ESTADO_DE_COMPRA.HECHO
    }

    fun haySuficienteDinero(): Boolean =
        monedas.sum() >= (precioDelProducto ?: 5000)

    fun verCompra() {
        when (estadoDeCompra) {
            ESTADO_DE_COMPRA.HECHO ->
                println("Producto adquirido: $nombreDelProducto, Vuelto: $monedasFinales")
            ESTADO_DE_COMPRA.NUMERO_INCORRECTO ->
                println("Se ha ingresado un número incorrecto.")
            else ->
                println("No se ha ingresado el dinero suficiente.")
        }
    }
}

private enum class ESTADO_DE_COMPRA { DINERO_INSUFICIENTE, NUMERO_INCORRECTO, HECHO }

private object Productos {
    val lista = mapOf(
        1 to "Coca-Cola",
        2 to "Pepsi",
        3 to "Fanta",
        4 to "Sprite",
        5 to "Agua",
        6 to "Agua Gasificada"
    )

    val precio = mapOf(
        1 to 300,
        2 to 250,
        3 to 150,
        4 to 200,
        5 to 50,
        6 to 100
    )
}