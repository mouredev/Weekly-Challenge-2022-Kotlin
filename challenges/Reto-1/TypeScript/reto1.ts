/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
const removeAccent = (letter: string): string => {
  const changes: {[key: string]: string} = {
    á: 'a',
    é: 'e',
    í: 'i',
    ï: 'i',
    ó: 'o',
    ú: 'u',
    ü: 'u',
  };

  return changes[letter] || letter;
};

const transformWord = (word: string): string => {
  //   return Array.from(word.toLowerCase().replace(/ /g, ''), removeAccent)
  return Array.from(word.toLowerCase().replaceAll(' ', ''), removeAccent)
    .sort()
    .join('');
};

export const isAnagram = (firstWord: string, secondWord: string): boolean => {
  if (firstWord.toLowerCase() === secondWord.toLowerCase()) return false;

  const resultFirstWord = transformWord(firstWord);
  const resultSecondWord = transformWord(secondWord);

  return resultFirstWord === resultSecondWord;
};
