# Reto #46
# ¿DÓNDE ESTÁ EL ROBOT?
# Fecha publicación enunciado: 14/10/22
# Fecha publicación resolución: 21/11/22
# Dificultad: MEDIA
#
# Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
# representada por los ejes "x" e "y".
# - El robot comienza en la coordenada (0, 0).
# - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
#   que indican la secuencia de pasos a dar.
#  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
#    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
# - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
# - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
#   positiva del eje "y".
# - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
#   90 grados en el sentido contrario a las agujas del reloj.

def robotPosition(steps):
    pos = [0, 0]
    currentDir = 0
    directions = [
        [1, 1],  # Eje Y, Sentido +
        [0, -1], # Eje X, Sentido -
        [1, -1], # Eje Y, Sentido -
        [0, 1],  # Eje X, Sentido +
    ]

    if not (isinstance(steps, list)):
        print('ERROR: Lista de instrucciones no válida')
        return pos

    for step in steps:
        if(isinstance(step, int)):
            pos[directions[currentDir][0]] += step * directions[currentDir][1]
            currentDir = (currentDir+1) % 4
        else:
            print(f'WARNING: La orden \'{step}\' no se puede procesar.')
    return pos


x, y = robotPosition([10, 5, -2])
print(f'X: {x}, Y: {y}\n')

x, y = robotPosition([-4, 15, -8, -15, -19])
print(f'X: {x}, Y: {y}\n')

x, y = robotPosition([4, 8, 10, 4])
print(f'X: {x}, Y: {y}\n')

x, y = robotPosition([10, 'patata', -2])
print(f'X: {x}, Y: {y}\n')

x, y = robotPosition('patata')
print(f'X: {x}, Y: {y}\n')
