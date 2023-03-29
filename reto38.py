#
# Reto #38
# BINARIO A DECIMAL
# Fecha publicación enunciado: 19/09/22
# Fecha publicación resolución: 27/09/22
# Dificultad: MEDIA
# Enunciado: Crea un programa se encargue de transformar un número binario
# a decimal sin utilizar funciones propias del lenguaje que
# lo hagan directamente.
#

def binario_a_decimal(num_bin):
    num_dec = 0
    x = 0
    print("En Binario: ", num_bin)
    while (num_bin > 0):
        digito = num_bin % 10
        num_bin = int(num_bin // 10)
        num_dec = num_dec+digito * (2 ** x)
        x +=1

    print("\tEn decimal: ", num_dec)


if __name__ == '__main__':
    binario_a_decimal(10)
    binario_a_decimal(11001)
    binario_a_decimal(110000)


