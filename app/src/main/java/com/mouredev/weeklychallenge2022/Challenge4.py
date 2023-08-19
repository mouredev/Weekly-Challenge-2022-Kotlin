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

def calcular_area(poligono):
    if poligono["tipo"] == "triángulo":
        base, altura = poligono["base"], poligono["altura"]
        area = (base * altura) / 2
        print(f"El área del triángulo es: {area}")

    elif poligono["tipo"] == "cuadrado":
        lado = poligono["lado"]
        area = lado * lado
        print(f"El área del cuadrado es: {area}")

    elif poligono["tipo"] == "rectángulo":
        base, altura = poligono["base"], poligono["altura"]
        area = base * altura
        print(f"El área del rectángulo es: {area}")

    else:
        print("Poligono no soportado")


calcular_area({"tipo": "triángulo",
               "base": 2,
               "altura": 3})

calcular_area({"tipo": "cuadrado",
               "lado": 2})

calcular_area({"tipo": "rectángulo",
               "base": 2,
               "altura": 3})

calcular_area({"tipo": "circulo"})