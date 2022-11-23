/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function mostCommonVowel(text) {
    text = text.toLowerCase();

    //Using regex and split() we obtain the number of vowels
    let vowels = {
        a: [...text.matchAll(/a|á|ä/g)].length,
        e: [...text.matchAll(/e|é|ë/g)].length,
        i: [...text.matchAll(/i|í|ï/g)].length,
        o: [...text.matchAll(/o|ó|ö/g)].length,
        u: [...text.matchAll(/u|ú|ü/g)].length,
    };

    let maxNumber = Math.max(vowels.a, vowels.e, vowels.i, vowels.o, vowels.u);
    if (maxNumber === 0) return [];
    return Object.keys(vowels).filter((key) => vowels[key] === maxNumber); //returns all keys with value maxNumber, to return only one use find()
}

let txt0 =
    "Uses a regular expression or a fixed string to break a string into an array of substrings.";
let txt1 = "aeeeeiiioöÖOOou";
let txt2 = "sdfghlp";
let txt3 = "aaeeiÏiouüú";
let txt4 = "ááééíóú";
let txt5 = "Velit excepteur deserunt ex ea reprehenderit ullamco";
let txt6 = "";

console.log(mostCommonVowel(txt0));
console.log(mostCommonVowel(txt1));
console.log(mostCommonVowel(txt2));
console.log(mostCommonVowel(txt3));
console.log(mostCommonVowel(txt4));
console.log(mostCommonVowel(txt5));
console.log(mostCommonVowel(txt6));
