#!/usr/bin/python3
# -*- coding: utf-8 -*-

# Reto #35
# BATALLA POKÉMON
# Fecha publicación enunciado: 29/08/22
# Fecha publicación resolución: 06/09/22
# Dificultad: MEDIA
#
# Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
# - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
# - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
# - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
# - El programa recibe los siguientes parámetros:
#  - Tipo del Pokémon atacante.
#  - Tipo del Pokémon defensor.
#  - Ataque: Entre 1 y 100.
#  - Defensa: Entre 1 y 100.

from sys import argv

# https://www.pokexperto.net/index2.php?seccion=general/efec
tipos_efectividad = {
    'agua': {
        'agua': 0.5,
        'fuego': 2,
        'planta': 0.5,
        'electrico': 1
        },
    'fuego': {
        'agua': 0.5,
        'fuego': 0.5,
        'planta': 2,
        'electrico': 1
        },
    'planta': {
        'agua': 2,
        'fuego': 0.5,
        'planta': 0.5,
        'electrico': 1
        },
    'electrico': {
        'agua': 2,
        'fuego': 1,
        'planta': 0.5,
        'electrico': 0.5
        }
    }

efect_strings = {
    2: 'Es SUPER-EFECTIVO!',
    1: 'Efecto Normal',
    0.5: 'No es muy efectivo...'
}

try:
    pokAtaca = argv[1].lower()
    pokDefiende = argv[2].lower()
    ataque = int(argv[3])
    defensa = int(argv[4])

    if ataque < 1 or ataque > 100:
        raise Exception
    if defensa < 1 or defensa > 100:
        raise Exception
    if pokAtaca not in tipos_efectividad.keys():
        raise Exception
    if pokDefiende not in tipos_efectividad.keys():
        raise Exception
except:
    print('ERROR: Parámetros inválidos')
    exit()

efectividad = tipos_efectividad[pokAtaca][pokDefiende]
damage = 50 * (ataque / defensa) * efectividad

print()
print('Ataque Pokemon')
print('==============')
print(f'Ataca:    {pokAtaca.capitalize()} - ATK: {ataque}')
print(f'Defiende: {pokDefiende.capitalize()} - DEF: {defensa}')
print(f'Daño: {damage} -', efect_strings[efectividad])
print()
