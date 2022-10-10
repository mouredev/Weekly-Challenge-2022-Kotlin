#!/usr/bin/python3
# -*- coding: utf-8 -*-

# Reto #40
# TRIÁNGULO DE PASCAL
# Fecha publicación enunciado: 03/10/22
# Fecha publicación resolución: 10/10/22
# Dificultad: MEDIA

from sys import argv


def drawPascal(side):
    row = [1]
    print()
    for i in range(side):
        print('  '*(side-i), end='')
        for item in row:
            print(f'{item:3}', end=' ')
        print()

        newRow = [1]
        for i in range(len(row)-1):
            newRow.append(row[i]+row[i+1]) 
        newRow.append(1)
        row = newRow
    print()


if __name__ == '__main__':
    try:
        n = int(argv[1])
        if (n < 1) or (n > 20): #Limitado a lado 20
            raise Exception
        drawPascal(n)
    except:
        print('ERROR: parámetros erróneos')