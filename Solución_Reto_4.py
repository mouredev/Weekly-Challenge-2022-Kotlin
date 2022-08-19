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
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
"""

def polygon():
    def triangulo():
        b = int(input("Introduce la base del triangulo = "))
        h = int(input("Introduce la altura del triangulo = "))
        print(f'El área del triángulo es {(b*h)/2}')
    
    def cuadrado():
        l = int(input("Introduce el lado del cuadrado = "))
        print(f'El área del cuadrado es {l**2}')
    
    def rectangulo():
        b = int(input("Introduce la base del rectangulo = "))
        h = int(input("Introduce la altura del rectangulo = "))
        print(f'El área del triángulo es {b*h}')

    triangulo()
    cuadrado()
    rectangulo()
    
"""
polygon()--->

Introduce la base del triangulo = 4
Introduce la altura del triangulo = 6
El área del triángulo es 12.0
Introduce el lado del cuadrado = 5
El área del cuadrado es 25
Introduce la base del rectangulo = 20
Introduce la altura del rectangulo = 5
El área del triángulo es 100

"""
