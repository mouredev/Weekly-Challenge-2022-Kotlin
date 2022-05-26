"""
Hay varias formas de evaluar el resultado del fichero.
1ª - Leer el contenido completo y construir un string que se pasaría a la función eval() para que evalúe el resultado.
     La función eval() respeta la prioridad de operaciones ( *, /, +, -) por lo que el resultado será -14.
2ª - Leer el contenido e ir evaluando secuencialmente, respetando el orden en que esta escrito en el fichero, siendo el 
     resultado +18,5.
Yo he optado por la 2ª opción.
"""

resultado = 0
f = open('datos.txt', 'r')
g = ['+'] + f.read().split()

try:
    for i in range(0, len(g), 2):
        resultado = eval(str(resultado) + g[i] + g[i+1])
    print(resultado)
except ZeroDivisionError:
    print("[E] error división por zero")
