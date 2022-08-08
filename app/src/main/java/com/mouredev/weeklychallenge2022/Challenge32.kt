package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

Console.WriteLine(GetSecondMaxNumber(new List<int> {}));// salta excepcion
Console.WriteLine(GetSecondMaxNumber(new List<int> {1,2})); // imprime 1
Console.WriteLine(GetSecondMaxNumber(new List<int> {5,3,6,9,7,4,8,4,7,4,1,2,12,3,2,14})); // imprime 12

public static int GetSecondMaxNumber(List<int> numbers){
		
		if (numbers.Count == 0){
			throw new Exception("La lista esta vacia");
		}
		
		if(numbers.Count <= 1){
			return numbers[0];
		}
		
		numbers.Sort();
		return numbers[numbers.Count - 2];
	}
