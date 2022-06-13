# Modoc con For
def conteo_for(num: int):
    cadena = ''
    for i in range(num):            
        cadena += f'{1+i}, ' if (1+i) != num else f'{1+i}'
    return cadena

# Modo con While
def conteo_while(num: int):
    cadena = '' 
    i = 0
    while num != i:
        i+=1
        cadena += f'{i}, ' if i != num else f'{i}'
    return cadena

# Modo recursivo
def conteo_recursivo (num_1: int, num_2: int):
    return f'{num_2}, {conteo_recursivo(num_1, num_2+1)}' if num_2 != num_1 else f'{num_2}'

#write
print('Modo con For: '+conteo_for(100))
print('Modo con while : '+ conteo_while(100))
print('Modo con recursivo: '+ conteo_recursivo(100, 1))
