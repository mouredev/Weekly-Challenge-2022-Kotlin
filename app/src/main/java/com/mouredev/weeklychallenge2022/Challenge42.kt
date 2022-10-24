package com.mouredev.weeklychallenge2022

/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Funcion principal
 */
fun main(){

    println(temperatureConverter("12°C"))
    println(temperatureConverter("-4.2°F"))

}

/**
 * Enumerado con las unidades de temperatura
 */
enum class TemperatureUnit(val symbol: String) {
    CELSIUS("°C"),
    FAHRENHEIT("°F")
}
/**
 * Funcion que convierte la temperatura de una unidad de grados Centigrados a Fahrenheit
 * @param temperature Expresion que contiene la temperatura a convertir con su unidad
 * @returns Temperatura convertida a Fahrenheit o a Centigrados
 */
fun temperatureConverter(temperature: String) : String {

    val regExpTemperature = Regex("^(-?\\d+(.\\d+)?)(°)([CF])")
    val regExpNumber = Regex("^(-?\\d+(.\\d+)?)")
    val regExpUnit = Regex("(°[CF])")

    if (regExpTemperature.matches(temperature)) {

        val number = regExpNumber.find(temperature)?.value?.toDouble()

        return when (regExpUnit.find(temperature)?.value) {
            TemperatureUnit.CELSIUS.symbol -> "${number!! * 1.8 + 32}${TemperatureUnit.FAHRENHEIT.symbol}"
            TemperatureUnit.FAHRENHEIT.symbol -> "${(number!! - 32) / 1.8}${TemperatureUnit.CELSIUS.symbol}"
            else -> "The unit is not valid"
        }

    }
    return "The temperature $temperature is not valid"

}
