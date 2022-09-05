package com.mouredev.weeklychallenge2022

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

function isAnagram(string1, string2) {
	if (string1 === string2) {
		return false;
	}

	const arrayString1 = Array.from(string1.toLowerCase()).sort();
	const arrayString2 = Array.from(string2.toLowerCase()).sort();

	let coincidencias = 0;

	for (let i = 0; i < arrayString1.length; i++) {
		for (let x = 0; x < arrayString2.length; x++) {
			if (arrayString1[i] === arrayString2[x]) {
				coincidencias++;
			}
		}
	}

	return coincidencias === arrayString1.length ? true : false;
}

const string1 = 'amor';
const string2 = 'roma';

console.log(isAnagram(string1, string2));
