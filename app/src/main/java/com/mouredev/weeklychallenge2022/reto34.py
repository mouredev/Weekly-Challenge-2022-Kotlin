"""
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

def array_ok (array):
    #El array debe ser de enteros
    for i in array:
        if type(i) != int:
            return False

    #El array debe ser sin repetidos y ordenado
    x=set(array)
    x=sorted(x)

    #Lo comparamos con el array inicial
    if x==array:
        return True
    else:
        return False
    

def num_fault(array):
    if array_ok(array):
        faltan = []
        for i in range(array[0],array[-1]):
            if i not in a:
                faltan.append(i)
        return (faltan)
    else:
        return "El array debe ser de enteros ordenado y sin repetidos"

if __name__=='__main__':
    a = [3,5,7,10]
    print (num_fault(a))