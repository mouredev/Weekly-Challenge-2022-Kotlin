#
# Enunciado: Crea un programa que calcule el daño de un ataque durante
# una batalla Pokémon.
# - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
# - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
# - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico 
#   (buscar su efectividad)
# - El programa recibe los siguientes parámetros:
#  - Tipo del Pokémon atacante.
#  - Tipo del Pokémon defensor.
#  - Ataque: Entre 1 y 100.
#  - Defensa: Entre 1 y 100.
#

efecto = {
    2.0: "Super efectivo",
    1.0: "Neutral",
    0.5: "No es muy efectivo"
}

tabEfectividad = {
    "agua": {
        "agua": 0.5,
        "fuego": 2.0,
        "planta": 0.5,
        "electrico": 1.0
    },
    "fuego": {
        "agua": 0.5,
        "fuego": 0.5,
        "planta": 2.0,
        "electrico": 1.0
    },
    "planta": {
        "agua": 2.0,
        "fuego": 0.5,
        "planta": 0.5,
        "electrico": 1.0
    },
    "electrico": {
        "agua": 2.0,
        "fuego": 1.0,
        "planta": 0.5,
        "electrico": 0.5
    },
}

try:
    atacante = input(
        "Ingresa pokemon atacante: agua - fuego - planta - electrico\n")
    ataque = int(
        input("Ingresa número de ataque: numero entero entre 1 - 100\n"))
    defensor = input(
        "Ingresa pokemon defensor: agua - fuego - planta - electrico\n")
    defensa = int(
        input("Ingresa número de defensa: numero entero entre 1 - 100\n"))

    if atacante not in tabEfectividad.keys():
        raise Exception
    if ataque < 1 or ataque > 100:
        raise Exception
    if defensor not in tabEfectividad.keys():
        raise Exception        
    if defensa < 1 or defensa > 100:
        raise Exception
except:
    print("ERROR: en datos ingresados")
    exit()

efectividad = tabEfectividad[atacante][defensor]
print(efectividad)

danio = 50 * (ataque / defensa) * efectividad

print()
print("==============")
print("Ataque Pokemon")
print("==============")
print(f"Atacante: {atacante} - Ataque : {ataque}")
print(f"Defensor: {defensor} - Defensa: {defensa}")
print(f"Daño: {danio} -", efecto[efectividad])
