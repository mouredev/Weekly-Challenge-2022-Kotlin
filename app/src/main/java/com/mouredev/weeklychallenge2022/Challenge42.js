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

function main(){
    let v1 = "20°C", v2 = "100°F", v3 = "80";

    convertir(v1);
    convertir(v2);
    convertir(v3);
}

function convertir(str){
    let num = parseInt(str.substring(0,str.length -2));
    let letra = str.charAt(str.length -1);

    if (letra == 'C'){ let f = (num * 9 / 5) + 32; return f; }
    if (letra == 'F'){ let c = (num - 32 ) * 5 / 9; return c; }
    if (letra !== 'C' || letra !== 'F') return false;
}