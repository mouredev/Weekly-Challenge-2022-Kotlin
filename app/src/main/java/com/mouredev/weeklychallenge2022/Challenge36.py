
#  * Reto #36
#  * LOS ANILLOS DE PODER
#  * Fecha publicación enunciado: 06/09/22
#  * Fecha publicación resolución: 14/09/22
#  * Dificultad: MEDIA
#  *
#  * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
#  * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
#  * Cada raza tiene asociado un "valor" entre 1 y 5:
#  * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
#  * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
#  * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
#  * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
#  *   suma del valor del ejército y el número de integrantes.
#  * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
#  * - Tienes total libertad para modelar los datos del ejercicio.
#  * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.


razasBondadosas={'Peloso':1,
                'Surenos Buenos':2,
                'Enanos':3,
                'Numenoreanos':4,
                'Elfos':5,
                }
razasMalvadas={'Surenos Malos':2,
                'Orcos':2,
                'Goblins':2,
                'Huargos':3,
                'Trolls':5,
                }

cantidad=0
bien=[]
mal=[]
def crearEjercito(clase,lista,diccionario):
    cantidad=int(input(f'Cuantos {clase} habran?\n'))
    lista.append(cantidad*diccionario[clase])
    
def ejercito():
    print('La tierra esta en guerra, por favor elegir los ejercitos que contemplaran esta batalla')
    print('Forma el ejercito del bien')
    for i in razasBondadosas:
        crearEjercito(i,bien,razasBondadosas)
        
    print('\nForma el ejercito del mal')
    for i in razasMalvadas:
        crearEjercito(i,mal,razasMalvadas)

def guerra():
    if sum(bien)>sum(mal):
        print('Enahorabuena!, ha ganado el bien')
    elif sum(mal)>sum(bien):
        print('Viva la malda, han ganado las fuerzas oscuras')
    elif sum(mal)==sum(bien):
        print('La guerra solo ha traido muertes, los dos han perdido y han quedado empate')
    else:
        print('Datos no validos')
        
ejercito()
print('\n LA GUERRA HA EMPEZADO \n')
guerra()
