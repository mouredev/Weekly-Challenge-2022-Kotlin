 # Reto 32
 # EL SEGUNDO
 # Fecha publicación enunciado: 08/08/22
 # Fecha publicación resolución: 15/08/22
 # Dificultad: FÁCIL
 #
 # Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.

listado = []  # Declaración de la lista

while True:
    try:
        numero = int(input("Introduce un número  \"0 \" para terminar..."))
        listado.append(numero)
    except(ValueError):
        break

for i in range(len(listado)):
    for j in range(len(listado)):
        if listado[i] > listado[j]:
            pasavalor = listado[i]
            listado[i] = listado[j]
            listado[j] = pasavalor

print("El número buscado es ", listado[1])