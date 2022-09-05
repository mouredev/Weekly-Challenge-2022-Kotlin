# Reto #35
# BATALLA POKÉMON
# Fecha publicación enunciado: 29/08/22
# Fecha publicación resolución: 06/09/22
# Dificultad: MEDIA
# Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
# - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
# - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
# - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
# - El programa recibe los siguientes parámetros: 
# - Tipo del Pokémon atacante.
# - Tipo del Pokémon defensor.
# - Ataque: Entre 1 y 100.
# - Defensa: Entre 1 y 100.

water = list("tipo" = "agua", 
             "superEfective" = "fuego",
             "neutral" = "planta",
             "nonEfective" = "electrico")

fire = list("tipo" = "fuego", 
            "superEfective" = "planta",
            "neutral" = "electrico",
            "nonEfective" = "agua")

electric = list("tipo" = "electrico", 
                "superEfective" = "agua",
                "neutral" = "fuego",
                "nonEfective" = "planta")

plant = list("tipo" = "planta", 
             "superEfective" = "agua",
             "neutral" = "electrico",
             "nonEfective" = "fuego")

attack <- function() {
  round(runif(1, 1, 100),0)
}

defense <- function() {
  round(runif(1, 1, 100),0)
}

pokemonBattle <- function(attacker, defender, attPoints, defPoints) {
  if (attacker$superEfective == defender$tipo) {
    efectividad = 2
  }
  else if (attacker$neutral == defender$tipo) {
    efectividad = 1
  }
  else
    efectividad = 0.5
  
  damage = round(50 * (attPoints / defPoints) * efectividad, 0)
  
  print(paste("BATALLA :", attacker$tipo, "vs", defender$tipo))
  print(paste("Ataque :", attPoints, "Defensa :", defPoints))
  print(paste("Efectividad :", efectividad))
  print(paste("Daño infringido :", damage))
}

pokemonBattle(electric, fire, attack(), defense())
pokemonBattle(water, fire, attack(), defense())
pokemonBattle(fire, plant, attack(), defense())
pokemonBattle(plant, electric, attack(), defense())
pokemonBattle(water, plant, attack(), defense())
pokemonBattle(electric, water, attack(), defense())
pokemonBattle(fire, water, attack(), defense())




