#
# Reto #44
# BUMERANES
# Fecha publicación enunciado: 02/10/22
# Fecha publicación resolución: 07/11/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
# enteros e imprima cada uno de ellos.
# - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
#   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
# - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#


def find_boomerang():
    my_boomerang = [2, 1, 2, 3, 3, 4, 2, 4, 5, 4, 5]
    counter = 0

    for i in range(len(my_boomerang) - 2):
        if my_boomerang[i] != my_boomerang[i + 2] or my_boomerang[i] == my_boomerang[i + 1]:
            continue
        print("[" + str(my_boomerang[i]) +
              "," + str(my_boomerang[i + 1]) +
              "," + str(my_boomerang[i + 2]) + "]")
        counter += 1

    print(counter, "boomerangs")


if __name__ == "__main__":
    find_boomerang()
