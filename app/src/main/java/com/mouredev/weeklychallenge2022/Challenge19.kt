package com.mouredev.weeklychallenge2022

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun main() {
	val tm = calculateMilliseconds(3, 10, 14, 22)
	println("Milisegundos totales $tm")
}

fun calculateMilliseconds(days: Int?, hours: Int?, minutes: Int?, seconds: Int?): Int {
	var millisecondsTotal = 0

	if (days != null) {
		millisecondsTotal = daysToMilliseconds(days)
	}
	if (hours != null) {
		millisecondsTotal += hoursToMilliseconds(hours)
	}
	if (minutes != null) {
		millisecondsTotal += minutesToMilliseconds(minutes)
	}
	if (seconds != null) {
		millisecondsTotal += secondsToMilliseconds(seconds)
	}
	return millisecondsTotal
}

fun daysToMilliseconds(days: Int): Int {
	return hoursToMilliseconds(days * 24)
}

fun hoursToMilliseconds(hours: Int): Int {
	return minutesToMilliseconds(hours * 60)
}

fun minutesToMilliseconds(minutes: Int): Int {
	return secondsToMilliseconds(minutes * 60)
}

fun secondsToMilliseconds(seconds: Int): Int {
	return seconds * 1000
}