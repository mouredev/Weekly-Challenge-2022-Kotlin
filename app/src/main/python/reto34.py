'''
 Enunciado: Dado un array de enteros ordenado y sin repetidos, 
 crea una función que calcule y retorne todos los que faltan entre
 el mayor y el menor.
 - Lanza un error si el array de entrada no es correcto.
 '''

numbers = [1,3,4,6]

for i in range(len(numbers)-1):
    if type(numbers[i]) != int:
        print(f'La lista numbers contiene elementos que no son enteros')
        exit()

if numbers == sorted(numbers) and len(numbers) == len(set(numbers)):
    for i in range(len(numbers)-1):
        if type(numbers[i]) == int:
            if numbers[i] != numbers[i+1]-1:
                print(f'Falta elemento igual a: {numbers[i]+1}')
        else:
            print("Hay elementos que no son enteros")
else:
    print('La lista contiene elementos repetidos o no es una lista ordenada')