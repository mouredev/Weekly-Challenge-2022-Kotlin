# /*
#  * Enunciado: Crea una función que calcule el valor del parámetro perdido
#  * correspondiente a la ley de Ohm.
#  * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
#  *   el valor del tercero (redondeado a 2 decimales).
#  * - Si los parámetros son incorrectos o insuficientes, la función retornará
#  *   la cadena de texto "Invalid values".
#  */

def ohm(V,I,R):
    try:
        
        if V==None and I==None or V==None and R==None or I==None and R==None:
            return print('Invalid values') 
        else:
            if V==None:
                V=round(I*R,2)
                return print(f'V={V}')
            if I==None:
                I=round(V/R,2)
                return print(f'I={I}')
            if R==None:
                R=round(V/I,2)
                return print(f'R={R}')
        
    except TypeError:
        print('Invalid values')

if __name__=='__main__':
    ohm(23.987,'10',None)
    ohm(23.987,25.345,None)
    ohm(None,None,None)