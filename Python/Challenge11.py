#
#  Reto #11
#  ELIMINANDO CARACTERES
#  Fecha publicación enunciado: 14/03/22
#  Fecha publicación resolución: 21/03/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como
#             salida (out1, out2).
#  - out1 contendrá todos los caracteres presentes en la str1, pero NO estén presentes en str2.
#  - out2 contendrá todos los caracteres presentes en la str2, pero NO estén presentes en str1.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#


def delete_common_chars(expr1: str, expr2: str):

    # Define the Output Variables
    out1 = expr1.lower()
    out2 = expr2.lower()

    # List wit common chars between expressions
    chars_in_common = []

    # Append common chars to list
    # A Space -> " " is not considered as a common char
    # An Accent Mark is not considered
    for char in out1:
        if char in out2 and char != " ":
            chars_in_common.append(char)

    # Replaces any common char in both expressions
    for char in chars_in_common:
        out1 = out1.replace(char, "")
        out2 = out2.replace(char, "")

    print(f"For '{expr1}' the output is: '{out1}'")
    print(f"For '{expr2}' the output is: '{out2}'")


# Tests
delete_common_chars("La justicia", "es armonía.")
delete_common_chars("Si eres bueno para algo", "Nunca lo hagas gratis")
delete_common_chars("La ignorancia", "No es lo mismo que la inocencia.")
delete_common_chars("Siempre tendrás miedo", "A aquello que no entiendas.")

# Result Tests
# delete_common_chars("La justicia", "es armonía.")
#   - For 'La justicia' the output is: 'l jutici'
#   - For 'es armonía.' the output is: 'e rmoní.'
#
# delete_common_chars("Si eres bueno para algo", "Nunca lo hagas gratis")
#   - For 'Si eres bueno para algo' the output is: ' ee be p '
#   - For 'Nunca lo hagas gratis' the output is: 'c  h t'
#
# delete_common_chars("La ignorancia", "No es lo mismo que la inocencia.")
#   - For 'La ignorancia' the output is: ' gr'
#   - For 'No es lo mismo que la inocencia.' the output is: ' es  msm que  e.'
#
# delete_common_chars("Siempre tendrás miedo","A aquello que no entiendas.")
#   - For 'Siempre tendrás miedo' the output is: 'mpr rá m'
#   - For 'A aquello que no entiendas.' the output is: 'a aqull qu  a.'
