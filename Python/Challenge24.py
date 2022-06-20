#
#   Reto #24
#   ITERATION MASTER
#   Fecha publicación enunciado: 13/06/22
#   Fecha publicación resolución: 20/06/22
#   Dificultad: FÁCIL
#
#   Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de
#              hacerlo? Crea el código para cada una de ellas.
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

import random


def first():
    """
    Utilizando bucle For.
    """
    for i in range(1, 101):
        print(i)


def second():
    """
    Similar a first(), pero utilizando List Comprehension.
    """
    numbers = [print(i) for i in range(1, 101)]


def third():
    """
    Utilizando bucle While.
    """
    i = 1
    while i < 101:
        print(i)
        i += 1


def fourth():
    """
    Generando números random e imprimiendo el último valor solo si es el número siguiente.
    """
    last_number = 1

    while last_number < 101:
        random_number = random.randint(1, 101)

        if random_number == last_number + 1:
            print(last_number)
            last_number = random_number


def fifth():
    """
    De esta forma cuenta solo de 0 a 99. Realiza la unión de strings para formar el valor e imprimirlo
    """
    numbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    last_num = 1

    for i in range(0, 10):
        for number in numbers:
            last_num = int(f"{numbers[i]}{number}")
            print(last_num)


def sixth():
    """
    Utiliza una variable del tipo set, la cual se le va añadiendo un número al azar del 1 al 100. Se ordena e imprime
    cada valor
    """
    series = set()

    while len(series) < 100:
        series.add(random.randint(1, 100))

    series = sorted(series)
    for i in series:
        print(i)


def seventh():
    """
    Similar a Sixth pero utiliza una lista en vez de un set.
    """
    numbers = []

    while len(numbers) < 100:
        gen_random = random.randint(1, 100)

        if gen_random not in numbers:
            numbers.append(gen_random)

    numbers = sorted(numbers)
    [print(f"{item}") for item in numbers]


first()
second()
third()
fourth()
fifth()
sixth()
seventh()
