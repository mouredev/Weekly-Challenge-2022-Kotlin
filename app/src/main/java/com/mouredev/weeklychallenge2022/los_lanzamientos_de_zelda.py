"""
Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
- Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
"""

import datetime

releases = {
    "1": "The Legend of Zelda",
    "2": "Zelda II: Adventure of Link",
    "3": "The Legend of Zelda: A Link to the Past",
    "4": "The Legend of Zelda: Link's Awakening",
    "5": "The Legend of Zelda: Ocarina of Time",
    "6": "The Legend of Zelda: Majora`s Mask",
    "7": "The Legend of Zelda: Oracle of Ages/Oracle of Seasons",
    "8": "The Legend of Zelda: The Wind Waker",
    "9": "The Legend of Zelda: A Link to the Past - Four Sword",
    "10": "The Legend of Zelda: Four Sword Adventures",
    "11": "The Legend of Zelda: The Minish Cap",
    "12": "The Legend of Zelda: Twiligth Princess",
    "13": "The Legend of Zelda: Phantom Hourglass",
    "14": "The Legend of Zelda: Spirit Tracks",
    "15": "The Legend of Zelda: Skyward Sword",
    "16": "The Legend of Zelda: A Link Between Worlds",
    "17": "The Legend of Zelda: Tri Force Heroes",
    "18": "The Legend of Zelda: Breath of the Wild",
    "19": "The Legend of Zelda: Tears of the Kingdom",
}

releases_japan = {
    "1": datetime.date(1986, 2, 21),
    "2": datetime.date(1987, 1, 14),
    "3": datetime.date(1991, 11, 21),
    "4": datetime.date(1993, 6, 6),
    "5": datetime.date(1998, 11, 21),
    "6": datetime.date(2000, 4, 27),
    "7": datetime.date(2001, 2, 27),
    "8": datetime.date(2002, 12, 13),
    "9": datetime.date(2003, 3, 14),
    "10": datetime.date(2004, 3, 18),
    "11": datetime.date(2004, 11, 4),
    "12": datetime.date(2006, 12, 2),
    "13": datetime.date(2007, 6, 23),
    "14": datetime.date(2009, 12, 23),
    "15": datetime.date(2011, 11, 23),
    "16": datetime.date(2013, 12, 26),
    "17": datetime.date(2015, 10, 22),
    "18": datetime.date(2017, 3, 3),
    "19": datetime.date(2023, 5, 12),
}

releases_america = {
    "1": datetime.date(1986, 8, 22),
    "2": datetime.date(1988, 12, 1),
    "3": datetime.date(1992, 4, 13),
    "4": datetime.date(1993, 8, 1),
    "5": datetime.date(1998, 11, 23),
    "6": datetime.date(2000, 10, 26),
    "7": datetime.date(2001, 5, 14),
    "8": datetime.date(2003, 3, 24),
    "9": datetime.date(2002, 12, 2),
    "10": datetime.date(2004, 6, 7),
    "11": datetime.date(2005, 1, 10),
    "12": datetime.date(2006, 11, 19),
    "13": datetime.date(2007, 10, 1),
    "14": datetime.date(2009, 12, 7),
    "15": datetime.date(2011, 11, 20),
    "16": datetime.date(2013, 11, 22),
    "17": datetime.date(2015, 10, 23),
    "18": datetime.date(2017, 3, 3),
    "19": datetime.date(2023, 5, 12),
}

releases_europe = {
    "1": datetime.date(1986, 11, 15),
    "2": datetime.date(1988, 9, 26),
    "3": datetime.date(1992, 9, 24),
    "4": datetime.date(1993, 12, 1),
    "5": datetime.date(1998, 12, 11),
    "6": datetime.date(2000, 11, 17),
    "7": datetime.date(2001, 10, 5),
    "8": datetime.date(2003, 5, 3),
    "9": datetime.date(2002, 12, 2),
    "10": datetime.date(2005, 1, 7),
    "11": datetime.date(2004, 11, 12),
    "12": datetime.date(2006, 12, 8),
    "13": datetime.date(2007, 10, 19),
    "14": datetime.date(2009, 12, 11),
    "15": datetime.date(2011, 11, 18),
    "16": datetime.date(2013, 11, 22),
    "17": datetime.date(2015, 10, 24),
    "18": datetime.date(2017, 3, 3),
    "19": datetime.date(2023, 5, 12),
}


def calculate_releases(older, newer, releases_country):
    print(
        "Fecha de lanzamiento de",
        releases[str(older)] + ":",
        releases_country[str(older)],
    )
    print(
        "Fecha de lanzamiento de",
        releases[str(newer)] + ":",
        releases_country[str(newer)],
    )
    calculate = releases_country[str(newer)] - releases_country[str(older)]

    print("Diferencia en días entre lanzamientos:", calculate.days)


print("Lista de lanzamientos:")
for i in range(1, len(releases) + 1):
    print(i, "-", releases[str(i)])
older = input("Elige el primer lanzamiento: ")
newer = input("Elige el segundo lanzamiento: ")
country = input("Elige el país de lanzamiento (1- Japón, 2- América, 3- Europa): ")

if "jap" in country or "Jap" in country or country == "1":
    calculate_releases(older, newer, releases_japan)
elif "am" in country or "Am" in country or country == "2":
    calculate_releases(older, newer, releases_america)
elif "euro" in country or "Euro" in country or country == "3":
    calculate_releases(older, newer, releases_europe)
else:
    print("Error: país no encontrado")
