package com.mouredev.weeklychallenge2022

import androidx.annotation.VisibleForTesting
import java.math.BigDecimal
import java.math.RoundingMode

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
    println(calculateOhm(voltage = 10.65, current = 5.43))
    println(calculateOhm(current = 7.0, voltage = 24.0))
    println(calculateOhm(resistance = 6.0, voltage = 12.0))
    println(calculateOhm(resistance = 4.9))
    println(calculateOhm())
}

internal fun calculateOhm(
    voltage: Double? = null, resistance: Double? = null, current: Double? = null
): String {
    // Validate if exist correct quantity of params to do calculates
    val params = listOfNotNull(voltage, resistance, current)
    if (params.size == 2) {
        return when(getCalculateType(voltage, current, resistance)) {
            CalculateType.VOLTAGE -> {
                calculateVoltage(current = current, resistance = resistance)
            }
            CalculateType.RESISTANCE -> {
                calculateResistance(voltage = voltage, current = current)
            }
            CalculateType.CURRENT -> {
                calculateCurrent(voltage = voltage, resistance = resistance)
            }
        }
    }

    return "Invalid values"
}

private fun getCalculateType(
    voltage: Double?,
    current: Double?,
    resistance: Double?
): CalculateType {
    return when {
        current != null && resistance != null -> CalculateType.VOLTAGE
        voltage != null && current != null -> CalculateType.RESISTANCE
        resistance != null && voltage != null -> CalculateType.CURRENT
        else -> throw Exception("Unknown type")
    }
}

private fun calculateVoltage(current: Double?, resistance: Double?): String {
    return if (current != null && resistance != null) {
        BigDecimal(current * resistance)
            .setScale(2, RoundingMode.FLOOR).toString()
    } else {
        ""
    }
}

private fun calculateResistance(voltage: Double?, current: Double?): String {
    return if (voltage != null && current != null) {
        BigDecimal(voltage / current)
            .setScale(2, RoundingMode.FLOOR).toString()
    } else {
        ""
    }
}

private fun calculateCurrent(voltage: Double?, resistance: Double?): String {
    return if (voltage != null && resistance != null) {
        BigDecimal(voltage / resistance)
            .setScale(2, RoundingMode.FLOOR).toString()
    } else {
        ""
    }
}

enum class CalculateType {
    VOLTAGE, CURRENT, RESISTANCE
}