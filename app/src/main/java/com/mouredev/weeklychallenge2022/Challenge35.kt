# package com.mouredev.weeklychallenge2022

"""
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 """
 
 TYPE_TAB = {
        "water": {
            "water": 0.5,
            "fire": 2.0,
            "grass": 0.5,
            "electric": 1.0
        },
        "fire": {
            "water": 0.5,
            "fire": 0.5,
            "grass": 2.0,
            "electric": 1.0
        },
        "grass": {
            "water": 2.0,
            "fire": 0.5,
            "grass": 0.5,
            "electric": 1.0
        },
        "electric": {
            "water": 2.0,
            "fire": 1.0,
            "grass": 0.5,
            "electric": 0.5
        }
    }

class Pokemon:
    def __init__(self, pkmn_name, pkmn_type, pkmn_attack, pkmn_defense):
        self.pkmn_name = pkmn_name
        self.pkmn_type = pkmn_type
        self.pkmn_attack = pkmn_attack
        self.pkmn_defense = pkmn_defense

    """
    Calculates the effectiveness of an attack made by the pokemon to an opponent based on their types.
    opponent_pkmn: the pokemon that receives the attack
    returns: the weakness/resistance multiplicator of the attack
    """
    def __get_effectiveness(self, opponent_pkmn):
        return TYPE_TAB[self.pkmn_type][opponent_pkmn.pkmn_type]

    """
    Function that represents an attack. It calculates the damaged based on the types of both pokemon.
    opponent_pkmn: the pokemon which recieves the attack
    returns: the damage made by the attack
    """
    def attack(self, opponent_pkmn):
        return 50 * (self.pkmn_attack / opponent_pkmn.pkmn_defense) * self.__get_effectiveness(opponent_pkmn)

    def __str__(self):
        return f"{self.pkmn_name} Type: {self.pkmn_type}\nAttk: {self.pkmn_attack} Def: {self.pkmn_defense}"

    
def main():
    pikachu = Pokemon("Pikachu", "electric", 100.0, 50.0)
    blastoise = Pokemon("Blastoise", "water", 80.0, 250.0)
    charmander = Pokemon("Charmander", "fire", 75.0, 68.0)
    grovyle = Pokemon("Grovyle", "grass", 200.0, 78.0)

    print("===========================")
    print(pikachu)
    print("===========VS==============")
    print(blastoise)
    print("==========BEGIN============")

    print(f"{pikachu.pkmn_name} used thunderbolt!")
    print(f"{blastoise.pkmn_name} received {pikachu.attack(blastoise)} dmg!\n")

    print(f"{blastoise.pkmn_name} used surf!")
    print(f"{pikachu.pkmn_name} received {blastoise.attack(pikachu)} dmg!\n")

    print("===========================")
    print(grovyle)
    print("===========VS==============")
    print(blastoise)
    print("==========BEGIN============")

    print(f"{grovyle.pkmn_name} used leaf blade!")
    print(f"{blastoise.pkmn_name} received {grovyle.attack(blastoise)} dmg!\n")

    print(f"{blastoise.pkmn_name} used hydro pump!")
    print(f"{grovyle.pkmn_name} received {blastoise.attack(grovyle)} dmg!\n")

    print("===========================")
    print(grovyle)
    print("===========VS==============")
    print(charmander)
    print("==========BEGIN============")

    print(f"{grovyle.pkmn_name} used leaf blade!")
    print(f"{charmander.pkmn_name} received {grovyle.attack(charmander)} dmg!\n")

    print(f"{charmander.pkmn_name} used flamethrower!")
    print(f"{grovyle.pkmn_name} received {charmander.attack(grovyle)} dmg!\n")

if __name__ == "__main__":
    main()
