# 
# 
#  Enunciado: Dado un array de enteros ordenado y sin repetidos, 
#  crea una función que calcule y retorne todos los que faltan entre
#  el mayor y el menor.
#  - Lanza un error si el array de entrada no es correcto.
#

def perdidos(arr):
    prev= None
    n_arr = []
    for x in arr[::-1]:
        if prev != None:
            if prev<=x:
                raise Exception("Array no cumple con las condiciones")
            else:
                if(prev > x+1):
                    n_arr = n_arr + list(reversed(range(x+1,prev)))
        prev = x
    return n_arr

arr=[1,2,3,4,5,10,33,55,67,88]
print(arr)
print(perdidos(arr))
