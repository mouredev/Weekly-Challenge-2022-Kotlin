# package com.mouredev.weeklychallenge2022
import random
from random import randint
from datetime import datetime

'''
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
'''

from abc import ABC
from abc import abstractmethod

class Raza(ABC):
    def __init__(self, fuerza):
        self.__fuerza = fuerza

    @property
    def fuerza(self):
        return self.__fuerza

    @property
    @abstractmethod
    def leal_a_sauron(self) -> bool:
        pass

    def __str__(self):
        return f"{type(self).__name__} Fuerza: {self.__fuerza}"

# Razas bondadosas
class Peloso(Raza):
    def __init__(self):
        super().__init__(1)

    @property
    def leal_a_sauron(self):
        return False

class SurenioBueno(Raza):
    def __init__(self):
        super().__init__(2)

    @property
    def leal_a_sauron(self):
        return False

class Enano(Raza):
    def __init__(self):
        super().__init__(3)

    @property
    def leal_a_sauron(self):
        return False

class Numenoreano(Raza):
    def __init__(self):
        super().__init__(4)

    @property
    def leal_a_sauron(self):
        return False

class Elfo(Raza):
    def __init__(self):
        super().__init__(5)

    @property
    def leal_a_sauron(self):
        return False

# Razas malvadas
class SurenioMalo(Raza):
    def __init__(self):
        super().__init__(2)

    @property
    def leal_a_sauron(self):
        return True

class Orco(Raza):
    def __init__(self):
        super().__init__(2)

    @property
    def leal_a_sauron(self):
        return True

class Goblin(Raza):
    def __init__(self):
        super().__init__(2)

    @property
    def leal_a_sauron(self):
        return True

class Huargo(Raza):
    def __init__(self):
        super().__init__(3)

    @property
    def leal_a_sauron(self):
        return True

class Troll(Raza):
    def __init__(self):
        super().__init__(5)

    @property
    def leal_a_sauron(self):
        return True

class Guerra:
    def __init__(self, buenos, malvados):
        self.__buenos = buenos
        self.__malvados = malvados

    def __sumar_fuerzas(self, ejercito):
        sum = 0
        for e in ejercito:
            sum += e.fuerza
        return sum

    def calcular_victoria(self):
        fuerza_buenos = self.__sumar_fuerzas(self.__buenos)
        fuerza_malvados = self.__sumar_fuerzas(self.__malvados)
        
        if(fuerza_buenos > fuerza_malvados):
            print("Los buenos ganan!")
        elif(fuerza_buenos < fuerza_malvados):
            print("Los malos ganan!")
        else:
            print("Empate!")
    

RAZAS_BUENAS = (Peloso, SurenioBueno, Enano, Numenoreano, Elfo)
RAZAS_MALVADAS = (SurenioMalo, Orco, Goblin, Huargo, Troll)

def main(): 
    buenos = []
    malvados = []
    random.seed(datetime.now())
    cantidad_buenos = randint(80, 150)
    cantidad_malvados = randint(80, 150)
    for i in range(cantidad_buenos):
        buenos.append(random.choice(RAZAS_BUENAS)())

    for i in range(cantidad_malvados):
        malvados.append(random.choice(RAZAS_MALVADAS)())

    guerra = Guerra(buenos, malvados)
    guerra.calcular_victoria()
    
if __name__ == "__main__":
    main()