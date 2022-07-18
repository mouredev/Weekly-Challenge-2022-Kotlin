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

/**
 * Data class que representa una maquina expendedora.
 * @property products Lista de productos que puede ofrecer la maquina.
 * @see Product
 */
data class ExpendMachine(
    val products: List<Product>
)

/**
 * Data class que representa un producto de la maquina expendedora.
 * @property productCode Código del producto.
 * @property name Nombre del producto.
 * @property price Precio del producto.
 */
data class Product(val productCode:Int,val name: String, val price: Int)

/**
 * Data class que representa una monedero para usar en la maquina expendedora.
 * @property coins Monedas que contiene el monedero.
 * @see Coins
 */

data class Monedero(val coins: Array<Coins>) {
    fun sum(): Int {
        return coins.map { it.value }.sum()
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Monedero

        if (!coins.contentEquals(other.coins)) return false

        return true
    }

    override fun hashCode(): Int {
        return coins.contentHashCode()
    }
}


/**
 * Enum que representa las monedas que se pueden utilizar
 * @property value Valor de la moneda.
 */
enum class Coins(val value: Int) {
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200)
}

/**
 * Variable que mapea los distintos tipos de errores que puede producirse en la maquina expendedora.
 */
val error = mapOf(
    404 to "Producto no encontrado",
    402 to "Dinero insuficiente",
    403 to "Moneda no soportada"
)


/**
 * Variable inicializada con la maquina expendedora y una serie de productos
 */
val machine = ExpendMachine(
    listOf(
        Product(1, "Coca-Cola", 600),
        Product(2, "Fanta", 190),
        Product(3, "Sprite", 90),
        Product(4, "Pepsi", 90),
        Product(5, "7Up", 90),
        Product(6, "Cerveza", 50),
        Product(7, "Agua", 50),
        Product(8, "Kit-Kat", 75),
        Product(9, "Kinder Bueno", 100),
        Product(10, "Sandwich", 75)
    )
)

/**
 * Variable que contiene un monedero con varias monedas
 */
val bucket = Monedero(
    arrayOf(
        Coins.TWO_HUNDRED,
        Coins.FIVE,
        Coins.FIVE,
        Coins.FIFTY,
        Coins.FIVE,
        Coins.HUNDRED,
        Coins.HUNDRED
    )
)


/**
 * Funcion Principal
 */
fun main() {

    buyProduct(bucket, 2, machine)
    buyProduct(bucket, 3, machine)
}


/**
 * Funcion que calcula el dinero de vuelta de una moneda con el menor numero posible de monedas
 * @param price Precio del producto
 * @param money Dinero que se tiene en el monedero
 * @return Lista de monedas que se deben devolver
 */

private fun getRefund(price: Int,money:Int):List<Coins>{

    val coins = mutableListOf<Coins>()
    var change = money - price
    var rest = change
    Coins.values().toList().sortedDescending().forEach {

        change  = rest/ it.value
        rest %= it.value
        if(change>0){
            for(i in 1..change){
                coins.add(it)
            }
        }

    }

    return coins




}


/**
 * Funcion que comprra un producto de la maquina expendedora
 * @param bucket Monedero con las monedas que se tiene en el momento
 * @param productCode Codigo del producto que se quiere comprar
 * @param expendMachine Maquina expendedora con los productos que puede ofrecer
 *
 */

private fun buyProduct(bucket: Monedero, productCode: Int,expendMachine: ExpendMachine) {


    val product = expendMachine.products.firstOrNull { it.productCode == productCode }

    if(product == null){
        println(error[404])
    }

    product?.let {
        if(bucket.sum()< product.price)
            println(error[402])
        else {
            val refund = getRefund(product.price, bucket.sum())
            if(refund.isEmpty())
                println("No hay vuelta")
            else
                println("TICKET CONTADO")
            println("--------------------------------------------------------------------------------")
            println("Dinero introducido : " + bucket.sum() + "€ , producto: " + product.name + ", valor : ${product.price}")
            println("Monedas devueltas: " + refund.map { it.value }.joinToString(", "))
            println("Total devuelto :" + refund.map { it.value }.sum() + "€")
            println("Gracias por usar nuestra máquina expendedora")
            println("--------------------------------------------------------------------------------")

        }
    }



}
