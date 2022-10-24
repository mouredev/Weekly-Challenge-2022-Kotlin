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

// usando javascript(regex expressions)

const temperatureConverter = (temperature) => {
    const checker = temperature.match(/(-?\d+\.?\d*)°(C|F)/)
    let result = 0;
    if (checker) {
        const value = parseFloat(checker[1])
        const unit = checker[2]

        if (unit === 'C') {
            result =`${value * 1.8 + 32}°F` 
        } else {
            result = `${(value - 32) / 1.8}°C`
        }
    }else {
        return console.log('Error')
    }
    return result
}


temperatureConverter('95°c') // 32°F