from collections import Counter
string_anagrama1 = "roma"
string_anagrama2 = "amoR"
string_anagrama1 = string_anagrama1.lower() #vuelve a ambas palabras a lower(minuscula)
string_anagrama2 = string_anagrama2.lower()
def anagrama():
    lista=cargar(string_anagrama1)#separa las letras para convertirlas en un list
    lista2=cargar(string_anagrama2)
    lista = sorted(lista)#Ordena los elementos en orden alfabetico
    lista2 = sorted(lista2)
    if lista == lista2: #Si ambas listas son iguales, es anagrama
        print(f"Las palabras {string_anagrama1} y {string_anagrama2} son anagrama")
    else:
        print(f"Las palabras {string_anagrama1} y {string_anagrama2} no son anagrama")
    
    
def cargar(string_palabra): #Separa las palabras en letras independientes para implementarlas en una lista
    int_contador = 0
    my_list = list()#declara la lista
    while int_contador < len(string_palabra):#while segun el largo de la palabra
        my_list.append(string_palabra[int_contador])#agrega a la lista el caracter de la posicion X
        int_contador += 1#hace avanzar al contador
    return my_list#devuelve la lista ya creada
def sort_names(names): #Ordena los elementos en orden alfabetico
   return sorted(names)#devuelve la lista ordenada
   
anagrama() #Ejecuta el codigo
