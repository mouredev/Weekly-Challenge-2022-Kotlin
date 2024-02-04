"""/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */"""

from datetime import *

def fechas(cadena):
    dia = int(cadena[0:2])
    mes = int(cadena[3:5])
    año = int(cadena[6:])
    cadena = date (año,mes,dia)
    return cadena

def dias_restantes (fecha1,fecha2):
    try:
        fecha1 = fechas(fecha1)
        fecha2 = fechas(fecha2)
        dias = fecha1 - fecha2
        dias = dias.days
        if dias <= 0:
            dias = dias * (-1)
        return dias     
    except ValueError:
        return ("Has introducido una fecha inválida")

print(dias_restantes ("10/09/2023","11/03/2024"))
print(dias_restantes ("120/09/2024","11/03/2023"))
print(dias_restantes ("10/09/2024","11/03/2023"))
print(dias_restantes ("10/09/20523","11/03/2024"))