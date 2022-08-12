/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Funcion que devuelve el 2º numero mas alto de un array de numeros
 * @param numbers Listado de números
 * @returns El 2º numero mas alto
 */
export function findSecondLargest(numbers: number[]): number {
    if(numbers.length == 0) return 0
    else{
        if(numbers.length == 1) return numbers[0];
         else{
            numbers = numbers.sort((a, b) => b - a);
            return numbers[1];
         }
    }

}

