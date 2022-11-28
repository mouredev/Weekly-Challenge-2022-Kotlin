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

interface IVowelList {
  [key: string]: number;
}
export default function mostRepeatedVowel(str: string) {
  const normalizedStr = str.toLowerCase().normalize().split('');

  let vowelList: IVowelList = {};
  normalizedStr.forEach((vowel) => {
    const isValid =
      vowel === 'a' || vowel === 'e' || vowel === 'i' || vowel === 'o' || vowel === 'u';
    if (isValid) {
      if (vowelList[vowel] === undefined) vowelList[vowel] = 1;

      vowelList[vowel]++;
    }
  });

  let maxRepeated = 0;
  let mostRepeated: string[] = [];
  Object.entries(vowelList).forEach((vowels) => {
    const [vowel, count] = vowels;

    if (count >= maxRepeated) {
      if (count > maxRepeated) {
        mostRepeated = [];
      }
      mostRepeated.push(vowel);

      maxRepeated = count;
    }
  });
  return mostRepeated;
}

console.log(mostRepeatedVowel('aaaaaeeeeiiioou'));
console.log(mostRepeatedVowel('AáaaaEeeeIiiOoU'));
console.log(mostRepeatedVowel('eeeeiiioouaaaaa'));
console.log(mostRepeatedVowel('.-Aá?aaaBbEeeweIiiOoU:'));
console.log(mostRepeatedVowel('.-Aá?aaa BbEeew eIiiOoU:'));
console.log(mostRepeatedVowel('.-Aá?aaa BbEeew eEIiiOoU:'));
console.log(mostRepeatedVowel('.-Aá?aaa BbEeew eEIiiOoUuuuuu:'));
console.log(mostRepeatedVowel('aeiou'));
console.log(mostRepeatedVowel('brp qyz'));
