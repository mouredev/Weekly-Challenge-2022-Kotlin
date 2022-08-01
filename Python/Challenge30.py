#
#   Reto #30
#   MARCO DE PALABRAS
#   Fecha publicación enunciado: 26/07/22
#   Fecha publicación resolución: 01/08/22
#   Dificultad: FÁCIL
#
#   Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
#   un marco rectangular de asteriscos.
#   - ¿Qué te parece el reto? Se vería así:
#     **********
#     * ¿Qué   *
#     * te     *
#     * parece *
#     * el     *
#     * reto?  *
#     **********
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

ALIGN = ["RIGHT", "LEFT", "CENTER"]


def check_odd(num: int):
    return True if num % 2 != 0 else False


def textCuadro(text: str, align: str):
    text_lines = text.split(" ")
    max_char = None

    for lines in text_lines:
        len_line = len(lines)

        if max_char == None:
            max_char = len_line

        elif len_line > max_char:
            max_char = len_line

    print((max_char + 4) * "*")

    for lines in text_lines:
        space = (max_char - len(lines))

        if align == "LEFT":
            print(f"* {lines}{' ' * space} *")

        elif align == "RIGHT":
            print(f"* {' ' * space}{lines} *")

        elif align == "CENTER":
            mid_space = space // 2
            first_space = ' ' * \
                mid_space if not check_odd(space) else ' ' * (mid_space + 1)

            print(f"* {first_space}{lines}{' ' * mid_space} *")

    print((max_char + 4) * "*" + "\n")


# Tests
textCuadro(text="¿Qué te parece el reto?", align="LEFT")
textCuadro(text="¿Qué te parece el reto?", align="RIGHT")
textCuadro(text="¿Qué te parece el reto?", align="CENTER")
textCuadro(text="Comenzamos a Picar", align="CENTER")

# Result Tests
# **********
# * ¿Qué   *
# * te     *
# * parece *
# * el     *
# * reto?  *
# **********

# **********
# *   ¿Qué *
# *     te *
# * parece *
# *     el *
# *  reto? *
# **********

# **********
# *  ¿Qué  *
# *   te   *
# * parece *
# *   el   *
# *  reto? *
# **********

# **************
# * Comenzamos *
# *      a     *
# *    Picar   *
# **************