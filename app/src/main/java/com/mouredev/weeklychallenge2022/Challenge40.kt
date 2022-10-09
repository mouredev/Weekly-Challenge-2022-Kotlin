package com.mouredev.weeklychallenge2022

/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

from math import factorial

def combinacion(n, r):
    return factorial(n)//(factorial(r)*factorial(n-r))

num = int(input("Introduce un número: "))

for n in range(num):
    row = []    
    for r in range(n+1):
        row.append(combinacion(n, r))
    print(' '*(num-n) + " ".join(str(e) for e in row))
