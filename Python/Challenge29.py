#
#   Reto #29
#   ORDENA LA LISTA
#   Fecha publicación enunciado: 18/07/22
#   Fecha publicación resolución: 26/07/22
#   Dificultad: FÁCIL
#
#   Enunciado: Crea una función que ordene y retorne una matriz de números.
#   - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
#     "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
#   - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

ORDER_ALLOW = ["ASC", "DESC"]


def sort_list(number_list: list[int], order: str):
    # Formato al orden a realizar
    order_upper = order.upper()

    # Verificación si los datos ingresados son válidos
    can_continue = True
    [can_continue := False for n in number_list if type(n) != int]

    if not can_continue or order_upper not in ORDER_ALLOW:
        return "Error en los valores ingresados"

    # Variables
    new_number_list = number_list
    list_sorted = []

    # Mientras la matriz con números se mantenga con valores, realiza la operación
    while len(new_number_list) > 0 and can_continue:
        # Se borra la variable en cada iteración
        next_number = None

        # Por cada número de la matriz, encuentra el valor mayor o menor
        for i in new_number_list:
            # Si se tiene un valor vacío del valor a encontrar, lo reemplaza por el primer valor
            if next_number is None:
                next_number = i

            # Si el orden es ascendente, se busca el valor más pequeño de la lista
            elif order_upper == "ASC" and i <= next_number:
                next_number = i

            # Si el orden es descendente, se busca el valor más grande de la lista
            elif order_upper == "DESC" and i >= next_number:
                next_number = i

        # El valor encontrado se elimina de la lista y se añade a la lista a retornar
        new_number_list.remove(next_number)
        list_sorted.append(next_number)

    return list_sorted

# Tests
print(sort_list([1, 4, 2, 5, 7, 3, 2, 1], "asc"))
print(sort_list([-13, 4349, -249002, 239, 694], "asc"))
print(sort_list([590, 2949,5, 2, 0, 4], "desc"))
print(sort_list([1, 55949, 449, 2440, 0, -1, -64], "desc"))
print(sort_list([1, 4, 2, 5, 7, 3, 2, ""], "desc"))
print(sort_list([1, 4, 2, 5, 7, 3, 2, ""], "des"))

# Result Tests
# ASC   -> [1, 1, 2, 2, 3, 4, 5, 7]
# ASC   -> [-249002, -13, 239, 694, 4349]
# DESC  -> [2949, 590, 5, 4, 2, 0]
# DESC  -> [55949, 2440, 449, 1, 0, -1, -64]
# DESC  -> Error en los valores ingresados
# DES   -> Error en los valores ingresados
