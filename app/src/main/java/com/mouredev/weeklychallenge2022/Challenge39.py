# Reto #39
# TOP ALGORITMOS: QUICK SORT
# Fecha publicación enunciado: 27/09/22
# Fecha publicación resolución: 03/10/22
# Dificultad: MEDIA
# 
# Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
# creado por C.A.R. Hoare.
# - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
#   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
#   no únicamente a copiar su implementación.
# - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
#   los más famosos de la historia.
# 
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.

def quicksort(list, low, high):
    if(low < high):
        i = partition(list, low, high)
        quicksort(list, low, i - 1)
        quicksort(list, i + 1, high)

def partition(list, low, high):
    p = list[high]
    i = low - 1
    for j in range(low, high - 1):
        if(list[j] < p):
            i +=1
            swap(list, i, j)

    swap(list, i + 1, high)
    return i + 1

def swap(list, i, j):
    aux = list[i]
    list[i] = list[j]
    list[j] = aux



list = [1, 5, 2, 8, 6, 0, 30, 76, 80, 20]

#Imprimo la lista inicial sin ordenar
print(list)
#Llamo a la función para ordenar
quicksort(list, 0, len(list) - 1)
#Imprimo la lista final ordenada
print(list)