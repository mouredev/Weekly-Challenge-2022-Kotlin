"""
    Reto #0
    EL FAMOSO "FIZZ BUZZ"
    Fecha publicación enunciado: 27/12/2021
    Fecha publicación resolución: 09/03/2023
    Dificultad: FÁCIL
    Enunciado: Escribe un programa que muestre por consola (con un print
        los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión),
        sustituyendo los siguientes:
        - Múltiplos de 3 por la palabra "fizz".
        - Múltiplos de 5 por la palabra "buzz".
        - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
        Información adicional:
        - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal"
            para preguntas, dudas o prestar ayuda a la acomunidad.
        - Puedes hacer un Fork del repo y una Pull Request al repo original
            para que veamos tu solución aportada.
        - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
        - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""


def main():
    """Función main del programa"""
    for i in range(100):
        divisible_entre_tres = bool((i + 1) % 3 == 0)
        divisible_entre_cinco = bool((i + 1) % 5 == 0)
        # Condiciones de impresión
        if divisible_entre_tres and divisible_entre_cinco:
            print("fizzbuzz")
        elif divisible_entre_tres:
            print("fizz")
        elif divisible_entre_cinco:
            print("buzz")
        else:
            print(f"{i+1}")


if __name__ == "__main__":
    main()
