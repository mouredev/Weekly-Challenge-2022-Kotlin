'''
/*
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
*/
'''

from dataclasses import dataclass
from enum import Enum,auto


def run():
    pass

class tipoPokemon(Enum):
    AGUA,FUEGO,PLATA,ELECTRICO=range(4)


@dataclass
class pokemon():
    tipo:tipoPokemon
    ATQ:int
    DEF:int
    
    def __post_init__(self) -> None:
        assert self.ATQ<=100 and self.ATQ>0,"REVISAR ATAQUE POKEMON ENTRE 0 - 100"
        assert self.DEF<=100 and self.DEF>0,"REVISAR DEFENSA POKEMON ENTRE 0 - 100"
        
Tipos = [
    
    {
        "Tipo":"AGUA",
        "FUEGO":2,
        'PLANTA':0.5,
        'ELECTRICO':1,
        'AGUA':0.5,
        
    },
    {
        'Tipo':'FUEGO',
        "AGUA":0.5,
        'PLANTA':2,
        'ELECTRICO':1,
        'FUEGO':0.5,
        
    },
        {
        'Tipo':'PLANTA',
        "AGUA":2,
        'PLANTA':0.5,
        'ELECTRICO':1,
        'FUEGO':0.5,
        
    },
        {
        'Tipo':'ELECTRICO',
        "AGUA":2,
        'PLANTA':0.5,
        'ELECTRICO':0.5,
        'FUEGO':1,
        
    }
]


squirtle = pokemon(tipo=tipoPokemon.AGUA,ATQ=100,DEF=40)
#print(squirtle.tipo.name)

def peleaPokemon(tipo:str,ATQ:int,tipo2:str,DEF:int):
    if(0<ATQ<=100) and (0<DEF<=100):
        poke = next(filter(lambda tipoPokemon: tipoPokemon['Tipo'] == tipo, Tipos))
        efecto = float(poke[tipo2])
        dano = 50 * (ATQ / DEF) * efecto
        text_final = f'y es superefectivo' if efecto==2 else (f'y no es muy efectivo' if efecto==0.5 else f'')
        print(f'El ataque ha causado {dano} de daño {text_final}')
    else:
        print(f'El ataque o defensa no pueden ser mayores a 100 o menores a 0')

    
peleaPokemon('AGUA',80,'FUEGO',20)
#print(Tipos[1]['Tipo'])


    

if __name__ == '__main__':run()