"""
Reto #4
ÁREA DE UN POLÍGONO
Fecha publicación enunciado: 24/01/22
Fecha publicación resolución: 31/01/22
Dificultad: FÁCIL

Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
- La función recibirá por parámetro sólo UN polígono a la vez.
- Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
- Imprime el cálculo del área de un polígono de cada tipo.

Información adicional:
- Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
- Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
- Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
- Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""

def main ():
    rectangulo = Rectangulo(15,10)
    cuadrado = Cuadrado(5)
    triangulo = Triangulo(15,10)

    print("Este es el area del rectangulo: ", rectangulo.get_area())
    print("Este es el area del cuadrado: ",cuadrado.get_area())
    print("Este es el area del triangulo: ",triangulo.get_area())


class Rectangulo:
    def __init__(self, base, altura) -> None:
        self.base = base
        self.altura = altura
    
    def get_area(self) -> int:
        return self.base * self.altura

class Triangulo:
    def __init__(self, base, altura) -> None:
        self.base = base
        self.altura = altura

    def get_area(self) -> float:
        return (self.base * self.altura)/2

class Cuadrado:
    def __init__(self,lado) -> None:
        self.lado = lado

    def get_area(self) -> int:
        return self.lado * self.lado

main()