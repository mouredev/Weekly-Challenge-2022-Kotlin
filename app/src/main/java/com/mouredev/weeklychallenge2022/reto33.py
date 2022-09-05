"""
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
 """

#Ingresa el año
year = input("Ingresa el año: ")

#Modifica el año de acuerdo a las referencias // Inicio de ciclo = 1924 // Cada ciclo de 60 años
year = int(year)-(1924%60)

#Definimos las tuplas de ELEMENTO y ANIMAL
ELEMENTO = ('Madera', 'Fuego', 'Tierra', 'Metal','Agua')
ANIMAL = ('Rata', 'Buey', 'Tigre', 'Conejo', 'Dragón', 'Serpiente', 'Caballo', 'Oveja', 'Mono', 'Gallo', 'Perro', 'Cerdo')

#x se repetirá en el año par y su año impar consecutivo, con 5 elementos // ciclo de 10 años
x = (year%10)//2

#y se repetirá en el ciclo de 12 años
y = year%12

#Imprime el resultado solicitado
print(ELEMENTO[x], ANIMAL[y])