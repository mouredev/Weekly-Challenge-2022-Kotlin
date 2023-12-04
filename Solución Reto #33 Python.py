'''/*
 * Enunciado: Crea un función, que dado un año, indique el elemento
 * y animal correspondiente en el ciclo sexagenario del zodíaco chino.
 * - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos
 *   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
 *   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
 *   (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 */'''


def cicloSexagenarioChino():
    elementos = [
        "Madera",
        "Madera",
        "Fuego",
        "Fuego",
        "Tierra",
        "Tierra",
        "Metal",
        "Metal",
        "Agua",
        "Agua"
    ]

    animales = [
        "Rata",
        "Buey",
        "Tigre",
        "Conejo",
        "Dragón",
        "Serpiente",
        "Caballo",
        "Oveja",
        "Mono",
        "Gallo",
        "Perro",
        "Cerdo"
    ]

    ciclos_sexagenarios = [(1804, 1863), (1864, 1923), (1924, 1983), (1984, 2043)]

    numero_annus = 0

    print("**********CICLO SEXAGENARIO CHINO**********")

    annus = int(input("\nIngresa un año: "))

    for ciclo in ciclos_sexagenarios:
        if annus >= ciclo[0] and annus <= ciclo[1]:
            numero_annus = annus - ciclo[0] + 1

    if numero_annus == 0:
        print("Año no disponible. Consulta un año de los siguientes ciclos sexagenarios: ")
        for ciclo in ciclos_sexagenarios:
            print(ciclo, end="")
    else:

        if numero_annus >= len(elementos):
            elemento = elementos[numero_annus % len(elementos) - 1]
        else:
            elemento = elementos[numero_annus - 1]

        if numero_annus >= len(animales):
            animal = animales[numero_annus % len(animales) - 1]
        else:
            animal = animales[numero_annus - 1]

        print(f"{annus} Año de {animal} de {elemento} ")


cicloSexagenarioChino()




