package com.mouredev.weeklychallenge2022

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

const efectividadPokemones = {
	agua: {
		agua: 0.5,
		fuego: 0.5,
		planta: 2,
		electrico: 2,
	},
	fuego: {
		agua: 2,
		fuego: 0.5,
		planta: 0.5,
		electrico: 1,
	},
	planta: {
		agua: 0.5,
		fuego: 2,
		planta: 0.5,
		electrico: 0.5,
	},
	electrico: {
		agua: 1,
		fuego: 1,
		planta: 1,
		electrico: 0.5,
	},
};

const regExp = /[a-z]/i;

const atacante = 'fuego';
const defensor = 'elEctrico';
const ataque = 10;
const defensa = 5;

const tiposPokemon = ['agua', 'fuego', 'planta', 'electrico'];

function calcularDañoPokemon(atacante, defensor, ataque, defensa) {
	const pokemonAtacante = atacante.toLowerCase().trim();
	const pokemonDefensor = defensor.toLowerCase().trim();

	let mensajeError = '';

	// validar que las especies pokemón se encuentren disponibles
	let pokemonAtacanteValido = false;
	for (let i = 0; i < tiposPokemon.length; i++) {
		if (pokemonAtacante === tiposPokemon[i]) {
			pokemonAtacanteValido = true;
		}
	}

	let pokemonDefensorValido = false;
	for (let i = 0; i < tiposPokemon.length; i++) {
		if (pokemonDefensor === tiposPokemon[i]) {
			pokemonDefensorValido = true;
		}
	}

	// validar que los nombres de las especies pokemón estén correctamente escritos

	if (pokemonAtacanteValido === false || pokemonDefensorValido === false) {
		mensajeError =
			'ERROR: El nombre de cada tipo de pokemón, solo puede contener letras sin acentos o tildes';
	}

	// validar que tanto el ataque como la defensa sean un número

	if (typeof ataque !== typeof 0 || typeof defensa !== typeof 0) {
		mensajeError =
			'ERROR: Tanto el ataque como la defensa deben ser un número';
	}

	// validar que tanto el ataque como la defensa sean un número entre 1 y 100

	if (ataque < 1 || ataque > 100 || defensa < 1 || defensa > 100) {
		mensajeError =
			'ERROR: Tanto el ataque como la defensa deben ser un número entre 1 y 100';
	}

	// validar que el mensaje de error esté vacío
	if (!mensajeError) {
		const daño =
			50 *
			(ataque / defensa) *
			efectividadPokemones[`${pokemonAtacante}`][`${pokemonDefensor}`];

		return `El daño producido es de ${daño}`;
	} else {
		return mensajeError;
	}
}

console.log(calcularDañoPokemon(atacante, defensor, ataque, defensa));
