def trianguloPascal (dim):
    filas = dim
    columnas = (2 * dim) + 1
    matriz = matriz = [[int( ) for ind0 in range(columnas)] for ind1 in range(filas)]
    matriz[0][5] = 1
    posicionAnt = matriz[0][0]
    posicionProx = matriz[0][2]
    cont1 = 0
    cont2 = 0
    
    for i in range(1, filas):
        for k in range(columnas) :
            matriz[i][k] = posicionAnt + posicionProx
            posicionAnt = matriz[i-1][0 + cont1]
            posicionProx = matriz[i-1][2 + cont2]
            cont1 += 1
            if cont2 < columnas - 3:
                cont2 += 1
        cont1 = 0
        cont2 = 0
    
    for i in range(filas):
        for j in range(columnas):
            print(matriz[i][j], end=" ")
        print(" ")

dim = int(input())
trianguloPascal(dim)
