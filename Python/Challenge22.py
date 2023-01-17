#
#  Reto #22
#  CONJUNTOS
#  Fecha publicación enunciado: 01/06/22
#  Fecha publicación resolución: 07/06/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
#  - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
#  - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
#  - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#


def compare_list(list_one: list, list_two: list, compare: bool):
    
    # Determina los elementos comunes y no comunes de dos listas.
    # * Con los elementos no comunes se evalúan ambas listas.
    common = [i for i in list_one if i in list_two]
    uncommon = [i for i in list_one if i not in list_two]
    uncommon.extend([i for i in list_two if i not in list_one])

    # Si el booleano es True, retorna los elementos comunes
    if compare == True:
        return common

    # En caso de que sea False, retorna los elementos no comunes
    elif compare == False:
        return uncommon

    # En cualquier otro caso, retorna None
    else:
        return None


# Tests
print(compare_list([1, 2, 3], [3, "4", 5], True))
print(compare_list([1, 2, 3], [3, "4", 5], False))
print(compare_list([1, "g", "3", 6, 7], ["3", "g", 5], True))
print(compare_list([1, "g", "3", 6, 7], ["3", "g", 5], False))
print(compare_list([1, 2, 3], [3, 4, 5, 8, 9], True))
print(compare_list([1, 2, 3], [3, 4, 5, 8, 9], False))

# Result Test
# [1, 2, 3], [3, "4", 5], False             -> [3]
# [1, 2, 3], [3, "4", 5], True              -> [1, 2, '4', 5]
# [1, "g", "3", 6, 7], ["3", "g", 5], True  -> ['g', '3']
# [1, "g", "3", 6, 7], ["3", "g", 5], False -> [1, 6, 7, 5]
# [1, 2, 3], [3, 4, 5, 8, 9], True          -> [3]
# [1, 2, 3], [3, 4, 5, 8, 9], False         -> [1, 2, 4, 5, 8, 9]
