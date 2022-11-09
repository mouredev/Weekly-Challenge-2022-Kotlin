package com.mouredev.weeklychallenge2022

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

public class Reto45 {
	
	//private final static int[] CONTAINER = { 1, 4, 3, 4, 5, 4, 3, 2, 1 };
	private final static int[] CONTAINER = { 4, 0, 3, 6, 1, 3 };

	public static void main(String[] args) {
		new WaterCalculator();

	}

	private static class WaterCalculator {
		private static int water;

		private WaterCalculator() {
			water = 0;
			calculator();
			printResult();

		}

		private void calculator() {
			int topRight;
			int topLeft;
			int top;
			
			// este for global recorrerá el array de izquierda a derecha
			for (int index = 1; index < CONTAINER.length - 1; index++) {
				topRight = 0;
				topLeft = 0;
				top = 0;

				// este for búscará el punto más alto a la izquierda de la posición actual
				for (int i = 0; i < index; i++) {
					if (CONTAINER[i] > topLeft) {
						topLeft = CONTAINER[i];
					}
				}
				
				// este for buscará el punto más alto a la derecha de la posición actual
				for (int i = CONTAINER.length - 1; i > index; i--) {
					if (CONTAINER[i] > topRight) {
						topRight = CONTAINER[i];
					}
				}

				// si el top por la izquierda y el top por la derecha son más altos que el punto
				// actual identificamos el top más bajo (izquierda o derecha) y sumamos al total
				// el agua que falta en esta posición
				if (CONTAINER[index] < topLeft && CONTAINER[index] < topRight) {
					top = (topLeft < topRight ? topLeft - CONTAINER[index] : topRight - CONTAINER[index]);
					water += top;
					System.out.println("POSICIÓN: " + index + "\tALTURA = " + CONTAINER[index] + "\ttopIZD = " + topLeft
							+ "\ttopDER = " + topRight + "\tSUMAMOS = " + top + "\tAGUA TOTAL= " + water);
				}
			}
		}

		private void printResult() {
			System.out.println("\nTOTAL AGUA: " + water);
		}
	}
}