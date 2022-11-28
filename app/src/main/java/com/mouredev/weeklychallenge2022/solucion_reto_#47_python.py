"""
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que
 * más veces se repita.
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío. 
"""

print("¿Quiere saber cual vocal se repite mas en una cadena de texto?\n")
frase = input("ingrese texto a evaluar:\n")

def conteo_vocal(texto):
    a,b = "áéíóúü","aeiouu"
    transf = str.maketrans(a,b) # Crea tabla con datos a reemplazar (a) y los datos con los que deben reemplazarse. (b)
    cadena = str(texto).translate(transf) # hace el cambio en base a la tabla creada con 'maketrans'.    
    
    resultado = ""
    conteo = 0

    for caracter in texto:
        #utilice la funcion 'find', como filtro, ya que si no encuentra nada arroja por defecto el valor -1, 
        #si lo encuentra indica la 1era posición (en positivo).

        if caracter == "a":
            
            if conteo < cadena.count("a") and resultado.find("(a)") == -1: 
                    
                conteo = cadena.count("a")
                resultado = f"\n- Vocal (a), {conteo} veces repetidas"
        
            elif conteo == cadena.count("a") and resultado.find("(a)") == -1:

                resultado = f"{resultado}\n- Vocal (a), {conteo} veces repetidas"
            
        elif caracter == "e":
            
            if conteo < cadena.count("e") and resultado.find("(e)") == -1:
                    
                conteo = cadena.count("e")
                resultado = f"\n- Vocal (e), {conteo} veces repetidas"
        
            elif conteo <= cadena.count("e") and resultado.find("(e)") == -1:

                resultado = f"{resultado}\n- Vocal (e), {conteo} veces repetidas"
        
        elif caracter == "i":
            
            if conteo < cadena.count("i") and resultado.find("(i)") == -1:
                    
                conteo = cadena.count("i")
                resultado = f"\n- Vocal (i), {conteo} veces repetidas"
        
            elif conteo == cadena.count("i") and resultado.find("(i)") == -1:

                resultado = f"{resultado}\n- Vocal (i), {conteo} veces repetidas"
        
        elif caracter == "o":
            
            if conteo < cadena.count("o") and resultado.find("(o)") == -1:
                    
                conteo = cadena.count("o")
                resultado = f"\n- Vocal (o), {conteo} veces repetidas"
        
            elif conteo == cadena.count("o") and resultado.find("(o)") == -1:

                resultado = f"{resultado}\n- Vocal (o), {conteo} veces repetidas"

        elif caracter == "u":
            
            if conteo < cadena.count("u") and resultado.find("(u)") == -1:
                    
                conteo = cadena.count("u")
                resultado = f"\n- Vocal (u), {conteo} veces repetidas"
        
            elif conteo == cadena.count("u") and resultado.find("(u)") == -1:

                resultado = f"{resultado}\n- Vocal (u), {conteo} veces repetidas"
    
    return resultado

consulta = conteo_vocal(frase.lower())

if consulta != "" and consulta.count("-") == 1:
    print(f"La vocal que mas se repite en la palabra u oración ingresada, es:{consulta}")
elif consulta != "" and consulta.count("-") > 1:
    print(f"Las vocales que mas se repite en la palabra u oración ingresada, son:{consulta}")
else:
    print("La palabra u oración ingresada, no contiene vocales.")
