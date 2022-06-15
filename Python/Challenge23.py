#
#   Reto #23
#   MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
#   Fecha publicación enunciado: 07/06/22
#   Fecha publicación resolución: 13/06/22
#   Dificultad: MEDIA
#  
#   Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común 
#              múltiplo (mcm) de dos números enteros.
#   - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
#  
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar 
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#


def mcd(num1: int, num2: int):
    """
    Se realiza el cálculo del mcd se realiza mediante el algoritmo de Euclides.
    """
    # Se debe determinar el número mayor para asignar a las variables a y b
    if num1 > num2:
        a = num1
        b = num2

    else:
        a = num2
        b = num1
    
    # Mientras b sea distinto de cero se realiza la operación
    while b:
        mcd = b
        b = a % b
        a = mcd

    # Imprime el valor del mcd
    print(f"El M.C.D de {num1} y {num2} es {mcd}")
    
    return mcd


def mcm(num1: int, num2: int):
    # Calcula el mcm a partir del mcd y lo imprime
    print(f"El M.C.M de {num1} y {num2} es {(num1*num2) // mcd(num1, num2)}")


# Tests
mcm(10, 5)
mcm(8, 7)
mcm(1, 2)
mcm(21, 17)

# Result Tests
# 10 y 5 -> El M.C.D de 10 y 5 es 5
#           El M.C.M de 10 y 5 es 10
# 8 y 7  -> El M.C.D de 8 y 7 es 1
#           El M.C.M de 8 y 7 es 56
# 1 y 2 ->  El M.C.D de 1 y 2 es 1
#           El M.C.M de 1 y 2 es 2
# 21 y 17 -> El M.C.D de 21 y 17 es 1
#            El M.C.M de 21 y 17 es 357
