# Reto #46
# ¿DÓNDE ESTÁ EL ROBOT?
# Fecha publicación enunciado: 14/10/22
# Solución en python
# Propuesta por Manuel C.C.
# 

import math

ruta = [10, 5, -2]
origen =[0,0,90]            # [X,Y,ORIENTACION]
posicionActual = [0,0,0]    # [X,Y,ORIENTACION]

def hazRuta(recorrido):
    posicionActual = origen
    for pasos in recorrido:
        #print("Avanzando %i pasos en la dirección %i" % (pasos, posicionActual[2]))
        direccionRadianes = math.radians(posicionActual[2])
        posicionActual = [int(posicionActual[0]+(pasos*math.cos(direccionRadianes))),int(posicionActual[1]+(pasos*math.sin(direccionRadianes))),posicionActual[2] + 90]
        #print("Posición actual:", posicionActual)
    return([posicionActual[0],posicionActual[1]])

print("Me encuentro en",hazRuta(ruta))