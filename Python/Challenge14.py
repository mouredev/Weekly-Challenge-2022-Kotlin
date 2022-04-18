# 
#  Reto #14
#  ¿ES UN NÚMERO DE ARMSTRONG?
#  Fecha publicación enunciado: 04/04/22
#  Fecha publicación resolución: 11/04/22
#  Dificultad: FÁCIL
#  *
#  Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
#  Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
#  *
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#


def is_armstrong_number(number: int):
    # Variables
    string_number = str(number)
    final_number = 0

    # Por cada número del número ingresado, suma la potencia de cada número elevado al largo del número
    for num in string_number:
        final_number += int(num) ** len(string_number)
    
    # Compara si el Número ingresado es igual al número resultante de la operación anterior
    # Retorna True si se cumple
    if final_number == number:
        return True
    else:
        return False


# Tests
print(is_armstrong_number(371))
print(is_armstrong_number(8208))
print(is_armstrong_number(4210818))
print(is_armstrong_number(2015))

# Result Tests
# 371       -> True
# 8208      -> True
# 4210818   -> True
# 2015      -> False
