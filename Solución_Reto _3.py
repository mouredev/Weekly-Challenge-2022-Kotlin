"""
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
 *
"""

def is_prime(num):
    if num > 2 and (num % 2 == 0):
        return "No es un numero primo"
    else: 
        if num > 7 and (num % 3 == 0 or num % 5 == 0 or num % 7 == 0):
        	return "No es un numero primo"
        else:
            return "Es un numero primo"

def list_isprime():
    list_nums = []
    for i in range(2,101):
        if is_prime(i) == "Es un numero primo":
            list_nums.append(i)
    print(f'Hay {len(list_nums)} números primos')
    print(*list_nums)
    
"""
list_isprime() --->
Hay 25 números primos entre el 1 y el 100
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
"""
    
