/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function karaca(input) {
  let newInput = replaceAccentedVowels(input.input);
  if (input.func == "encryption") return encryption(newInput.split(" "));
  return decryption(newInput.split(" "));
};

const encryption = (input) =>
  input
    .map(
      (word) =>
        replaceVowels(word).toLowerCase().split("").reverse().join("") + "aca"
    )
    .join(" ");

const decryption = (input) => {
  if (!input.every((word) => word.match(/(aca)$/g)))
    return "not encrypted input";
  return input
    .map((word) =>
      replaceEncryptedVowels(word.slice(0, -3)).split("").reverse().join("")
    )
    .join(" ");
};

const replaceVowels = (input) => {
  const vowelReplacements = { a: "0", e: "1", i: "2", o: "3", u: "4" };
  for (let vowel in vowelReplacements) {
    input = input.replaceAll(vowel, vowelReplacements[vowel]);
  }
  return input;
};

const replaceEncryptedVowels = (input) => {
  const encryptedVowelsReplacements = {
    0: "a",
    1: "e",
    2: "i",
    3: "o",
    4: "u",
  };

  for (let vowel in encryptedVowelsReplacements) {
    input = input.replaceAll(vowel, encryptedVowelsReplacements[vowel]);
  }
  return input;
};

const replaceAccentedVowels = (input) => {
  const accentedVowels = { á: "a", é: "e", í: "i", ó: "o", ú: "u", ü: "u" };

  for (let vowel in accentedVowels) {
    input = input.replaceAll(vowel, accentedVowels[vowel]);
  }
  return input;
};
