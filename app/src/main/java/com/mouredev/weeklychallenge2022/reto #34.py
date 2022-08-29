# Reto de programacion 34
# Daniel Patiño Rojas
# Github: https://github.com/Denaill
# Lenguaje Python

length = input("Tamaño del vector -> ")
vector = [0] * int(length)

for pos in range(int(length)):
    vector[pos] = input("Posicion " + str(pos) + " -> ")

for x in range(int(length) - 1):
    for y in range(int(length) - 1):
        if int(vector[y]) > int(vector[y + 1]):
            temp = vector[y]
            vector[y] = vector[y + 1]
            vector[y + 1] = temp

minpos = vector[0]
maxpos = int(vector[len(vector) - 1])
occurrency = False

while (int(maxpos) != int(minpos)):
    maxpos -= 1
    for pos in range(int(length)):
        if maxpos == int(vector[pos]):
            ocurrency = True
            break
        else:
            ocurrency = False
    if ocurrency == False:
        print("Falta el numero -> " + str(maxpos))
