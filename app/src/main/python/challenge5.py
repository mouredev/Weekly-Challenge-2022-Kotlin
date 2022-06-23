# Reto  # 5
# ASPECT RATIO DE UNA IMAGEN
# Fecha publicación enunciado: 01/02/22
# Fecha publicación resolución: 07/02/22
# Dificultad: DIFÍCIL

# Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
# - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
# - Url de ejemplo: https: // raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
# - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.

"""
Equation to calculate the aspect ratio of an image
    AR = W/H
where:
    AR -> aspect ratio
    W -> width
    H -> heigth
"""


from urllib.request import urlopen
from PIL import Image
from fractions import Fraction

url1 = 'https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png'
url2 = 'https://fondosmil.com/fondo/29364.jpg'
url3 = 'https://www.teahub.io/photos/full/210-2107522_black-space-wallpapers001-star.jpg'


def read_image(url):
    try:
        image = Image.open(urlopen(url))
        return image
    except Exception:
        pass
    finally:
        pass


def get_width_height(image):
    try:
        width, height = image.size
        return width, height
    except Exception:
        pass
    finally:
        pass


def get_aspect_ratio(image):
    try:
        width, height = get_width_height(image)

        fraction = Fraction(width, height).as_integer_ratio()
        aspect_ratio = f"{fraction[0]}:{fraction[1]}"

        print(f'El aspect ratio de la imagen es: {aspect_ratio}')
    except Exception:
        pass
    finally:
        pass


if __name__ == '__main__':

    image1 = read_image(url1)
    image2 = read_image(url2)
    image3 = read_image(url3)

    print(get_aspect_ratio(image1))  # 128:41
    print(get_aspect_ratio(image2))  # 16:9
    print(get_aspect_ratio(image3))  # 3:1
