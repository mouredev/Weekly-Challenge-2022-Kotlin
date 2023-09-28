"""
  Reto #8
  DECIMAL A BINARIO
  Fecha publicación enunciado: 18/02/22
  Fecha publicación resolución: 02/03/22
  Dificultad: FÁCIL
 
  Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 
  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""

def binario(numero):
    num_binario = ""
    while numero != 0:
        if numero % 2 == 0:
            num_binario += "0"
        else:
            num_binario += "1"
        numero = int(numero / 2)
        
    return num_binario


print(binario(300))
print(binario(20))
print(binario(123))