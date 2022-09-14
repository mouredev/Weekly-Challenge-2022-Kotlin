# Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales
# a Sauron contra otras bondadosas que no quieren que el mal reine
# sobre sus tierras.
# Cada raza tiene asociado un "valor" entre 1 y 5:
# - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
#   Númenóreanos (4), Elfos (5)
# - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
#   Huargos (3), Trolls (5)
# Crea un programa que calcule el resultado de la batalla entre
# los 2 tipos de ejércitos:
# - El resultado puede ser que gane el bien, el mal, o exista un empate.
#   Dependiendo de la suma del valor del ejército y el número de integrantes.
# - Cada ejército puede estar compuesto por un número de integrantes variable
#   de cada raza.
# - Tienes total libertad para modelar los datos del ejercicio.
# Ej: 1 Peloso pierde contra 1 Orco
#     2 Pelosos empatan contra 1 Orco
#     3 Pelosos ganan a 1 Orco


pelosos = list("valor" = 1, "number" = sample(1:10,1))
surbuenos = list("valor" = 2, "number" = sample(1:8,1))
enanos = list("valor" = 3, "number" = sample(1:7,1))
numenoreanos = list("valor" = 4, "number" = sample(1:6,1))
elfos = list("valor" = 5, "number" = sample(1:5,1))

ejercitoBueno = sum(c(pelosos$valor*pelosos$number,
              surbuenos$valor*surbuenos$number,
              enanos$valor*enanos$number,
              numenoreanos$valor*numenoreanos$number,
              elfos$valor*elfos$number))

surmalos = list("valor" = 1, "number" = sample(1:10,1))
orcos = list("valor" = 2, "number" = sample(1:8,1))
goblins = list("valor" = 3, "number" = sample(1:7,1))
huargos = list("valor" = 4, "number" = sample(1:6,1))
trolls = list("valor" = 5, "number" = sample(1:5,1))

ejercitoMalo = sum(c(surmalos$valor*surmalos$number,
          orcos$valor*orcos$number,
          goblins$valor*goblins$number,
          huargos$valor*huargos$number,
          trolls$valor*trolls$number))

batalla <- function() {
  if (ejercitoBueno > ejercitoMalo) {
    print("Los buenos ganan")
  }else  if (ejercitoBueno < ejercitoMalo){
    print("Los malos ganan")
  }else 
    print("Hay empate")
}

batalla()