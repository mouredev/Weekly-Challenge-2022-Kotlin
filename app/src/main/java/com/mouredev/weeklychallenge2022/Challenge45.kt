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


Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 4, 0, 3, 6, 1, 3 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 4, 0, 3, 6, 1, 3, 4 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 4, 0, 4, 0, 0, 0, 0, 4 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 1, 0, 3 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 0, 0, 0, 4, 4, 0, 0, 0 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 0, 0, 0, 0, 0, 0 })} unidades de agua");
Console.WriteLine($"Quedarian atrapadas {ContenedorDeAgua(new int[] { 1, 0, 0, 0, 0, 0 })} unidades de agua");


static int ContenedorDeAgua(int[] container) {
	
	int largo = container.Length;
	if (largo == 0) return 0;       // Si no hay elementos, retorno 0

	int altura = container.Max();
	if (altura == 0) return 0;      // Si la altura es todo cero no hay bloques, retorno cero (no tiene donde quedar estancada el agua)

	int unidadesAgua = 0;
	for (int f = 0; f < altura; f++) {
		int indexBlock = -1;
		for (int c = 0; c < largo; c++) {
			if (container[c] > f) {                         // Encontre un bloque
				if (indexBlock == -1)                       // Si es el primero solo asigno indice donde se encuentra
					indexBlock = c;
				else {
					unidadesAgua += c - indexBlock - 1;     // Al encontrar el siguiente bloque asigno cantidad de agua entre ellos 
					indexBlock = c;                         // Muevo el indice al siguiente bloque
				}
			}
		}
	}

	return unidadesAgua;
	
}

/// <summary>
/// Cambiar container.Max() por MaxIntArray(container) en caso de la pagina de prueba online no reconozca ".Max()"
/// </summary>
/// <param name="container">Array de elementos</param>
/// <returns></returns>
static int MaxIntArray(int[] container) {

	int max = 0;
	for (int i = 0; i < container.Length - 1; i++) {
		if (container[i] > max)
			max = container[i];
	}
	return max;
}