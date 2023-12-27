"""/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */"""

def delcaracters (str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    
    out1 = ""
    for caracter in str1:
        if not caracter in str2:
                out1 = out1 + caracter
        
    out2 = ""            
    for caracter in str2:
        if not caracter in str1:
                out2 = out2 + caracter
                
    if out1 == out2:
        print ("Todos los caracteres de la cadena 1 se encuentran en la 2 y viceversa")   
    else:              
        print (out1)
        print (out2)

delcaracters ("hola","yo")
delcaracters ("hasta luego", "hasta mañana")
delcaracters ("hoy", "pasado")
delcaracters ("listo", "torpe")
delcaracters ("feo", "guapo")