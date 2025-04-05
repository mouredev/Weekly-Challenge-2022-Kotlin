"""
#1-¿ES UN ANAGRAMA?
/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */
"""

def anagrama (var_1, var_2):
    if var_1.lower() == var_2.lower():
        #print ("las palabras son iguales")
        return False
    return sorted(var_1.lower()) == sorted (var_2.lower())
    
"""otra opcion
    
    elif sorted(var_1.lower()) == sorted (var_2.lower()):
        #print ("las palabras son anagramas")
        return True
    else:
        #print ("las palabras NO son anagramas")
        return False
"""

print (anagrama("Caso", "saco"))

