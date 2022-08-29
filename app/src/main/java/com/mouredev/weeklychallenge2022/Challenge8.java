package com.mouredev.weeklychallenge2022;

public class Challenge8 {

	public static void main(String[] args) {
		/*
		 * Reto #8
		 * DECIMAL A BINARIO
		 * Fecha publicación enunciado: 18/02/22
		 * Fecha publicación resolución: 02/03/22
		 * Dificultad: FÁCIL
		 *
		 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
		 *
		 * Información adicional:
		 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
		 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
		 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
		 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
		 *
		 */


		decimalToBinary(387);//110000011
		System.out.println();
		decimalToBinary(0);
	}
	
	
	public static void decimalToBinary(int decimal) {
		
		if (decimal == 0) {
			System.out.println(0);
		} else {
			int number  = decimal;
			int[] binary = new int[100];
			int i = 0;
			
			while (number > 0) {
				int reminder = number % 2;
				number /= 2;
				binary[i++] = reminder;
				
			}
			for (int j = i-1; j >= 0; j--) {
				System.out.print(binary[j]);
			}
		}		
	}
}
