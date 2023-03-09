#
#   Reto #26
#   CUADRADO Y TRIÁNGULO 2D
#   Fecha publicación enunciado: 27/06/22
#   Fecha publicación resolución: 07/07/22
#   Dificultad: FÁCIL
#
#   Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
#   - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
#   - EXTRA: ¿Eres capaz de dibujar más figuras?
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

def draw_square(size: int, solid: bool):

    if solid:
        [print(size * "* ") for i in range(size)]

    else:
        if size > 1:
            print(size * "* ")

            [print("* " + (size - 2) * "  " + "* ") for i in range(size-2)]

            print(size * "* ")
        else:
            print("*")


def draw_triangle(size: int, type: int):
    TYPES_ALLOW = [1, 2, 3]

    if type in TYPES_ALLOW:

        if type == 1:
            [print(i * "* ") for i in range(size+1)]

        if type == 2:
            [print((size - i) * " " + i * "* ") for i in range(size+1)]

        if type == 3:
            [print((size - i) * "  " + i * "* ") for i in range(size+1)]


def draw(type: str, size: int, solid: bool = True, type_triangle: int = 1):

    TYPE_DRAW = ["square", "triangle"]

    if type.lower() in TYPE_DRAW:

        if type.lower() == "square":
            draw_square(size=size, solid=solid)

        elif type.lower() == "triangle":
            draw_triangle(size=size, type=type_triangle)


# Tests
draw(type="square", size=5, solid=True)
print("\n")
draw(type="square", size=5, solid=False)
draw(type="triangle", size=5, type_triangle=1)
draw(type="triangle", size=5, type_triangle=2)
draw(type="triangle", size=5, type_triangle=3)

# Result Tests
# 
# Solid Square
# * * * * *
# * * * * *
# * * * * *
# * * * * *
# * * * * *
#
# No Solid Square
# * * * * *
# *       *
# *       *
# *       *
# * * * * *
#
# Triangle 1
# *
# * *
# * * *
# * * * *
# * * * * *
#
# Triangle 2
#     *
#    * *
#   * * *
#  * * * *
# * * * * *
#
# Triangle 3
#         *
#       * *
#     * * *
#   * * * *
# * * * * *
