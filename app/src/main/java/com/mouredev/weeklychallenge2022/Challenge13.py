"""
 * Reto #13 - RESUELTO
 * FACTORIAL RECURSIVO
 * Fecha publicación enunciado: 28/03/22
 * Fecha publicación resolución: 04/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""
##################### LOGICA #########################
def factorial(n):
	if (n > 1):
		return n * factorial(n-1)
	else:								# Condición de salida del bucle
		return 1

def main(n):
	print(f"Resultado del número {n}>> " + str(factorial(n)))

##################### TESTS #########################
main(7)
"""
RESULTADOS:
5040

Conclusion -> Correcto
"""

print("\nSiguiente test: \n")

main(10)
"""
RESULTADOS:
3628800

Conclusion -> Correcto
"""
