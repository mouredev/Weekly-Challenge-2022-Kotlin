
# Solución Reto #35 Python

'''
Enunciado: Crea un programa que calcule el daño de un ataque durante
una batalla Pokémon.

- La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
- Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
- Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico 
  (buscar su efectividad)
- El programa recibe los siguientes parámetros:
- Tipo del Pokémon atacante.
- Tipo del Pokémon defensor.
- Ataque: Entre 1 y 100.
- Defensa: Entre 1 y 100.
'''

from dataclasses import dataclass

@dataclass
class Pokemon:
    tipo: str
    fuerte: str
    debil: list
    ataque: int = 25
    defensa: int = 30


def crear_pokemon(mensaje: str) -> Pokemon:
    while True:
        tipo = input(mensaje).strip().title()

        match tipo:
            case "Agua":
                return Pokemon("Agua", "Fuego", ["Agua", "Planta"])
            case "Fuego":
                return Pokemon("Fuego", "Planta", ["Fuego", "Agua"])
            case "Planta":
                return Pokemon("Planta", "Agua", ["Planta", "Fuego"])
            case "Electrico":
                return Pokemon("Electrico", "Agua", ["Electrico", "Planta"])
            case _:
                print("No es un tipo valido  (Agua | Fuego | Planta | Electrico)")
                continue


def ingresar_dato(atr, name) -> None:
    try:
        dato = int(input(f"Valor de {name}: "))
        assert 100 >= dato >= 1, "Debe ser un valor entre 1 a 100"
        return dato
    except ValueError:
        return atr


def calcular_golpe(atacante: Pokemon, defensor: Pokemon) -> int:
    efectividad = 1
    efectivo = "Normal"

    if defensor.tipo == atacante.fuerte:
        efectividad = 2
        efectivo = "¡Super efectivo!"
    elif defensor.tipo in atacante.debil:
        efectividad = 0.5
        efectivo = "No es muy efectivo"

    return 50*(atacante.ataque/defensor.defensa)*efectividad, efectivo


def narrar(atacante: Pokemon, defensor: Pokemon) -> None:
    print(f"\nTipo {atacante.tipo} ataca a tipo {defensor.tipo}")
    
    golpe = calcular_golpe(atacante, defensor)
    
    print(f"Daño: {round(golpe[0])}")
    print(f"{golpe[1]}\n")


def batalla_pokemon():
    print(f"{'Batalla Pokémon':-^37}\n")
    atacante = crear_pokemon("Tipo del Pokémon atacante: ")
    defensor = crear_pokemon("Tipo del Pokémon defensor: ")
    
    atacante.ataque = ingresar_dato(atacante.ataque, "ataque")
    defensor.defensa = ingresar_dato(defensor.defensa, "defensa")
    
    narrar(atacante, defensor)
    

if __name__ == "__main__":
    while True:
        print()
        batalla_pokemon()
        if input("¿Desea probar otros tipos? (y|n): ") == "n":
            break

