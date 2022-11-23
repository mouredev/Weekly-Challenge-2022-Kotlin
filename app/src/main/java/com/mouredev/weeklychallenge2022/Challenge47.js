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

module.exports.func = function mostRepeatedVowels(input) {
  return maxVowels(countVowels(normalizeInput(input)));
};

const normalizeInput = (input) => {
  const specialVowels = "áéíóúü";
  const vowels = "aeiouu";
  let newInput = input.toLowerCase();
  for (let index; index < specialVowels.length; index++) {
    newInput = newInput.replaceAll(specialVowels[index], vowels[index]);
  }
  return newInput;
};

const countVowels = (normalizedInput) => {
  let vowelNumbers = {};
  for (let index = 0; index < normalizedInput.length; index++) {
    if (!normalizedInput[index].match(/[aeiou]/g)) continue;

    if (!Object.keys(vowelNumbers).includes(normalizedInput[index])) {
      vowelNumbers[normalizedInput[index]] = 0;
    }
    vowelNumbers[normalizedInput[index]] += 1;
  }
  return vowelNumbers;
};

const maxVowels = (countedVowels) => {
  let maxValue = 0;
  let maxVowel = "";
  for (let key in countedVowels) {
    if (countedVowels[key] > maxValue) {
      maxValue = countedVowels[key];
      maxVowel = key;
    }
  }
  return maxVowel;
};
