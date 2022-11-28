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


/**
 * Función que recibe un texto y retorna la vocal que más veces se repite y ademas la imprime en consola
 * Si no hay vocales devolverá una cadena vacia
 * @param text Texto a analizar
 * @returns Vocal que más veces se repite
 * @param text
 */
export function mostCommonVowel(text: string): string {

    const REGEX_VOWELS = new RegExp("[aeiou]", "g");
    const vowelsCount = new Map<string, number>();
    const normalizedText = normalizeText(text.toLowerCase());
    let vowels = normalizedText.match(REGEX_VOWELS);


    vowels?.forEach((vowel) => {
        vowelsCount.set(vowel, (vowelsCount.get(vowel) || 0) + 1);
    })


    if(vowelsCount.size > 0) {
        const vowelsMaxValue = [...vowelsCount.entries()].reduce((first, second) => second[1] > first[1] ? second : first)
        console.log(`La vocal más comun es ${vowelsMaxValue[0]} con ${vowelsMaxValue[1]} repeticiones`);
        return vowelsMaxValue[0]
    }
    else {
        console.log("No hay vocales en el texto");
        return "";
    }


}

/**
 * Función que normaliza el texto quitando los acentos y caracteres especiales
 * @param str Texto a normalizar
 * @returns Texto normalizado
 */
function normalizeText(str:string) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}


console.log(mostCommonVowel("El ingenioso hidalgo Don Quijote de la Mancha\" En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor"))
console.log(mostCommonVowel("¿Son robos o sobornos?"))
console.log(mostCommonVowel("sqrt"))
console.log(mostCommonVowel(""))