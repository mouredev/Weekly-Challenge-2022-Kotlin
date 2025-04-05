"""
#8-DECIMAL A BINARIO
/*
 * Crea un programa se encargue de transformar un número
 * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 */

 Iterando cadena al revés. Haciendo uso de [::-1] se puede iterar la lista desde el último al primer elemento.

texto = "Python"
for i in texto[::-1]:
    print(i) #n,o,h,t,y,P
Itera la cadena saltándose elementos. Con [::2] vamos tomando un elemento si y otro no.

texto = "Python"
for i in texto[::2]:
    print(i) #P,t,o

"""

def decimal_to_binary(decimal_number: int):
    decimal_num = decimal_number
    binary = ""
    binary_result = ""

    # Mientras el número sea diferente de 0, lo divide por 2 y añade el módulo a un String
    while decimal_number != 0:
        modulo = decimal_number % 2
        decimal_number = decimal_number // 2
        binary += str(modulo)

    # Invierte el String para obtener el resultado final
    for i in binary[::-1]:
        binary_result += i

    # Retorna el Resultado
    print(f"El numero decimal {decimal_num}, en binario es {binary_result}.")


# Test
decimal_to_binary(7)