/*
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
*/
import 'dart:math';

void main() {
  Map<String, Map<String, double>> triangle = {
    'Triangle': {'Base': 5.0, 'Height': 5.0}
  };
  Map<String, Map<String, double>> square = {
    'Square': {'Side': 10.0}
  };
  Map<String, Map<String, double>> rectangle = {
    'Rectangle': {
      'Width': 15.0,
      'Length': 26.3,
    }
  };
  polygonArea(triangle);
  polygonArea(square);
  polygonArea(rectangle);
}

void polygonArea(Map<String, Map<String, double>> polygon) {
  String polygonType = polygon.keys.first.toLowerCase().trim(),
      original = polygon.keys.first;
  List<String> acceptedPolygonTypes = ["triangle", "square", "rectangle"];
  bool isTriangle = polygonType == acceptedPolygonTypes[0],
      isSquare = polygonType == acceptedPolygonTypes[1];
  double area = 0;

  if (!acceptedPolygonTypes.contains(polygonType))
    print(
        "Sorry, the accepted polygon types are Triangle, Square and Rectangle.");
  else if (isTriangle) {
    double base = polygon[original]!['Base']!;
    double height = polygon[original]!['Height']!;
    area = (base * height) / 2;
    print("The triangle area is $area");
  } else if (isSquare) {
    double side = polygon[original]!['Side']!;
    area = pow(side, 2).toDouble();
    print("The square area is $area");
  } else {
    double width = polygon[original]!['Width']!;
    double length = polygon[original]!['Length']!;
    area = width * length;
    print("The rectangle area is $area");
  }
}
