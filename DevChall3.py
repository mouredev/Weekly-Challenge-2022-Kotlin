'''
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
'''
for i in range(1,101):
    if i < 2:
        print(i, 'no es primo')
    else:
        es_primo = True
        for n in range(2, i):
            if i % n == 0:
                es_primo = False
        if es_primo:
            print(i, 'es primo')
        else:
            print(i, 'no es primo')
