/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function mostUsedVowel(text){
    let vowelCount = {}
    text.toLowerCase().normalize('NFD').split("").forEach(char => {
        if("aeiou".includes(char)){
            (char in vowelCount)? vowelCount[`${char}`]++ : vowelCount[`${char}`] = 1;
        }
    })
    let mostRepeated = [];
    let maxRepeated = 0;
    for(vowel in vowelCount){
        let count = vowelCount[vowel];
        if(count >= maxRepeated){
            if(count > maxRepeated) mostRepeated = [];
            mostRepeated.push(vowel);
            maxRepeated = count;
        }
    }
    return (mostRepeated.length !== 0)? mostRepeated : "There are no vowels";
}

console.log(mostUsedVowel("Hello")); // ['e', 'o']
console.log(mostUsedVowel("ghdjf")); // "There are no vowels"
console.log(mostUsedVowel("Hello World")); // ['o']
console.log(mostUsedVowel("This is a good day")); // ['i',  'a', 'o']
console.log(mostUsedVowel("Hola, ¿qué tal estás hoy?")); // ['a']