import random

def merge_sort(list):
    if len(list)>1:
        medio=len(list)//2
        izquierda=list[:medio]
        derecha=list[medio:]
        print(izquierda,"*"*5,derecha)

        #Llamada recursiva en cada mitad
        merge_sort(izquierda)
        merge_sort(derecha)

        #Iteradores para recorrer las dos sublistas
        i=0
        j=0
        #Iterador para la lista principal
        k=0

        while i<len(izquierda) and j<len(derecha):
            if izquierda[i]<derecha[j]:
                list[k]=izquierda[i]
                i+=1
            else:
                list[k]=derecha[j]
                j+=1

            k+=1
        while i<len(izquierda):
            list[k]=izquierda[i]
            i+=1
            k+=1
        while j<len(derecha):
            list[k]=derecha[j]
            j+=1
            k+=1

        print(f"izquierda {izquierda}, derecha {derecha}")
        print(list)
        print("-"*50)
    return list


if __name__=="__main__":

    list_size=int(input("What is the size of the list?"))

    list=[random.randint(0,100) for i in range(list_size)]
    print(list)
    print("-" * 20)

    ordered_list=merge_sort(list)
    print(ordered_list)