"""
* Reto #4
* ÁREA DE UN POLÍGONO
* Dificultad: FÁCIL
*
* Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
* - La función recibirá por parámetro sólo UN polígono a la vez.
* - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
* - Imprime el cálculo del área de un polígono de cada tipo.
*

* Challenge #4
* AREA OF A POLYGON
* Difficulty: EASY
*
* Statement: Creates A SINGLE FUNCTION (important that it is only one) that is capable of calculating and returning the area of a polygon.
* - The function will receive only ONE polygon per parameter at a time.
* - The supported polygons will be Triangle, Square and Rectangle.
* - Prints the calculation of the area of a polygon of each type.
"""

def polygon_area(polygon):
    polygon_type = [key for key in polygon.keys()][0].lower().strip()
    accepted_polygon_types = ["triangle", "square", "rectangle"]
    is_triangle = polygon_type == accepted_polygon_types[0]
    is_square = polygon_type == accepted_polygon_types[1]
    original_polygon = [key for key in polygon.keys()][0]

    if (polygon_type not in accepted_polygon_types):
        print("Sorry, the accepted polygon types are Triangle, Square and Rectangle.")
    elif (is_triangle):
        base = polygon[original_polygon]['Base']
        height = polygon[original_polygon]['Height']
        area = (base * height) / 2
        print(f"The triangle area is {area}")
    elif (is_square):
        side = polygon[original_polygon]['Side']
        area = side**2
        print(f"The square area is {area}")
    else:
        length = polygon[original_polygon]['Length']
        width = polygon[original_polygon]['Width']
        area = width * length
        print(f"The rectangle area is {area}")

triangle = {
    'Triangle': {'Base': 5.0, 'Height': 5.0}
}
square = {
    'Square': {'Side': 10.0}
}
rectangle = {
    'Rectangle': {
        'Width': 15.0,
        'Length': 26.3,
    }
}
polygon_area(triangle)
polygon_area(square)
polygon_area(rectangle)
