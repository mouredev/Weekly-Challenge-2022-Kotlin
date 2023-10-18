#
#  Reto #5
#  ASPECT RATIO DE UNA IMAGEN
#  Fecha publicación enunciados: 01/02/22
#  Fecha publicación resolución: 07/02/22
#  Dificultad: DIFÍCIL
#
#  Enunciado: Crea un programa que se encargue de calcular y el aspect ratio de una imagen a partir de una url.
#  - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
#  - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1921080px.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#


# Se utiliza Open-CV para procesar la imagen
import cv2
import requests
from fractions import Fraction

url = "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"
IMAGE_NAME = "image.png"


def download_image(url_image: str):
    response = requests.get(url_image)
    
    # Escribe un archivo IMAGE_NAME.
    with open(IMAGE_NAME, "wb") as file:
       file.write(response.content)


def ratio_net_image(url_image: str):
    # Descarga la imagen
    download_image(url_image)

    # Si la imagen puede ser procesada por Open-CV se procesa la imagen.
    if cv2.haveImageReader(IMAGE_NAME):
        # Lee la imagen desde el fichero
        img = cv2.imread(IMAGE_NAME)

        # Extrae el alto y ancho.
        dimension_image: tuple = img.shape
        height: int = dimension_image[0]
        width: int = dimension_image[1]

        # Determina el ratio de la imagen como una fracción.
        fraction: tuple = Fraction(width, height).as_integer_ratio()
        aspect_ratio: str = f"{fraction[0]}:{fraction[1]}"

        print(f"La relación de aspecto de la imagen es: {aspect_ratio}. Sus dimensiones son: {width}x{height} px.")

    else:
        print("La imagen no puede ser procesada, compruebe que sea la URL de una imagen.")


ratio_net_image(url)
