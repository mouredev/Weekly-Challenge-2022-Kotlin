'''
/*
 * Enunciado: Crea una función que calcule el valor del parámetro perdido
 * correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
 *   el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará
 *   la cadena de texto "Invalid values".
 */
'''
def ohm(*arg):
    param = len(arg)
    if param == 3:
        v,r,i = arg
        if v == 0:
            v = i*r
            return round(v,2)
        elif r == 0:
            r = v/i
            return round(r,2)
        elif i == 0:
            i = v/r
            return round(i,2)
    else:
        return "Invalid values"

def main():
    print(ohm(20,12,0))
    print(ohm(0,2))
    print(ohm(0,1.3,8.4))
    print(ohm(1,2,3,4))
    print(ohm(12,0,21))
    print(ohm(0))
main()