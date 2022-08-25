'''
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
'''

import random


def create_array():
    list_a = []

    for i in range(0,50):
        num = random.randint(0,100)
        list_a.append(num)
    return list_a

def lost_numbers():
    #original_list = ['a','b']
    original_list = create_array()
    convert_set = set(original_list)
    list_s = list(convert_set)

    list_s.sort()
    print('\n')
    print(f'Array original: {list_s}'  )
    a = list_s[0]
    b = list_s[-1]
    try:
        int(a)
        int(b)
    except Exception as e:
        return print('El array no es correcto')
    new_list = []
    for i in range(a + 1,b):
        new_list.append(i)
    print('\n')
    print(f'Números perdidos entre {a} y {b} : {new_list} ')

if __name__ == '__main__':
    lost_numbers()