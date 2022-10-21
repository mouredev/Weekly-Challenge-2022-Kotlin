'''
/*
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
 */
'''

def convertir_grados(grados):
    num = ''
    for i in range(len(grados)):
        if grados[i] in "0123456789":
            num += grados[i]
            grado=int(num)

    if "º" in grados and "C" in grados:
        return f"{round((grado * 9 / 5) + 32, 2)}ºF"
    elif "º" in grados and "F" in grados:
        return f"{round((grado - 32) * 5 / 9, 2)}ºC"
    else:
        return "Error"

def main ():
    print(convertir_grados("13ºC"))
    print(convertir_grados("66ºF"))
    print(convertir_grados("10C"))
    print(convertir_grados("15ºA"))
main()
