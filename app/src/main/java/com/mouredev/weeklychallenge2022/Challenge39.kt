package com.mouredev.weeklychallenge2022

/*
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

from random import randrange

# Generar 20 numeros aleatorios entre 1 y 99
nums = [randrange(1, 100, 1) for x in range(20)]

def quickSort(nums):
    # Si la lista esta vacía se retorna
    if len(nums) == 0:
        return nums

    left = []
    right = []
    pivot = nums[0]
    
    for i in range(1, len(nums)):
        # Si valor de nums es < que pivot se va a la izquierda sino a la derecha
        if nums[i] < pivot:
            left.append(nums[i])
        else:
            right.append(nums[i])
    # Se realiza la recursion
    return quickSort(left) + [pivot] + quickSort(right)

print(f"Lista de numeros inicial: {nums}")
print(f"Lista de numeros ordenada: {quickSort(nums)}")





