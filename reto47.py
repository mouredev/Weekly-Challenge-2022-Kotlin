#
# Reto #47
# VOCAL MAS COMUN
# Fecha publicación enunciado: 21/11/22
# Fecha publicación resolución: 28/11/22
# Dificultad: FACIL
#
# Enunciado: Crea un función que reciba un texto y retorne la vocal que
# más veces se repita.
# - Ten cuidado con algunos casos especiales.
# - Si no hay vocales podrá devolver vacío. 
#

def vocales_mas_repetidas(texto):

    # Cambiar vocales con tilde y diéresis
    vocal_con_tilde, vocal_sin_tilde = 'áéíóúü','aeiouu'
    sin_tilde = str.maketrans(vocal_con_tilde, vocal_sin_tilde)
    texto = texto.lower().translate(sin_tilde)
    
    # Crear un diccionario con las vocales y las veces que se repite
    lista_vocales = {}
    for letra in texto:
        if letra.lower() in vocal_sin_tilde:
            if letra.lower() not in lista_vocales:
                lista_vocales[letra.lower()] = 0   
            lista_vocales[letra.lower()] += 1     

    # Invertir la clave y el valor del diccionario lista_vocales en
    # la lista_final para encontrar los valores más repetidos
    lista_final = {}
    if len(lista_vocales) > 0:
        for letra, repetidos in lista_vocales.items():
            if repetidos not in lista_final:
                lista_final[repetidos] = []      
            lista_final[repetidos].append(letra)  

    return lista_final

if __name__ == '__main__':

    texto = "La física es el sistema operativo del Universo"

    lista_repetidos = (vocales_mas_repetidas(texto))
    mas_repetido = " "
    if len(lista_repetidos) > 0:
        mas_repetido = max(lista_repetidos)
        print(f"Lista de vocales repetidas: {lista_repetidos}")
        print(f"Vocal(es) que más se repite(n): {lista_repetidos[mas_repetido]}")
    else:
        print(f"No hay vocales en el texto {texto}")


# Resultado:       
# Lista de vocales repetidas: {4: ['a'], 5: ['i'], 6: ['e'], 3: ['o'], 1: ['u']}
# Vocal(es) que más se repite(n): ['e']