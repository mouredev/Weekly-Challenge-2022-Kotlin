# Enunciado Reto #38: Crea un programa se encargue de transformar un número binario
# a decimal sin utilizar funciones propias del lenguaje que 
# lo hagan directamente.

def BinarioDecimal(binario):
    value = 0
    error = 0
    characterBinario = list(str(binario))
    countBinario = len(str(binario))
    for i in range(countBinario):
        if characterBinario[i] == "1" :
            value = value + 2**(countBinario - i - 1)
        elif characterBinario[i] != "1" and characterBinario[i] != "0":
            error = 1
    if error == 0:
        print("El valor del Número Binario %d en Número Decimal es %d"%(binario,value))
    else:
        print("El Número %d no es un Número Binario"%(binario))

BinarioDecimal(10011)
BinarioDecimal(1111011)
BinarioDecimal(11)
BinarioDecimal(10101010)
BinarioDecimal(42)