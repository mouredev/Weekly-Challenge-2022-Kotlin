"""
* Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.

"""
# Author: Jose
# Date: 16/10/2022
# Challenge 4

def area(ladoA, ladoB, poligono):
    if poligono == 1:
        return (ladoA * ladoB) / 2
    if poligono == 2:
        return ladoA ** 2
    return ladoA * ladoB


print(f'Area del Cuadrado es : {area(5,0,2)}')
print(f'Area de Triangulo es : {area(5,6,1)}')
print(f'Area del rectangulo es : {area(5,8,3)}')