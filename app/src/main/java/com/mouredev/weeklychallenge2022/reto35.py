"""
 * Enunciado: Crea un programa que calcule el daño de un ataque durante
 * una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico 
 *   (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
"""
from re import X


pokemon_type = {"agua":0, "fuego":1, "planta":2, "electrico":3}

poke_attack_type = input ("Tipo del Pokémon atacante (Agua, Fuego, Planta o Electrico): ")
poke_attack_power = int(input ("Ataque(entre 1 y 100): "))
poke_defense_type = input ("Tipo del Pokémon defensor (Agua, Fuego, Planta o Electrico): ")
poke_defense_power = int(input ("Defensa (entre 1 y 100): "))

poke_attack_type = poke_attack_type.lower()
poke_defense_type = poke_defense_type.lower()

def efectividad (ataque,defensa):

    if defensa == "agua":
        efectividad_0 = (0.5,0.5,2,2)
        x = pokemon_type[ataque]
        return efectividad_0[x]
    
    if defensa == "fuego":
        efectividad_1 = (2,0.5,0.5,1)
        x = pokemon_type[ataque]
        return efectividad_1[x]

    if defensa == "planta":
        efectividad_2 = (0.5,2,0.5,0.5)
        x = pokemon_type[ataque]
        return efectividad_2[x]

    if defensa == "electrico":
        efectividad_3 = (1,1,1,0.5)
        x = pokemon_type[ataque]
        return efectividad_3[x]

dano = 50 * ((poke_attack_power/poke_defense_power)) * efectividad(poke_attack_type,poke_defense_type)
print (f"El daño en este ataque es de {dano}")