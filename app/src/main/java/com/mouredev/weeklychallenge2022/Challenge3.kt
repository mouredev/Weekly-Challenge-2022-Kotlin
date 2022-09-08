package com.mouredev.weeklychallenge2022

/*
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
 */
n = 100
# Crear lista del 2 a n
primos = list(range(2, n+1))

i = 0

while primos[i] ** 2 <= n:
    for num in primos:
        # Omitir los primos seleccionados
        if num <= primos[i]:
            continue
        elif num % primos[i] == 0:
            primos.remove(num)
    i += 1

print(f"Los primos del 1 al 100 en función de la criba de Eratóstenes son {primos}")    
