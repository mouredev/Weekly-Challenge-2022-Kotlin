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

DAYS_MONTHS = {
    1: 31,
    2: 28,
    3: 31,
    4: 30,
    5: 31,
    6: 30,
    7: 31,
    8: 31,
    9: 30,
    10: 31,
    11: 30,
    12: 31
}

from multiprocessing.sharedctypes import Value


def how_many_days(first_date: str, second_date: str):

    if (first_date.count("/") < 2) or (second_date.count("/") < 2):
        raise ValueError("El formato de la fecha no es la correcta, faltan datos o no se utilizaron los separadores"
                        " correctos.")


    day_one, month_one, year_one = first_date.split("/")
    day_two, month_two, year_two = second_date.split("/")

    try:
        

        day_one = int(day_one)
        month_one = int(month_one)
        year_one = int(year_one)
        
        day_two = int(day_two)
        month_two = int(month_two)
        year_two = int(year_two)
    except:
        raise ValueError("Los valores ingresados en la fecha, no son del tipo necesitado o no son del tipo entero. \n"
                        "\tVerifique que las fechas están en el formato dd/MM/yyyy, por ejemplo 24/12/2000.")
    

    if not (0 < day_one <= 31) or not (0 < month_one <= 12) or not (0 < year_one):
        raise TypeError(f"El valor ingresado {first_date} no está en el formato especificado.")
    
    if not (0 < day_two <= 31) or not (0 < month_two <= 12) or not (0 < year_two):
        raise TypeError(f"El valor ingresado {second_date} no está en el formato especificado.")
    
    
    print(day_one, month_one, year_one)
    print(day_two, month_two, year_two)


how_many_days("-1/-m2/-3", "4/6/7")