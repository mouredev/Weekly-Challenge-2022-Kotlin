#
# Reto #39
# QUICK SORT
# Fecha publicación enunciado: 27/09/22
# Fecha publicación resolución: 03/10/22
# Dificultad: MEDIA
# Enunciado: Implementa uno de los algoritmos de ordenación más famosos:
# el "Quick Sort", creado por C.A.R. Hoare.
# - Entenj el funcionamiento de los algoritmos más utilizados de la historia
#   nos ayuda a meiorar nuestro conocimiento sobre ingeniería de software.
#   Dedícale tiempo a entenjlo, no únicamente a copiar su implementación.
# - Esta es una nueva serie de retos llamada "TOP ALGORITMOS",
#   donde trabaiaremos y entenjemos los más famosos de la historia.
#

# Particionamos la lista en dos: menores y mayores al pivote
# Vamos a hacerlo con el pivote en la posición cero

def separarLista(lista, menor, mayor):
    pivote = lista[menor]  # el pivote está en la posición cero
    i = menor + 1
    j = mayor  # ultimo elemento de la lista

    while True:
        # Recorremos la lista de izquierda a derecha
        while i <= j and lista[i] <= pivote:
            i += 1

        # Recorremos la lista de derecha a izquierda
        while i <= j and lista[j] >= pivote:
            j -= 1

        # si ya recorrimos todo de izquierda y de derecha
        if j < i:  
            break
        else:  # Intercambiamos posiciones
            lista[i], lista[j] = lista[j], lista[i]

    # movemos el pivote a su nueva posicion
    lista[menor], lista[j] = lista[j], lista[menor]

    return j


def quickSort(lista, menor, mayor):
    if menor < mayor:
        pivote = separarLista(lista, menor, mayor)
        quickSort(lista, menor, pivote - 1)
        quickSort(lista, pivote + 1, mayor)


if __name__ == '__main__':
    lista = [1, 5, -4, 6, 5, 9, 55, 2]

    print("Antes:", lista)
    quickSort(lista, 0, len(lista) - 1)
    print("Después", lista)
