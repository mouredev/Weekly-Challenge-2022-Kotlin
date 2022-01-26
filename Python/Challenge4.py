#
#  Reto #4
#  ÁREA DE UN POLÍGONO
#  Fecha publicación enunciado: 24/01/22
#  Fecha publicación resolución: 31/01/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que solo sea una) que sea capaz de calcular y retornar el área de
#              un polígono.
#  - La función recibirá por parámetro solo UN polígono a la vez.
#  - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
#  - Imprime el cálculo del área de un polígono de cada tipo.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#


def calculateArea():
    """
    Calcula el área de un polígono entre triángulo, cuadrado y rectángulo.

    ** En el caso de un triángulo, el 'ancho' es tomado como la 'base'.
    """

    # Solicita el Polígono para calcular el área
    polygon = input("¿A qué polígono le quieres calcular el área? (Triángulo, Cuadrado, Rectángulo): ").lower()

    # Solicita el alto y ancho del polígono
    height = float(input("¿Cuál es su altura?: "))
    width = float(input("¿Cuál es su ancho?: "))

    # Itera para ver la forma de calcular el área
    if polygon == "triangulo":
        areaPolygon = (width * height) / 2
    else:
        areaPolygon = width * height

    # Imprime el valor del área. (UM -> Unidad de Medida)
    print(f"El área del {polygon} es {areaPolygon} [UM^2]")


# Realiza la Función de Calcular el área
calculateArea()
