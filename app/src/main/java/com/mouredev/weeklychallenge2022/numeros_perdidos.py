""" Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función 
que calcule y retorne todos los que faltan entre el mayor y el menor. Lanza un error 
si el array de entrada no es correcto. """


def recuperar_numeros_perdidos(entrada):
    # Comprobar que todos los elementos son enteros, están ordenados y no hay repetidos
    for elemento in entrada:
        if not isinstance(elemento, int):
            return "Error. Al menos un valor no es de tipo entero."
        if entrada.count(elemento) > 1:
            return "Error. Al menos un valor está repetido."
        if elemento != entrada[0] and elemento <= elemento_antiguo:
            return "Error. Valores no ordenados"
        elemento_antiguo = elemento

    # Rellenar con números faltantes
    j = min(entrada)
    salida = []
    while j <= max(entrada):
        salida.append(j)
        j += 1
    return salida


# Array de entrada. Coloca los valores que quieras
entrada = [0, 1, 9, 17, 23]
print(recuperar_numeros_perdidos(entrada))
