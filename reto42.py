#
# Enunciado: Crea una función que transforme grados Celsius en Fahrenheit
# y vice-versa.
#
# - Para que un dato de entrada sea correcto debe poseer un símbolo "°"
#   y su unidad ("C" o "F").
# - En caso contrario retornará un error.
# - ¿Quieres emplear lo aprendido en este reto?
#   Revisa el reto mensual y crea una App:
#   https://retosdeprogramacion.com/mensuales2022
#
def convert_temperature(unidad, grados):
    try:
        if unidad == '°F':
            celsius = (grados - 32) * 5 / 9
            return '%.2f grados Fahrenheit son: %0.2f grados Celsius' % (grados, celsius)

        if unidad == '°C':
            fahrenheit = (grados * 9 / 5) + 32
            return '%.2f grados Celsius son: %0.2f grados Fahrenheit' % (grados, fahrenheit)

        return 'Invalid values'
    except TypeError:
        return 'Invalid values'


if __name__ == "__main__":
    print(convert_temperature('°F', 22.76))  # 22.00 grados Fahrenheit son: -5.56 grados Celsius
    print(convert_temperature('°C', 34))  # 34.00 grados Celsius son: 93.20 grados Fahrenheit
    print(convert_temperature('°c', 34))  # Invalid values
    print(convert_temperature('F', 22))   # Invalid values



