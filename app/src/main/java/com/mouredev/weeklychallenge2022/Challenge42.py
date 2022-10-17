"""
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 """

def temperature_conversor(C, F):
        if C == None:
            calculate_C: int = ((F - 32) * 5 / 9)
            return print(calculate_C, "°C")
        elif F == None:
            calculate_F: int = ((C * 9 / 5) + 32)
            return print(calculate_F, "°F")
        elif F == None & C == None:
            print("Error")

# Aqui el usuario debe escribir los parametros (C, F) Debe indicar con "None" el valor al cual quiere convertir la temperatura. Ejemplo: temperature_conversor(None, 80) converiria 80F a Celsius
temperature_conversor(24, None)

