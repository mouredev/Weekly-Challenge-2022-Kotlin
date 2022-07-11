#
#   Reto #27
#   VECTORES ORTOGONALES
#   Fecha publicación enunciado: 07/07/22
#   Fecha publicación resolución: 11/07/22
#   Dificultad: FÁCIL
#
#   Enunciado: Crea un programa que determine si dos vectores son ortogonales.
#   - Los dos array deben tener la misma longitud.
#   - Cada vector se podría representar como un array. Ejemplo: [1, -2]
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

def check_ortogonal(num1: tuple, num2: tuple):

    # Verifica que la longitud de ambos vectores sea la misma y que el vector sea a lo menos de 2 dimensiones
    # * Sirve para vectores de n dimensiones, no tiene límite respecto a ello
    if len(num1) != len(num2) or len(num1) < 2 or len(num2) < 2:
        return "Error en el largo de los vectores"

    # Comprueba que ambos vectores tengan solo elementos del tipo entero
    for i in num1:
        if type(i) != int:
            return "Error en tipo de elemento del vector"
    for i in num2:
        if type(i) != int:
            return "Error en tipo de elemento del vector"

    # Realiza la comprobación de los vectores que sean ortogonales, retorna True si es así
    result = 0
    for index in range(len(num1)):
        result += num1[index] * num2[index]

    return True if result == 0 else False


# Tests
print(check_ortogonal((3, 1), (1, 4, 8)))
print(check_ortogonal((3, -2), (-2, 3)))
print(check_ortogonal((3, 2), (-2, 3)))
print(check_ortogonal((3, "2"), (-2, 3)))

# Result Tests
# Error en el largo de los vectores
# False
# True
# Error en tipo de elemento del vector
