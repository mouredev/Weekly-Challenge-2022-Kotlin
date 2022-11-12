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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RetoSemanal45 {
private static List<Integer> bloques = Arrays.asList(4, 0, 3, 6, 1, 3);
	private static int valorTotalAgua = 0; 
	
	public static void main(String[] args) {

		// Definición del array del agua.
		List<Integer> agua = new ArrayList<>(6);
		
		// Ordenación de mayor a menor una copia del Array de bloques.
		List<Integer> bloquesOrdenado = new ArrayList<>(bloques);	
		Comparator<Integer> comparador = Collections.reverseOrder();
		Collections.sort(bloquesOrdenado, comparador);

		// Vamos recorriendo por bloques.
		for (int i = 0; i < bloques.size(); i++) {
      
			// La primera y la última siempre tendrán valor de 0.
			if (i == 0 || i == bloques.size() - 1) {
				agua.add(0);
			} else {
				int bloqueAnterior = bloques.get(i - 1);
				int aguaAnterior = agua.get(i - 1);
				int bloqueActual = bloques.get(i);
        
				// Eliminamos bloques anteriores para saber si hay mayores.
				bloquesOrdenado.remove(Integer.valueOf(bloqueAnterior));
        
				// Suma de bloque más agua. 
				bloqueAnterior += aguaAnterior;
        
				// Comprobamos el bloque anterior con el mayor que exista
				int valorAgua = bloqueAnterior > bloquesOrdenado.get(0) ? bloquesOrdenado.get(0) : bloqueAnterior;
        
				// Comprobamos con los bloques el valor que toca de agua. 
				valorAgua = bloqueActual >= valorAgua ? 0 : valorAgua - bloqueActual;

				agua.add(valorAgua);
				valorTotalAgua += valorAgua; 
			}
		}
		// Impresión de resultados.
		System.out.println("El Array de Bloques es el siguiente: " + bloques);
		System.out.println("El Array de Agua es el siguiente: " + agua);
		System.out.println("Valor Total de gotas de agua: " + valorTotalAgua);
	}
}
