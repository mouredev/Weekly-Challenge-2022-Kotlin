package com.mouredev.weeklychallenge2022

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

binario = []
n = 0
def decimalToBinary(n):
    while n > 0:
        resto = n % 2
        n //= 2
        binario.append(str(resto))
    return binario

while n <= 0:
    try:
        n = int(input("Introduce un numero positivo para convertir a binario: "))
        bin = decimalToBinary(n)
    except ValueError:
        print("Recuerda que debes introducir un valor numerico")

print(f"El numero {n} es {''.join(bin)} en binario")
