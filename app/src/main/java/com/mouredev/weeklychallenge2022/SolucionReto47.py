# Reto #47
# VOCAL MÁS COMÚN
# Fecha publicación enunciado: 21/11/22
# Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
# Si no hay vocales podrá devolver vacío.
# Solución en python
# Propuesta por Manuel C.C.
# 


elTexto = 'En un lugar de la mancha cuyo nombre no quiero recordar vivia un hidalgoo'
#elTexto = 'XXYYZZ1234567890'
vocales = ['a','e','i','o','u']

def buscaVocal(miTexto):
    miTexto = miTexto.lower()
    laMaxima = ['',0]   # Elemento [0] es la vocal mas frecuente, elemento [1] es el número de repeticiones
    for vocal in vocales:
        cuantas = miTexto.count(vocal)
        print("De la vocal '%s' hay %i repeticiones." % (vocal, cuantas))
        if (cuantas >laMaxima[1]):
            laMaxima = [vocal,cuantas]
        elif (cuantas == laMaxima[1]):
            laMaxima = [laMaxima[0] + " y " + vocal, cuantas]
    if laMaxima[1]>0:
        return(laMaxima[0])
    else:
        return()

resultado = buscaVocal(elTexto)
if len(resultado) < 1:
    print("No hay vocales en el texto")
elif len(resultado) == 1:
    print("La vocal mas frecuente es la",resultado)
else:
    print("Las vocales mas frecuentes son",resultado)