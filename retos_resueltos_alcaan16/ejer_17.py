"""
#17
LA CARRERA DE OBSTÁCULOS
/*
 * Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras
 *        "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo)
 *        o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
 *        será correcto y no variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 */
"""

def carrera (var1, var2):

    print (var1)
    print (var2)
    val = True
    z = 0
    new = ""
    if len(var2) == len(var1): #comprobamos que sean del mismo tamaño 
        for x in var1: #recorremos las acciones y comprobamos
            if x == "jump" and var2[z] != "|": 
                new += "x"
                val = False
            if x == "run" and var2[z] != "_":
                new += "/"
                val = False
            if (x == "jump" and var2[z] == "|") or (x == "run" and var2[z] == "_"):
                new += var2[z]
            z += 1
        print (f"la nueva carrera es {new}") #imprimimos la nueva carrera
        return val        

    else:
        print ("son diferentes")
        return val
    
print (carrera(["run", "jump"], "|_"))