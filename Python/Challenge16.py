#
#  Reto #16
#  EN MAYÚSCULA
#  Fecha publicación enunciado: 18/04/22
#  Fecha publicación resolución: 25/04/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de poner en mayúscula la primera
#             letra de cada palabra.
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


def title_case(phrase: str):

    list_word = [word[0].upper() + word[1::].lower() for word in phrase.split(" ")]

    return " ".join(list_word)


# Test
print(title_case("hola mundo"))
print(title_case("mOuRedEV bY brais mOUre."))
print(title_case("no a la manzanilla..."))

# Result Test
# "hola mundo"  ->   Hola Mundo
# "mOuRedEV bY brais mOUre."    -> Mouredev By Brais Moure.
# "no a la manzanilla..."   ->    No A La Manzanilla...
