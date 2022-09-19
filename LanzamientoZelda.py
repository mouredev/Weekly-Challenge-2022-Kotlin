# Enunciado Reto #37: ¡Han anunciado un nuevo "The Legend of Zelda"! 
# Se llamará "Tears of the Kingdom" y se lanzará el 12 de mayo de 2023.
# Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos
# "The Legend of Zelda" de la historia?
# Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda
# que tú selecciones.
# - Debes buscar cada uno de los títulos y su día de lanzamiento 
#   (si no encuentras el día exacto puedes usar el mes, o incluso inventártelo)
from datetime import datetime, timedelta

def tiempoJuegosZelda(titulo1,titulo2):
    juegos = ["The Legend of Zelda","Zelda II: The Adventure", "The Legend of Zelda: A Link to the Past","The Legend of Zelda: Link's Awakening DX","Zelda: The Wand of Gamelon","Link: The Faces of Evil",
    "Zelda's Adventure","BS The Legend of Zelda","BS Zelda no Densetsu Kodai no Sekiban","The Legend of Zelda: Ocarina of Time","The Legend of Zelda: Majora's Mask", "The Legend of Zelda: Oracle of Seasons",
    "The Legend of Zelda: Oracle of Ages","The Legend of Zelda: Four Swords","The Legend of Zelda: Collector's Edition","The Legend of Zelda: The Wind Waker","The Legend of Zelda: Four Swords Adventures","The Legend of Zelda: The Minish Cap",
    "The Legend of Zelda: Twilight Princess","The Legend of Zelda: Phantom Hourglass","Link's Crossbow Training","The Legend of Zelda: Spirit Tracks","The Legend of Zelda: Ocarina of Time 3D","The Legend of Zelda: Skyward Sword",
    "The Legend of Zelda: The Wind Waker HD","The Legend of Zelda: A Link Between Worlds","The Legend of Zelda: Majora's Mask 3D","The Legend of Zelda: Tri Force Heroes","The Legend of Zelda: Twilight Princess HD",
    "The Legend of Zelda: Breath of the Wild","The Legend of Zelda: Link's Awakening","The Legend of Zelda: Skyward Sword HD","The Legend of Zelda: Tears of the Kingdom"]
    lanzamiento = ["21/02/1986","14/01/1987","21/11/1991","06/06/1993","10/10/1993","10/10/1993","05/06/1994","09/08/1995","30/03/1997","21/11/1998","27/04/2000","27/02/2001","27/02/2001",
    "13/12/2002","13/12/2002","14/11/2003","18/03/2004","04/11/2004","19/11/2006","01/06/2007","19/11/2007","07/12/2009","16/06/2011","18/11/2011","20/09/2013","01/11/2013","13/02/2015",
    "01/11/2015","04/03/2016","03/03/2017","20/09/2019","16/07/2021","01/01/2023"]
    pos = juegos.index(titulo1)
    pos2 = juegos.index(titulo2)
    fechaJuego1= datetime.strptime(lanzamiento[pos], '%d/%m/%Y')
    fechaJuego2= datetime.strptime(lanzamiento[pos2], '%d/%m/%Y')
    dias = fechaJuego2 - fechaJuego1
    indice = str(dias).index("d")
    años = int(str(dias)[0:indice])//365
    dias = int(str(dias)[0:indice]) - años * 365
    print("El lanzamiento entre los juegos %s y %s es de %d años y %d dias"%(titulo1, titulo2, abs(años), abs(dias)))

tiempoJuegosZelda("The Legend of Zelda: Four Swords","The Legend of Zelda: Skyward Sword HD")
tiempoJuegosZelda("The Legend of Zelda: Tri Force Heroes","Zelda II: The Adventure")
tiempoJuegosZelda("The Legend of Zelda","The Legend of Zelda: Tears of the Kingdom")