import random


def damage_calculator(tipo_ataque, tipo_defensa, ataque, defensa):
    if (
        (tipo_ataque == "fuego" and tipo_defensa == "planta")
        or (tipo_ataque == "planta" and tipo_defensa == "agua")
        or (tipo_ataque == "agua" and tipo_defensa == "fuego")
        or (tipo_ataque == "electrico" and tipo_defensa == "agua")
    ):
        efectividad = 2
        print("Es muy eficaz")
    if (
        (tipo_ataque == "planta" and tipo_defensa == "planta")
        or (tipo_ataque == "planta" and tipo_defensa == "fuego")
        or (tipo_ataque == "agua" and tipo_defensa == "agua")
        or (tipo_ataque == "agua" and tipo_defensa == "planta")
        or (tipo_ataque == "fuego" and tipo_defensa == "fuego")
        or (tipo_ataque == "fuego" and tipo_defensa == "agua")
        or (tipo_ataque == "electrico" and tipo_defensa == "electrico")
        or (tipo_ataque == "electrico" and tipo_defensa == "planta")
    ):
        efectividad = 0.5
        print("No es muy eficaz")
    else:
        efectividad = 1
    return 50 * (ataque / defensa) * efectividad


def pokemon_type(pokemon):
    if pokemon == "Bulbasaur":
        tipo = "planta"
        caracteristica = random.randint(1, 100)
    if pokemon == "Charmander":
        tipo = "fuego"
        caracteristica = random.randint(1, 100)
    if pokemon == "Squirtle":
        tipo = "agua"
        caracteristica = random.randint(1, 100)
    if pokemon == "Pikachu":
        tipo = "electrico"
        caracteristica = random.randint(1, 100)
    return tipo, caracteristica


print("Pokémon disponibles:\n1. Bulbasaur\n2. Charmander\n3. Squirtle\n4. Pikachu\n")
print("Elige tu pokémon:")
pokemon = str(input())
print("Elige el pokémon rival:")
rival = str(input())

tipo_ataque, ataque = pokemon_type(pokemon)
tipo_defensa, defensa = pokemon_type(rival)

damage = damage_calculator(tipo_ataque, tipo_defensa, ataque, defensa)

print("Daño producido:", damage)
