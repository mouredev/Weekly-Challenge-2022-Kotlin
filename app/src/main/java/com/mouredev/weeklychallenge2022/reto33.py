""" 
/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
 """


def ciclo_sexagenario(year):
    """
    Función que devuelve el elemento y animal correspondiente en el ciclo sexagenario del zodíaco chino.
    """
    if year < 1984:
        print("El año no es válido")
    else:
        year -= 1984
        element = year % 6
        animal = year % 12
        if element == 0:
            element = "madera"
        elif element == 1:
            element = "fuego"
        elif element == 2:
            element = "tierra"
        elif element == 3:
            element = "metal"
        elif element == 4:
            element = "agua"
        elif element == 5:
            element = "rata"
        if animal == 0:
            animal = "rata"
        elif animal == 1:
            animal = "buey"
        elif animal == 2:
            animal = "tigre"
        elif animal == 3:
            animal = "conejo"
        elif animal == 4:
            animal = "dragon"
        elif animal == 5:
            animal = "serpiente"
        elif animal == 6:
            animal = "caballo"
        elif animal == 7:
            animal = "oveja"
        elif animal == 8:
            animal = "mono"
        elif animal == 9:
            animal = "gallo"
        elif animal == 10:
            animal = "perro"
        elif animal == 11:
            animal = "cerdo"
        print("El elemento es {} y el animal es {}".format(element, animal))

if __name__ == '__main__':
    año_elegido = int(input("Introduce un año: "))
    ciclo_sexagenario(año_elegido)