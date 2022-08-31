#package com.mouredev.weeklychallenge2022
#
#/*
# * Reto #35
# * BATALLA POKÉMON
# * Fecha publicación enunciado: 29/08/22
# * Fecha publicación resolución: 06/09/22
# * Dificultad: MEDIA
# *
# * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémo#n.
# * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
# * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
# * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
# * - El programa recibe los siguientes parámetros:
# *  - Tipo del Pokémon atacante.
# *  - Tipo del Pokémon defensor.
# *  - Ataque: Entre 1 y 100.
# *  - Defensa: Entre 1 y 100.
# *
# * Información adicional:
# * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
# *   para preguntas, dudas o prestar ayuda a la comunidad.
# * - Tienes toda la información sobre los retos semanales en
# *   https://retosdeprogramacion.com/semanales2022.
# *
# */

#!/Usr/bin/python3

from colorama import Fore
from sys import argv

    
pokemon = {
    'tipo_agua' : {
         'tipo_fuego': 0.5,
         'tipo_electrico': 0.5,
         'tipo_planta': 1,
         'tipo_agua': 1
         },
    'tipo_fuego' : {
         'tipo_fuego': 1,
         'tipo_electrico': 0.5,
         'tipo_planta': 0.5,
         'tipo_agua': 1
         },
    'tipo_planta' : {
         'tipo_fuego': 0.5,
         'tipo_electrico': 0.5,
         'tipo_planta': 1,
         'tipo_agua': 1
         },
    
    'tipo_electrico' : {
         'tipo_fuego': 0.5,
         'tipo_electrico': 1,
         'tipo_planta': 2,
         'tipo_agua': 1
         }
    }

efectividad = {
    2: 'Efectividad total',
    1: 'Efectividad media',
    0.5: 'Efectividad reducida'
}


try:
    pokemon_A = argv[1].lower()
    pokemon_D = argv[2].lower()
    ataque = int(argv[3])
    defensa = int(argv[4])

    if ataque <= 0 or ataque >= 101:
        raise Exception
    
    if defensa <= 0 or defensa >= 101:
        raise Exception
    
    if pokemon_A not in pokemon.keys():
        raise Exception
    
    if pokemon_D not in pokemon.keys():
        raise Exception
except:
    print()
    print(Fore.RED + ' [!] No son los parametros esperados..\n')
    exit(1)

daño = pokemon[pokemon_A][pokemon_D]
damage_A = 50 * (ataque/defensa) * daño

print()
print(Fore.GREEN + '\t -> Resultado Lucha-Pokemon <-\n')
print(Fore.YELLOW + f' Ataca: ==> {pokemon_A.capitalize()} ->  Poder Ataque: {ataque}\n')
print(Fore.MAGENTA + f' Defiende: ==> {pokemon_D.capitalize()} ->  Poder Defensa: {defensa}\n')
print(Fore.RED + f' Daño Ataque: ==> {damage_A} -> ', efectividad[daño],'\n')
