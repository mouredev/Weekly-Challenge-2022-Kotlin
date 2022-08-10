#Reto semanal 32: Dado un listado de números, encuentra el SEGUNDO más grande.

def segundoMasGrande():
    listaNum=[85,20,74,96,150,5,24,3,152,120]
    numGrande = 0
    segundoGrande = 0
    for numero in listaNum:
        if numGrande <= numero:
            segundoGrande = numGrande
            numGrande = numero
        elif segundoGrande < numero:
            segundoGrande = numero
    print(segundoGrande)
segundoMasGrande()