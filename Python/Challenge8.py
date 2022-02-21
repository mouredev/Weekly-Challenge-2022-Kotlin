#
#   Reto #8
#   DECIMAL A BINARIO
#   Fecha publicación enunciado: 18/02/22
#   Fecha publicación resolución: 02/03/22
#   Dificultad: FÁCIL
#  
#   Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias
#   del lenguaje que lo hagan directamente.
#  
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  
#

def decimal_to_binary(decimal_number: int):
    decimal_num = decimal_number
    binary = ""
    binary_result = ""

    # Mientras el número sea diferente de 0, lo divide por 2 y añade el módulo a un String
    while decimal_number != 0:
        module = decimal_number % 2
        decimal_number = decimal_number // 2
        binary += str(module)

    # Invierte el String para obtener el resultado final
    for i in binary[::-1]:
        binary_result += i

    # Retorna el Resultado
    print(f"The decimal number {decimal_num}, in binary is {binary_result}.")


# Test
decimal_to_binary(15000)

# Test Result
# The decimal number 15000, in binary is 11101010011000.
