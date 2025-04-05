"""
#4-ÁREA DE UN POLÍGONO
/*
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */

*triangulo= base por altura dividido por 2.
*cuadrado= multiplicamos Lado x Lado
*rectangulo= multiplicamos el largo por el ancho.


"""

def area (num_1, num_2):
        triangulo = (num_1 * num_2) /2
        var = num_1 * num_2
        print (f"el area del triangulo es {triangulo}")
        print (f"el area del cuadrado es {var}")
        print (f"el area del rectangulo es {var}")

num_1 = 5
num_2 = 2

area(num_1, num_2)