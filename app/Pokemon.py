##Challenge35
import pandas as pd

atack = 0
defense = 0
ta = ""
td = ""
typeat = ""
tabletype = pd.DataFrame({
    "" : ["agua","fuego","planta","electrico"],
    "agua" : [0.5,2,0.5,0.5],
    "fuego" :[0.5,0.5,2,1],
    "planta" :[2,0.5,0.5,1],
    "electrico" : [2,1,0.5,0.5]
})
tabletype = tabletype.set_index("")
#print(tabletype)
switch_tipo ={
    "1" : "agua",
    "2" : "fuego",
    "3" : "planta",
    "4" : "electrico",
}
while True:
    atack = input("Ingrese el Ataque: ")
    if atack.isnumeric() and int(atack) <= 100:
        break
while True:
    defense = input("Ingrese la defensa: ")
    if defense.isnumeric() and int(defense) <= 100:
        break
while True:
    print("Ingrese el numero correspondiente al tipo que quiera elegir:\n-1 para agua\n-2 para fuego\n-3 para planta\n-4 para electrico")
    typeat = input("Ingrese tipo del pokemon atacante: ")
    if typeat in switch_tipo:
        break
ta = switch_tipo.get(typeat)
print("Usted Ingresó: "+ta)
while True:
    print("Ingrese el numero correspondiente al tipo que quiera elegir:\n-1 para agua\n-2 para fuego\n-3 para planta\n-4 para electrico")
    typedef = input("Ingrese tipo del pokemon defensor: ")
    if typedef in switch_tipo:
        break
td = switch_tipo.get(typedef)
print("Usted Ingresó: "+td)
efec = tabletype.loc[td,ta]
form = 50 * (int(atack)/int(defense))* efec
print("El resultado del ataque es: "+str(form))