/*
 * Reto #20
 * PARANDO EL TIEMPO
 * Fecha publicación enunciado: 16/05/22
 * Fecha publicación resolución: 23/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sume 2 números y retorne su resultado pasados unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 */

// NOTA: Me tomé la libertad creativa de permitir N operandos :)

/**
 * Performs an addition of two numbers and returns the result after a given number of seconds.
 * @param  {...any} parameters First param is the number of seconds to wait, other params are the numbers to add
 * @returns {Promise<number> | Promise<null>} Promise wrapping the addition of all the operands if parameters contains at least the timeout and one operand, otherwise null
 */
const asyncAddition = (...parameters) => new Promise(resolve => setTimeout(() => resolve(parameters.slice(1).reduce((acc, n) => acc + n, null)), parameters[0] * 1000));

module.exports = asyncAddition;
