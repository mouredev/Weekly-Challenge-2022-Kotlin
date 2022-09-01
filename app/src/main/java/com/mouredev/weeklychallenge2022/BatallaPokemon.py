 # Enunciado Reto #35: Crea un programa que calcule el daño de un ataque durante
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


def batallaPokemon(tipoAtaque, tipoDefensa, ataque, defensa):
    tipos =["Agua","Fuego","Planta","Electrico"]

    tipoAtaqueCorrecto = tipos.__contains__(tipoAtaque)
    tipoDefensaCorrecto = tipos.__contains__(tipoDefensa)

    if tipoAtaqueCorrecto == True and tipoDefensaCorrecto == True:
        if tipoAtaque == "Agua":
            if tipoDefensa == "Agua" or tipoDefensa == "Planta":
                efectividad = 0.5
            elif tipoDefensa == "Fuego":
                efectividad = 2
            elif tipoDefensa == "Electrico":
                efectividad = 1
        elif tipoAtaque == "Fuego":
            if tipoDefensa == "Agua" or tipoDefensa == "Fuego":
                efectividad = 0.5
            elif tipoDefensa == "Electrico":
                efectividad = 1
            elif tipoDefensa == "Planta":
                efectividad = 2
        elif tipoAtaque == "Planta":
            if tipoDefensa == "Planta" or tipoDefensa == "Fuego":
                efectividad = 0.5
            elif tipoDefensa == "Electrico":
                efectividad = 1
            elif tipoDefensa == "Agua":
                efectividad = 2
        elif tipoAtaque == "Electrico":
            if tipoDefensa == "Planta" or tipoDefensa == "Electrico":
                efectividad = 0.5
            elif tipoDefensa == "Fuego":
                efectividad = 1
            elif tipoDefensa == "Agua":
                efectividad = 2

        daño = 50 * (ataque/defensa) * efectividad

        print("El daño del Pokemon de %s al Pokemon de %s será de %d puntos de salud."%(tipoAtaque,tipoDefensa,daño))

    elif tipoAtaqueCorrecto == False and tipoDefensaCorrecto == True:
        print("El tipo del Pokemon atacante es incorrecto.")
    elif tipoDefensaCorrecto == False and tipoAtaqueCorrecto == True:
        print("El tipo del Pokemon defenivo es incorrecto.")
    else:
        print("Los tipos de los Pokemon atacante y defensivo son incorrectos.")

batallaPokemon("Tierra","Fuego",70,55) # Error Tipo de Ataque
batallaPokemon("Agua","Dragon",50,65) # Error Tipo de Defensa
batallaPokemon("Hielo","Hada",85,25) # Error de los dos Tipos
batallaPokemon("Agua","Fuego",35,65) # Efectividad x2
batallaPokemon("Planta","Fuego",70,5) # Efectividad x0.5
batallaPokemon("Electrico","Fuego",45,55) # Efectividad x1