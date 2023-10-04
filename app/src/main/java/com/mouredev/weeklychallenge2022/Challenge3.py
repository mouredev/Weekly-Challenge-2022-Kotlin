'''/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */'''

from math import sqrt
import time

def isPrimeBrute(number):
    for n in range(2, number):
        if number%n == 0:
            if n != number:
                return False
    return True


#inicio = time.time()

for x in range(2,101):
    if isPrimeBrute(x):
        print(x)
#fin = time.time()
#print(f"Tiempo de ejecución en milisegundos: {(fin-inicio)*1000}")
