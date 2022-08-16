/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

const fnAnagrama = (str, str2) => {
  if (str === str2) return false
  const arrStr = str.split('').sort().join('')
  const arrStr2 = str2.split('').sort().join('')
  if (arrStr.length !== arrStr2.length) return false
  if (arrStr == arrStr2) return true
  else false

}

fnAnagrama('bacalao', 'acabalo')