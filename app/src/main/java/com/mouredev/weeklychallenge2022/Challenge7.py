"""
  Reto #7
  CONTANDO PALABRAS
  Fecha publicación enunciado: 14/02/22
  Fecha publicación resolución: 21/02/22
  Dificultad: MEDIA
 
  Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
  - Los signos de puntuación no forman parte de la palabra.
  - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
  - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 
  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""

import re

def repite(texto):
    expresion_regular = r"[\W]"
    texto_remplazado = re.sub(expresion_regular, " ", texto)
    lista_palabras = texto_remplazado.title().split()
    palabreas_repetidas = {}

    for palabra in lista_palabras:
        if palabra not in palabreas_repetidas: 
            palabreas_repetidas[palabra] = 1
        else: 
            palabreas_repetidas[palabra] += 1

    print(texto)
    print(palabreas_repetidas)


repite("Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev).")


