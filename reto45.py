#
# - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
#
#          ⏹
#          ⏹
#   ⏹💧💧⏹
#   ⏹💧⏹⏹💧⏹
#   ⏹💧⏹⏹💧⏹
#   ⏹💧⏹⏹⏹⏹
#
#   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
#   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
#
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#

def unidades_de_agua(lista):
    altura = 0
    cantidad_agua = 0

    while True:

        espacio_libre = 0
        bloque_izquierda = -1
        bloque_derecha = -1

        for j in range(len(lista)):
            if lista[j] > altura:
                if bloque_izquierda == -1:
                    bloque_izquierda = j

                bloque_derecha = j
                espacio_libre += 1

        if (bloque_izquierda != 1) and (espacio_libre != (bloque_derecha - bloque_izquierda + 1)):
            cantidad_agua += (bloque_derecha - bloque_izquierda + 1) - espacio_libre
        else:
            break
        
        altura += 1

    return (cantidad_agua)


if __name__ == "__main__":
    lista = [4, 0, 3]
    print(f"Hay {unidades_de_agua(lista)} unidades de agua")

    lista = [4, 0, 3, 6, 1, 3]
    print(f"Hay {unidades_de_agua(lista)} unidades de agua")
    
    lista = [1, 2, 3, 4, 5, 4, 3, 2, 1]
    print(f"Hay {unidades_de_agua(lista)} unidades de agua")

    