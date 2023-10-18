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


// OhmsLaw(V, R, I)
// OhmsLaw must be 3 parameters: V, R, I
// The value you want to find must be zero
//   - For example: if you want to find V, the values must be => V=0, R=value, I=value
// The minimum and maximum number of zeros is 1 (If two or more values are zero, returns a error)
// Values must be numbers only (integers, floats, others. No string, objects, booleans) 

function OhmsLaw(V, R, I) {
    if ((V !== 0 && R !== 0 && I !== 0) ||
        (typeof V !== 'number') ||
        (typeof R !== 'number') ||
        (typeof I !== 'number')
    ) {
        return "Invalid values"
    } else if (V === 0) {
        if (R === 0 || I === 0) { return "Invalid values"}
        return (R * I).toFixed(2)
    } else if (R === 0) {
        if (V === 0 || I === 0) { return "Invalid values" }
        return (V / I).toFixed(2)
    } else if (I === 0) {
        if (R === 0 || V === 0) { return "Invalid values" }
        return (V / R).toFixed(2)
    }
}

// Outputs
console.log(OhmsLaw(2, 4 ,0));           // I = 0.50
console.log(OhmsLaw(2.35, 0, 8));        // R = 0.29
console.log(OhmsLaw(0, 4, 100.45));      // V = 401.80
console.log(OhmsLaw(124.5, 4, 100.45));  // Invalid values => Error: All values are different from zero 
console.log(OhmsLaw(0, 0, 0));           // Invalid values => Error: All values are 0
console.log(OhmsLaw(0, 1, 0));           // Invalid values => Error: Two of the values are zero
console.log(OhmsLaw(0, 0, 1));           // Invalid values => Error: Two of the values are zero
console.log(OhmsLaw(1, 0, 0));           // Invalid values => Error: Two of the values are zero
console.log(OhmsLaw("1", 4, 8));         // Invalid values => Error: One of the values isn't a number
console.log(OhmsLaw(1, "1124.2", 0));    // Invalid values => Error: One of the values isn't a number
console.log(OhmsLaw(13, 145, "100"));    // Invalid values => Error: One of the values isn't a number
 
