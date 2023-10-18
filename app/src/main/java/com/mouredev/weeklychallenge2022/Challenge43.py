# /*
#  * Reto #43
#  * TRUCO O TRATO
#  * Fecha publicación enunciado: 24/10/22
#  * Fecha publicación resolución: 02/11/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Este es un reto especial por Halloween.
#  * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
#  * un listado (array) de personas con las siguientes propiedades:
#  * - Nombre de la niña o niño
#  * - Edad
#  * - Altura en centímetros
#  *
#  * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
#  * siguiendo estos criterios:
#  * - Un susto por cada 2 letras del nombre por persona
#  * - Dos sustos por cada edad que sea un número par
#  * - Tres sustos por cada 100 cm de altura entre todas las personas
#  * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
#  *
#  * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
#  * siguiendo estos criterios:
#  * - Un dulce por cada letra de nombre
#  * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
#  * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
#  * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */(


import random

Sustos=['🎃', '👻', '💀', '🕷', '🕸', '🦇']
Dulces=['🍰', '🍬', '🍡', '🍭', '🍪', '🍫', '🧁', '🍩']


def Truco(nombre,edad,altura):
    Edad=0
    Altura=0
    susto=[]
    letras=int(len(nombre)/2)
    if int(edad)%2==0:
        Edad=2

    Altura=int(altura)
    

    return letras,Edad,Altura

def Trato(nombre,edad,altura):
        dulces_edad=0
        dulces=0
        Altura=0
        dulces_altura=0
        susto=[]
        letras=int(len(nombre))
       
        if int(edad)>10:
            dulces_edad=3
        elif int(edad)<10:
            dulces_edad=int(edad)//3

        Altura=int(altura)

        if Altura > 150:
            dulces_altura=3
        elif Altura <= 150:
            dulces_altura=Altura//50
        
        return letras,dulces_edad,dulces_altura



if __name__=='__main__':
    l=0
    E=0
    A=0
    D=0
    Dulces_Altura=0
    Dulces_Altura=0
    sustos_totales=[]
    Dulce_totales=[]
    personas=[
        ["Carlos",'18','173'],
        ["Kelly",'12','152'],
        #["Andres",'7','100'],
        #["Maria",'8','129'],
        #["Dario",'17','159'],
        ["Andrea",'10','138']

    ]

    opcion=input('Truco o Trato?: \n')
    Opcion=opcion.lower()
    if Opcion == 'truco':
        for nombre,edad,estatura in personas:
        
            letras,Edad,Altura= Truco(nombre,edad,estatura)
            l+=letras
            E+=Edad
            A+=Altura
        sustos_por_altura=(A//100)*3
        sustos=l+E+sustos_por_altura
        for i in range(0,int(sustos)):
            sustos_totales.append(random.choice(Sustos))
        print(f'sustos totales {sustos}: {sustos_totales}')

    elif Opcion=='trato':
        for nombre,edad,estatura in personas:
            letras,dulces, altura= Trato(nombre,edad,estatura)
            l+=letras
            D+=dulces
            Dulces_Altura+=altura

        dulces_por_altura=Dulces_Altura*2
        dulces_totales=l+D+dulces_por_altura
        for i in range(0,int(dulces_totales)):
            Dulce_totales.append(random.choice(Dulces))
        print(f'Dulces totales {dulces_totales}: {Dulce_totales}')

    else:
        print('Digite una de las dos opciones')

