#
# Reto #37
# LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
# Fecha publicación enunciado: 14/09/22
# Fecha publicación resolución: 19/09/22
# Dificultad: MEDIA
# 
# Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"!
# Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
# Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos
# "The Legend of Zelda" de la historia?
# Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda
# que tú selecciones.
# - Debes buscar cada uno de los títulos y su día de lanzamiento
#   (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
#

from datetime import datetime

def cargaTitulos():
    
    tabZelda = []

    tabZelda.append({"indice": "01", "titulo": "The Legend of Zelda ",             "fecha": "21/02/1986"})
    tabZelda.append({"indice": "02", "titulo": "The Adventure of Link",            "fecha": "14/01/1987"})
    tabZelda.append({"indice": "03", "titulo": "A Link to the Past",               "fecha": "21/11/1991"})
    tabZelda.append({"indice": "04", "titulo": "Links Awakening",                  "fecha": "06/06/1993"})
    tabZelda.append({"indice": "05", "titulo": "Ocarina of time",                  "fecha": "21/11/1998"})
    tabZelda.append({"indice": "06", "titulo": "Majoras Mask",                     "fecha": "27/04/2000"})
    tabZelda.append({"indice": "07", "titulo": "Oracle of Seasons",                "fecha": "27/01/2001"})
    tabZelda.append({"indice": "08", "titulo": "Oracle of Ages",                   "fecha": "27/02/2001"})
    tabZelda.append({"indice": "09", "titulo": "A Link to the Past & Four Swords", "fecha": "14/02/2002"})
    tabZelda.append({"indice": "10", "titulo": "The Wind Waker",                   "fecha": "13/12/2002"})
    tabZelda.append({"indice": "11", "titulo": "Four Swords Adventures",           "fecha": "18/03/2004"})
    tabZelda.append({"indice": "12", "titulo": "The Minish Cap",                   "fecha": "04/11/2004"})
    tabZelda.append({"indice": "13", "titulo": "Twilight Princess",                "fecha": "02/12/2006"})
    tabZelda.append({"indice": "14", "titulo": "Phantom Hourglass",                "fecha": "23/06/2007"})
    tabZelda.append({"indice": "15", "titulo": "Spirit Tracks",                    "fecha": "23/12/2009"})
    tabZelda.append({"indice": "16", "titulo": "Skyward Sword",                    "fecha": "23/11/2011"})
    tabZelda.append({"indice": "17", "titulo": "A Link Between Worlds",            "fecha": "26/12/2013"})
    tabZelda.append({"indice": "18", "titulo": "Tri Force Heroes",                 "fecha": "22/10/2015"})
    tabZelda.append({"indice": "19", "titulo": "Breath of the Wild",               "fecha": "03/03/2017"})
    tabZelda.append({"indice": "20", "titulo": "Tears of the Kingdom",             "fecha": "12/05/2023"})

    return tabZelda

def muestraListaTitulos(tabZelda):
    print("TITULOS")
    print("=======")
    for i in tabZelda:
        print(i["indice"], i["titulo"], i["fecha"])
    print("=======")

def ingresaIndice(texto):
    indTitulo = str(input(texto))
    return indTitulo

def obtieneFecha(tabZelda,indTitulo):
    for t in tabZelda:
        a = ("indice:", t["indice"])
        if a[1] == indTitulo:
            return datetime.strptime(str(t["fecha"]), "%d/%m/%Y")

def main():    

    tabZelda = cargaTitulos()

    muestraListaTitulos(tabZelda)

    indTitulo1 = ingresaIndice("Ingresa el primer índice\n")
    indTitulo2 = ingresaIndice("Ingresa el segundo índice\n")

# Acá se podría hacer más validaciones con los índices de los títulos
    if indTitulo1 > indTitulo2:
        print("Error, segundo indice debe ser mayor")
        quit()

    fecha1 = obtieneFecha(tabZelda, indTitulo1)
    fecha2 = obtieneFecha(tabZelda, indTitulo2)

    anios = int(fecha2.year) - int(fecha1.year)

# Igualamos los años para obtener los dias transcurridos de ese año
    fechaParaDias = fecha1.replace(fecha1.year + anios)
    if fecha2 < fechaParaDias:
        anios -= 1
        fechaParaDias = fechaParaDias.replace(fechaParaDias.year - 1)

    dias = fecha2 - fechaParaDias
    diasTotal = dias.days

    print("------------")
    print(anios, "Años")
    print(diasTotal, " Dias")

if __name__ == '__main__':
    main()
