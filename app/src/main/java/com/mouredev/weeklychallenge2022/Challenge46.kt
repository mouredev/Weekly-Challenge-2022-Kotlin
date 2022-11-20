package com.mouredev.weeklychallenge2022

/*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

public class Reto46 {

	static int[][] Recorrido = { 
			{ 3, 5, 7, -1 }, 
			{ 1 }, 
			{ 1 }, 
			{ 2 }, 
			{ -2, 7, 8 }
	};

	static int numSecuencia = 0;
	static boolean positive = false;

	static int[] coordenadas = { 0, 0 };

	public static void main(String[] args) {
		avance(Recorrido[numSecuencia]);

	}

	static void avance(int[] secuencia) {
		int index;
		if (numSecuencia % 2 != 0) {
			index = 0;
		} else {
			index = 1;
			positive = !positive;
		}

		int total = 0;

		for (int i = 0; i < secuencia.length; i++) {
			total += secuencia[i];
		}
		coordenadas[index] += total * (positive ? 1 : -1);
		numSecuencia++;
		System.out.println(coordenadas[0] + " " + coordenadas[1]);
		if (numSecuencia == Recorrido.length) {

		} else {
			avance(Recorrido[numSecuencia]);
		}
	}
}