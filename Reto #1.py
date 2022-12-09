'''/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.'''


# Función que pasa las palabras a dos listas con los bucles.
def anagrama (palabra1,palabra2):
    conja = []
    conjb = []

    for i in palabra1:
        conja.append(i)
    for i in palabra2:
        conjb.append(i)
    # Este bucle elimina el "conjb" si son las mismas letras que el "conja"
    for i in conja:
        # Excepcion que resuelve el error al intentar remover las letras de "conja"
        #  en "conjb" ya que no podemos borrar elementos no existentes.
        try:
            conjb.remove(i)
        except ValueError:
            continue
    # Condicional que retornara False o True si la lista "conjb" esta vacia,
    # queriendo esto decir que las dos listas eran iguales pero no la misma palabra.
    if palabra1 == palabra2:
        return False
    elif len(conjb) == 0:
        return True
    else:
        return False

# Aquí recogemos las dos palabras e imprimimos la solución.
palabra1 = input('Escribe una palabra: ')
palabra2 = input('Escribe otra palabra: ')
print('¿Son las palabras anagramas? -> ', anagrama(palabra1,palabra2))
