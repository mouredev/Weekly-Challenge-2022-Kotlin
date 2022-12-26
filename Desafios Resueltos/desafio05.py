from PIL import Image
from urllib.request import urlopen
from io import BytesIO
import math


def inicio():
    URL = 'https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png'
    data = urlopen(URL).read()# descarga y almacena la imagen en una cadena de bytes
    file = BytesIO(data) # trata la cadena como un fichero
    img = Image.open(file) # lee el fichero y devuelve la imagen
    tamaño = img.size # informa del tamaño en una tupla
    print(ratio(tamaño))#envio los parametros a la calculadora e imprimo el resultado

def ratio(tupla):
    base = tupla[0]
    altura = tupla[1]
    #Descopongo la base y la altura en variables diferentes
    r = math.gcd(altura, base)
    x = int(base / r)
    y = int(altura / r)
    #Calcula el aspect ratio
    return f"{x}:{y}"
    

inicio()