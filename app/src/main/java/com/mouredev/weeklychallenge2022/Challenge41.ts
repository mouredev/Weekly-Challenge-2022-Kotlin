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
/**
 * Funcion que calcula la ley de Ohm , en funcion de los parametros que se le pasen.
 * I = V / R
 * V = I * R
 * R = V / I
 * @param V Valor del voltaje
 * @param R Valor de la Resistencia
 * @param I Valor de la Intensidad
 * @returns Devuelve el valor calculado en funcion de los parametros dados
 */
export function calculateOhm(V?:number, R?:number, I?:number) : number | string {

    if (V && R) {
        return Math.round((V / R) * 100) / 100;
    } else if (V && I) {
        return Math.round((V * I) * 100) / 100;
    } else if (R && I) {
        return Math.round((R * I) * 100) / 100;
    } else {
        return "Params error or insufficient";
    }

}

console.log(calculateOhm(1,10));
console.log(calculateOhm(NaN,12, 10));
console.log(calculateOhm(1.4, NaN,5.2));
console.log(calculateOhm(1,NaN));




