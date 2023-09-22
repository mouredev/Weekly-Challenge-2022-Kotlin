/**
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit
 * y viceversa.
 *
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" 
 *   y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: 
 *   https://retosdeprogramacion.com/mensuales2022
 * 
 * @author Javier Epifanio López
 */

function changeGrades(grade){
    // Si no tiene el símbolo "°" o no tiene "C" o "F" retornamos un error
    if (!grade.includes("º") || (!grade.includes("C") && !grade.includes("F"))) {
        return "Error";
    }

    // Si tiene "C" convertimos a Fahrenheit
    if (grade.includes("C")) {
        return `${(parseInt(grade) * 1.8) + 32}°F`;
    }

    // Si tiene "F" convertimos a Celsius
    if (grade.includes("F")) {
        return `${(parseInt(grade) - 32) / 1.8}°C`;
    }
}

console.log(changeGrades("32 C")); // Error
console.log(changeGrades("32ºC")); // 89.6°F
console.log(changeGrades("89.6ºF")); // 32°C
