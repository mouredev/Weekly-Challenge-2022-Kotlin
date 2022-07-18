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
    val mis_monedas= arrayOf(Monedas.CIEN,Monedas.DOSCIENTOS)
    val mi_producto:Productos=Productos.BEBIDA;

    val mi_pedido:Pedido = (Pedido(mi_producto, mis_monedas))
    mi_pedido.calcular_vuelta()

}


private enum class Monedas(val valor: Int) {
    CINCO(5),
    DIEZ(10),
    CINCUENTA(50),
    CIEN(100),
    DOSCIENTOS(200)
}

private enum class Productos(val id: Int, val precio: Int) {
    BEBIDA(1, 300),
    GASEOSA(2, 100),
    JUGO(3, 500),
    REFRESCO(4, 5)
}

private class Pedido(val producto: Productos, val monedas: Array<Monedas>){
    fun calcular_vuelta(): Array<Int>{
        val vuelta = ArrayList<Int>()
        val precio = producto.precio
        var dinero = 0
        for (moneda in monedas) {
            dinero += moneda.valor
        }
        if (dinero < precio) {
            println("Monedas insuficientes")
            return vuelta.toTypedArray()
        }
        while (dinero >= precio) {
            for (moneda in monedas) {
                if (dinero >= moneda.valor) {
                    vuelta.add(moneda.valor)
                    dinero -= moneda.valor
                    break
                }
            }
        }
        println("Producto: $producto, Vuelta: $vuelta")
        return vuelta.toTypedArray()
    }
}