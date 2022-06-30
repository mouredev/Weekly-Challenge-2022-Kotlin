# Reto  # 4
# ÁREA DE UN POLÍGONO
# Fecha publicación enunciado: 24/01/22
# Fecha publicación resolución: 31/01/22
# Dificultad: FÁCIL

# Enunciado: Crea UNA ÚNICA FUNCIÓN(importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
# - La función recibirá por parámetro sólo UN polígono a la vez.
# - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
# - Imprime el cálculo del área de un polígono de cada tipo.

from abc import ABC, abstractmethod


class Polygon(ABC):

    @abstractmethod
    def area(self) -> float:
        pass


class Square(Polygon):

    def __init__(self, length: float) -> None:
        self.length = length

    def area(self) -> float:
        return self.length ** 2


class Rectangle(Polygon):

    def __init__(self, length: float, height: float) -> None:
        self.length = length
        self.height = height

    def area(self) -> float:
        return self.length * self.height


class Triangle(Polygon):
    def __init__(self, length: float, height: float) -> None:
        self.length = length
        self.height = height

    def area(self) -> float:
        return (self.length * self.height) / 2


if __name__ == '__main__':
    my_square = Square(20)
    my_rectangle = Rectangle(20, 30)
    my_triangle = Triangle(20, 30)

    print(f'The area of the square is: {my_square.area()}')
    print(f'The area of the rectangle is: {my_rectangle.area()}')
    print(f'The area of the triangle is: {my_triangle.area()}')
