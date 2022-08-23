""" /*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
 """

def numerosPerdidos():
    """Función para calcular los números perdidos entre dos números y devolver la lista completa"""

    print("Vamos a calcular los números perdidos entre dos numeros")
    cantidad = 2
    numeros = []

    for i in range(cantidad):
        numero = int(input("Introduce un numero: "))
        numeros.append(numero)

    array = numeros
    print("Array de entrada: {}".format(array))
    array = sorted(array)
    print("Array ordenado: {}".format(array))
    arrayPerdidos = []

    for i in range(array[0], array[len(array)-1]):
        if i not in array:
            arrayPerdidos.append(i)
    print("Numeros perdidos: {}".format(arrayPerdidos))

    nuevoArray = array + arrayPerdidos
    ordenarNuevoArray = sorted(nuevoArray)
    print("Array ordenado con los numeros perdidos: {}".format(ordenarNuevoArray))

if __name__ == '__main__':
    numerosPerdidos()
