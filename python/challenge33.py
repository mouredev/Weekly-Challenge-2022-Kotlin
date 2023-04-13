elementos = {
    0: "Metal",
    1: "Metal",
    2: "Agua",
    3: "Agua",
    4: "Madera",
    5: "Madera",
    6: "Fuego",
    7: "Fuego",
    8: "Tierra",
    9: "Tierra"
}

animales = {
    0: "Mono",
    1: "Gallo",
    2: "Perro",
    3: "Cerdo",
    4: "Rata",
    5: "Buey",
    6: "Tigre",
    7: "Conejo",
    8: "Dragón",
    9: "Serpiente",
    10: "Caballo",
    11: "Oveja"
}

year_input = ""

# Ingreso de año por el usuario y validación del input
while (not year_input.isdigit() or len(str(year_input)) != 4):
    year_input = input("Por favor ingrese un año de 4 cifras: ")

year_int = int(year_input)
elemento = elementos[year_int % 10]
animal = animales[year_int % 12]

print(year_input + ":" + animal + " de " + elemento)
