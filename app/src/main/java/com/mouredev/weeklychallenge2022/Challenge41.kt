/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


fun main() {

    // Test 1
    println(ohm(0.0, 330.0, 0.04)) // 13,20 V
    println(ohm(25.0, 0.00, 1e-2)) // 2500 Ω
    println(ohm(5.0, 22.0, 00.0)) // 0.23 A
    println(ohm(0.0, 1e3, 3.3e-3)) // 3.3 V


    // Test 2
    println(ohm(0.04, 330.0, 0.04)) // Invalid values
    println(ohm(0.00, 0.0, 0.04)) // Invalid values
    println(ohm(0.04, 0.0, 0.0)) // Invalid values
    println(ohm(0.00, 0.0, 0.0)) // Invalid values
    println(ohm(0.00, 330.0, 0.0)) // Invalid values
    // Test 3
    println(ohm(0.0, 0.0, 0.0)) // Invalid values


}

/**
 * Función que calcula el valor del parámetro perdido correspondiente a la ley de Ohm.
 * @param v Voltaje
 * @param r Resistencia
 * @param i Intensidad
 * @return Valor del parámetro perdido
 */
fun ohm(voltaje: Double, resistencia: Double, intensidad: Double ): String {
    var resultado = "Invalid values"

    if (voltaje == 0.0 && resistencia != 0.0 && intensidad != 0.0) {
        resultado = String.format("%.2f V", resistencia * intensidad)
    } else if (voltaje != 0.0 && resistencia == 0.0 && intensidad != 0.0) {
        resultado = String.format("%.2f Ω", voltaje / intensidad)
    } else if (voltaje != 0.0 && resistencia != 0.0 && intensidad == 0.0) {
        resultado = String.format("%.2f A", voltaje / resistencia)
    }


    return resultado


}