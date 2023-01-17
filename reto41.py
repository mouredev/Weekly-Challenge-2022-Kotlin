#
# Reto #41
#  LA LEY DE OHM
# Fecha publicación enunciado: 10/10/22
# Fecha publicación resolución: 17/10/22
# Dificultad: FACIL
#
# Enunciado: Crea una función que calcule el valor del parámetro perdido
# correspondiente a la ley de Ohm.
# - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
#   el valor del tercero (redondeado a 2 decimales).
# - Si los parámetros son incorrectos o insuficientes, la función retornará
#   la cadena de texto "Invalid values".
#

def ley_ohm(v, i, r):
    try:
        v = float(v)
        i = float(i)
        r = float(r)
    except ValueError:
        return "Invalid values"

    if (v != 0 and r != 0 and i != 0):
        return "Invalid values"

    if v == 0:
        if (r == 0 or i == 0):
            return "Invalid values"
        v = round(i * r , 2)
        return f"V es igual a: {v}"
    elif i == 0:
        if (v == 0 or r == 0):
            return "Invalid values"
        i = round(v / r , 2)
        return f"I es igual a: {i} "
    else:
        if (v == 0 or i == 0):
            return "Invalid values"
        r = round(v / i , 2)
        return f"R es igual a: {r}"


if __name__ == "__main__":

    v = input("Valor de 'V' o cero: ")
    i = input("Valor de 'I' o cero: ")
    r = input("Valor de 'R' o cero: ")

    print(ley_ohm(v, i, r))
