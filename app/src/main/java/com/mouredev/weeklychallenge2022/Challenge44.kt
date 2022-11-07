#* Enunciado: Crea una función que retorne el número total de bumeranes de 
#* un array de números enteros e imprima cada uno de ellos.
#* - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
#*   seguidos, en el que el primero y el último son iguales, y el segundo
#*   es diferente. Por ejemplo [2, 1, 2].
#* - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] 
#*   y [4, 2, 4]).

def sequence(initList):
    init = 0
    for i, num in enumerate(initList):
        if i == init:
            try:
                if initList[init] != initList[init+1] and initList[init] == initList[init+2]:
                    boomerangList.append(initList[init:init+3])
                    init = i+3
                else:
                    init+=1
            except:
                pass
    return(len(boomerangList))

initList = [2, 1, 2, 3, 3, 4, 2, 4]
boomerangList = []    
print(f'En el array {initList} hay {sequence(initList)} bumeranes ({boomerangList})')
