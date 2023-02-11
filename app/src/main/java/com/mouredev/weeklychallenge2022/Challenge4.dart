/*
 * Crea una única función (importante que sólo sea una) que sea capaz
 * de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */

void main() {
  Triangle(base: 1, height: 2).calculateArea;
  Rectangle(length: 4, width: 2).calculateArea;
  Square(side: 4).calculateArea;
}

abstract class Polygon {
  double? calculateArea;
}

class Triangle extends Polygon {
  Triangle({
    required this.base,
    required this.height,
  });

  double base;
  double height;

  @override
  double get calculateArea {
    double value = (base * height) / 2;

    print(value);
    return value;
  }
}

class Rectangle extends Polygon {
  Rectangle({
    required this.length,
    required this.width,
  });

  double length;
  double width;

  @override
  double get calculateArea {
    double value = length * width;

    print(value);
    return value;
  }
}

class Square extends Polygon {
  Square({
    required this.side,
  });

  double side;

  @override
  double get calculateArea {
    double value = side * side;

    print(value);
    return value;
  }
}
