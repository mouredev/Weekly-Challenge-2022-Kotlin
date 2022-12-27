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

def to_binary(number) -> str:
    binary = ""

    if number == 0:
        return "0"

    if number < 0:
        return "The number needs to be positive"

    while number != 0:
        if number % 2 == 0:
            binary += "0"
        else:
            binary += "1"

        number = int(number / 2)

    return binary[::-1]

if __name__ == "__main__":
    print(to_binary(725))
    print(to_binary(0))
    print(to_binary(99))