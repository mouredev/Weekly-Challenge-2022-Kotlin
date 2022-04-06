package com.mouredev.weeklychallenge2022

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

numero = input('Introduce un número: ')
listaNumero = []
listaPotencias = []
suma = 0

if numero.isdigit() == True:
    
    # Aquí necesito que 'numero' sea una cadena de texto para medirla
    digitos = len(numero)

    # Paso cada caracter de 'numero' a una lista que pueda iterar
    for i in numero:
        listaNumero.append(i)

    # Convierto cada caracter de la lista en un entero con el que pueda calcular
    # y realizo el cálculo de las potencias
    
    for j in listaNumero:
        jInt = int(j)
        potencia = jInt ** digitos
        listaPotencias.append(potencia)
    
    for n in listaPotencias:
        suma = suma + n

    numeroInt = int(numero)

    if numeroInt == suma:
      print(f'El número {numero} es un número de Armstrong')

    else:
      print(f'El número {numero} no es un número de Armstrong')

else:
    print(f'El número {numero} no es válido o no es un número')
