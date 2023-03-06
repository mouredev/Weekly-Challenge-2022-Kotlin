def es_lista_creciente(numeros):
    return len(numeros) > 1 and numeros == sorted(list(set(numeros)))


def numeros_perdidos_version_1(numeros):
    '''
    Versión estilo Python
    '''

    if not es_lista_creciente(numeros):
        raise ValueError('La lista de entrada no es estrictamente creciente')

    numeros_perdidos = set(range(numeros[0]+1, numeros[-1]))  # no se incluyen los extremos
    set_numeros = set(numeros)

    numeros_perdidos -= set_numeros  # resta de conjuntos

    return sorted(list(numeros_perdidos))


def numeros_perdidos_version_2(numeros):
    '''
    Versión híbrida estilo Python y estilo didáctico con comprensión de listas
    '''

    if not es_lista_creciente(numeros):
        raise ValueError('La lista de entrada no es estrictamente creciente')

    return [ numero for numero in range(numeros[0]+1, numeros[-1]) if numero not in numeros ]


def numeros_perdidos_version_3(numeros):
    '''
    Versión estilo didáctico
    '''

    if not es_lista_creciente(numeros):
        raise ValueError('La lista de entrada no es estrictamente creciente')

    numeros_perdidos = []

    for numero in range(numeros[0]+1, numeros[-1]):  # no se incluyen los extremos
        if numero not in numeros:
            numeros_perdidos.append(numero)

    return numeros_perdidos


if __name__ == '__main__':
    print(es_lista_creciente([1, 1, 3]))
    print(es_lista_creciente([1, 3, 2]))
    print(es_lista_creciente([1, 2, 3]))
    print(numeros_perdidos_version_1([1, 3, 4, 8]))
    print(numeros_perdidos_version_2([1, 3, 4, 8]))
    print(numeros_perdidos_version_3([1, 3, 4, 8]))