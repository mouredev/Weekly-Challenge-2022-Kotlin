# Enunciado Reto #33: Crea una función, que dado un año, indique el elemento 
# y animal correspondiente en el ciclo sexagenario del zodíaco chino.
# - Info: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
# - El ciclo sexagenario se corresponde con la combinación de los elementos
#   madera, fuego, tierra, metal, agua y los animales rata, buey, tigre,
#   conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro, cerdo
#   (en este orden).
# - Cada elemento se repite dos años seguidos.
# - El último ciclo sexagenario comenzó en 1984 (Madera Rata).

def cicloSexagenarioChino():
    element = ["Madera","Fuego","Tierra","Metal","Agua"]
    animals = ["Rata","Buey","Tigre","Conejo","Dragón","Serpiente","Caballo","Oveja","Mono","Gallo","Perro","Cerdo"]
    añoInicial = 604
    elementAño = ""
    animalAño = ""
    año = int(input("Introduce un año: "))
    pos1 = 0
    pos2 = 0
    if año >= añoInicial :
        while añoInicial <= año:
            if añoInicial %2 == 0:
                elementAño = element[pos1]
            else:
                if pos1 == len(element) -1 :
                    elementAño = element[pos1]
                    pos1 = 0
                else:
                    elementAño = element[pos1]
                    pos1 += 1
            if pos2 == len(animals) -1 :
                animalAño = animals[pos2]
                pos2 = 0
            else:
                animalAño = animals[pos2]
                pos2 +=1
            añoInicial +=1
        print("Ciclo Sexagenario del Zodiaco Chino:")
        print("Año %d = %s %s "%(año,elementAño,animalAño))
    else:
        print("Se introdujo el Ciclo Sexagenario Chino en el año 604, por lo tanto en el año", año, "no existia este ciclo.")

cicloSexagenarioChino()