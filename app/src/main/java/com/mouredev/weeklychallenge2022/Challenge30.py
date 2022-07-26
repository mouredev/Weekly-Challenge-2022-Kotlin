#!/usr/bin/python3
# -*- coding: utf-8 -*-

#  Reto #30
#  MARCO DE PALABRAS
#  Fecha publicación enunciado: 26/07/22
#  Fecha publicación resolución: 01/08/22
#  Dificultad: FÁCIL
# 
#  Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
#  un marco rectangular de asteriscos.
#  - ¿Qué te parece el reto? Se vería así:
#    **********
#    * ¿Qué   *
#    * te     *
#    * parece *
#    * el     *
#    * reto?  *
#    **********
# 
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.

def frameText(string: str, frame: str):
    frames = {
        'asteriscos': {
            'esq1': '**',
            'esq2': '**',
            'esq3': '**',
            'esq4': '**',
            'izq': '* ',
            'der': ' *',
            'hor': '*'
        },
        'lineas': {
            'esq1': '╔═',
            'esq2': '═╗',
            'esq3': '╚═',
            'esq4': '═╝',
            'izq': '║ ',
            'der': ' ║',
            'hor': '═'
        }
    }

    vecString = string.split()
    maxLong = 0

    for word in vecString:
        if len(word) > maxLong:
            maxLong = len(word)
    
    print(frames[frame]['esq1']+(frames[frame]['hor']*maxLong)+frames[frame]['esq2'])
    for word in vecString:
        print(frames[frame]['izq']+word+(' '*(maxLong-len(word)))+frames[frame]['der'])
    print(frames[frame]['esq3']+(frames[frame]['hor']*maxLong)+frames[frame]['esq4'])

if __name__ == '__main__':
    text = input('Introduce tu frase para enmarcar: \n >> ')
    print()
    frameText(text, 'asteriscos')
    print()
    frameText(text, 'lineas')
    print()
