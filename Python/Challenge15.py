# 
#  Reto #15
#  ¿CUÁNTOS DÍAS?
#  Fecha publicación enunciado: 11/04/22
#  Fecha publicación resolución: 18/04/22
#  Dificultad: DIFÍCIL
# 
#  Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
#  - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
#  - La función recibirá dos String y retornará un Int.
#  - La diferencia en días será absoluta (no importa el orden de las fechas).
#  - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
# 
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar 
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
# 
#


def its_leap_year(year: int) -> bool:
    """
    Función que determina si un año es bisiesto. 
    """
    if year % 4 == 0:
        if year % 100 == 0:
            if year % 400 == 0:
                return True
            else:
                return False
        else:
            return True
    else:
        return False


def count_days(day: int, month: int, year: int) -> int:
    """
    Cuenta los días de una fecha en específico.
    """

    # Días dependiendo del mes
    day_months = [31, 28, 31, 30, 31, 0, 30, 31, 31, 30, 31, 30, 31]

    # Variable a retornar
    days_total = 0

    # Si el mes es febrero o posterior, verifica si es un año bisiesto y calcula los días en específico del año
    if month >= 2:

        # Si el año es bisiesto, define a febrero con 29 días
        if its_leap_year(year):
            day_months[1] = 29

        # Acumula los días transcurridos a la fecha
        for i in range(0, month - 1):
            days_total += day_months[i]

    # Acumula la cantidad de días de los años. Se multiplica por 365.25 porque cada 4 años ocurre un año bisiesto.
    days_total += int(365.25 * year)

    # Retorna los días acumulador
    return days_total + day


def how_many_days(first_date: str, second_date: str) -> int:
    """
    Calcula la cantidad de días entre dos fechas y retorna el número.

    Crea excepciones de acuerdo al enunciado.
    """

    # Verifica que el formato de separadores de las fechas estén correctos
    if (first_date.count("/") != 2) or (second_date.count("/") != 2):
        raise ValueError("El formato de la fecha no es la correcta, faltan datos o no se utilizaron los separadores"
                         " correctos.")

    # Separa los strings entregados
    day_one, month_one, year_one = first_date.split("/")
    day_two, month_two, year_two = second_date.split("/")

    # Intenta cambiar el formato de cada fecha a entero, si no funciona, lanza una Excepción.
    try:
        day_one = int(day_one)
        month_one = int(month_one)
        year_one = int(year_one)

        day_two = int(day_two)
        month_two = int(month_two)
        year_two = int(year_two)

    except:
        raise ValueError("Los valores ingresados en la fecha, no son del tipo necesitado o no son del tipo entero. \n"
                         "\tVerifique que las fechas están en el formato dd/MM/yyyy, por ejemplo 24/12/2000.") from None

    # Verifica que la primera fecha corresponde al formato correcto
    if not (0 < day_one <= 31) or not (0 < month_one <= 12) or not (0 < year_one):
        raise TypeError(f"El valor ingresado {first_date} no está en el formato especificado.")

    # Verifica que la segunda fecha corresponde al formato correcto
    if not (0 < day_two <= 31) or not (0 < month_two <= 12) or not (0 < year_two):
        raise TypeError(f"El valor ingresado {second_date} no está en el formato especificado.")

    # Retorna el valor absoluto de días
    return abs(count_days(day_one, month_one, year_one) - count_days(day_two, month_two, year_two))


# Test
print(how_many_days("12/2/2000", "20/2/2020"))
print(how_many_days("-5/2/23", "m/s/80"))
print(how_many_days("-5/1/23", "4/12/2060"))
print(how_many_days("1/1/1900", "18/4/2022"))
print(how_many_days("1/1/2022", "18/4/2022"))
print(how_many_days("1/1/1", "18/4/2022"))

# Result Test
# "12/2/2000", "20/2/2020" -> 7313
# "-5/2/23", "m/s/80" -> Exception
# "-5/1/23", "4/12/2060" -> Exception
# "1/1/1900", "18/4/2022" -> 44667
# "1/1/2022", "18/4/2022" -> 107
# "1/1/1", "18/4/2022" -> 738277
