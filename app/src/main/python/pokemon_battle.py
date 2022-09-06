import random


### Reto #35
### BATALLA POKÉMON
### Fecha publicación enunciado: 29/08/22
### Fecha publicación resolución: 06/09/22
### Dificultad: MEDIA
###
### Enunciado: Crea un programa que calcule el daño de un ataque durante
### una batalla Pokémon.
### - La fórmula será la siguiente: daño = 50 # (ataque / defensa) # efectividad
### - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
### - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico
###   (buscar su efectividad)
### - El programa recibe los siguientes parámetros:
###  - Tipo del Pokémon atacante.
###  - Tipo del Pokémon defensor.
###  - Ataque: Entre 1 y 100.
###  - Defensa: Entre 1 y 100.


poke_types = ["Water", "Fire", "Grass", "Thunder"]

poke_battle_info = {
    "attack_type": poke_types[random.randint(0, 3)],
    "attack": random.randint(1, 100),
    "defense": random.randint(1, 100),
    "defense_type": poke_types[random.randint(0, 3)],
}


def poke_battle(info):

    effectivity_info = {
        "Water": {"superEffective": "Fire", "weak": "Thunder"},
        "Fire": {"superEffective": "Grass", "weak": "Water"},
        "Grass": {"superEffective": "Thunder", "weak": "Fire"},
        "Thunder": {"superEffective": "Water", "weak": "Grass"},
    }

    print(f"{info}")

    effectivity = effectivity_info[info["attack_type"]]
    effectivity_calc = (
        2
        if effectivity["superEffective"] == info["defense_type"]
        else 0.5
        if effectivity["weak"] == info["defense_type"]
        else 1
    )
    effectivity_msg = (
        "Super Effective"
        if effectivity_calc == 2
        else "Neutral"
        if effectivity_calc == 1
        else "No Effective"
    )

    calculate_dmg = "{:.2f}".format(
        50 * (info["attack"] / info["defense"]) * effectivity_calc
    )

    print(
        f"Pokemon {info['attack_type']} is attacking to {info['defense_type']} with {effectivity_msg} attack dealing {calculate_dmg}"
    )


poke_battle(poke_battle_info)
