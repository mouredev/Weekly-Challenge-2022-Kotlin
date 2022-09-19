# Crea una única función (importante que sólo sea una) que sea capaz
# de calcular y retornar el área de un polígono.
# - La función recibirá por parámetro sólo UN polígono a la vez.
# - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
# - Imprime el cálculo del área de un polígono de cada tipo.

#Importa libreria necesaria prara definir clases abstractas
from abc import ABC, abstractmethod

#Crea la clase abstracta.
class  Poligono(ABC):
    @abstractmethod
    def area(self):
        pass
    @abstractmethod
    def printArea(self):
        pass

#Posteriormente se crean las diferentes clases de las cuales heredan del poligono
class triangulo(Poligono):
    def __init__(self, base, altura): #condtructor para inicializar las propiedades del poligono
        self.altura= altura
        self.base=base
    def area(self):
        return (self.base * self.altura)/2

    def printArea(self):
        print(f'El area del triangulo es {self.area()}')

class cuadrado(Poligono):
    def __init__(self,lado):
        self.lado=lado
    def area(self):
        return self.lado * self.lado

    def printArea(self):
        print(f'El area del cuadrado es {self.area()}')

class rectangulo(Poligono):
    def __init__(self, base, altura):
        self.altura= altura
        self.base=base
    def area(self):
        return self.base * self.altura

    def printArea(self):
        print(f'El area del rectangulo es {self.area()}')


t= triangulo(1,3)
t.printArea()
c= cuadrado(4)
c.printArea()
r= rectangulo(2,3)
r.printArea()
