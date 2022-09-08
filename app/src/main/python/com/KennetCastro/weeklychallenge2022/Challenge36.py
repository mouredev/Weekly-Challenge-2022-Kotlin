
# Solución Reto #36 Python

'''
Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas
leales a Sauron contra otras bondadosas que no quieren que el mal
reine sobre sus tierras. 

Cada raza tiene asociado un "valor" entre 1 y 5: 
- Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
  Númenóreanos (4), Elfos (5) 
- Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
  Huargos (3), Trolls (5) 

Crea un programa que calcule el resultado de la batalla entre los 2
tipos de ejércitos: 
- El resultado puede ser que gane el bien, el mal, o exista un empate.
  Dependiendo de la suma del valor del ejército y el número de
  integrantes. 
- Cada ejército puede estar compuesto por un número de integrantes
  variable de cada raza. 
- Tienes total libertad para modelar los datos del ejercicio. 

Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco,
3 Pelosos ganan a 1 Orco.
'''
from random import randint

class Army:
    def __init__(self,army_type: str, races: list):
        KIND = {'Pelosos': 1, 'Sureños': 2, 'Enanos': 3,
                'Númenóreanos': 4, 'Elfos': 5}
        EVIL = {'Sureños': 2, 'Orcos': 2, 'Goblins': 2,
                    'Huargos': 3, 'Trolls': 5}

        self.soldiers = {}
        self.total_soldiers = 0
        self.strengths = {}
        self.total_strength = 0
        self.army_type = army_type
        for race in races:
            self.soldiers[race] = randint(1, 100)
            self.total_soldiers += self.soldiers[race]
            if army_type.lower() == 'kind':
                if race in KIND:
                    self.strengths[race] = self.soldiers[race]*KIND[race]
            else:
                if race in EVIL:
                    self.strengths[race] = self.soldiers[race]*EVIL[race]
            self.total_strength += self.strengths[race]
    
    def __info(self,info_type, data, total):
        army = [info_type]
        for key, value in data.items():
            army.append(f'{key}: {value},')
        army.append(f'Total: {total}')
        army = ' '.join(army)
        return army

    def get_statistics(self):
        return self.__info('Strength:', self.strengths, self.total_strength)

    def get_poputation(self):
        return self.__info('Soldiers:', self.soldiers, self.total_soldiers)


def figth(army1: Army, army2: Army):
    if army1.total_strength > army2.total_strength:
        return "Termina bien"
    elif army1.total_strength < army2.total_strength:
        return "Termina mal"
    return "Empate"


buenos = Army('Kind', ['Sureños', 'Enanos', 'Elfos'])
malos = Army('Evil', ['Sureños', 'Orcos', 'Goblins', 'Huargos'])

for army in [buenos, malos]:
    print(f'{army.army_type} Army')
    print(army.get_poputation())
    print(army.get_statistics())
    print()

print(f'Batalla: {figth(buenos, malos)}')

