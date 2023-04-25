"""
* Reto #5
* ASPECT RATIO DE UNA IMAGEN
* Dificultad: DIFÍCIL
*
* Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
* Url de ejemplo: https://wallpaperaccess.com/full/109676.jpg
* Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.

* Challenge #5
* ASPECT RATIO OF AN IMAGE
* Difficulty: DIFFICULT
*
* Statement: Create a program that is responsible for calculating the aspect ratio of an image from a url.
* Example URL: https://wallpaperaccess.com/full/109676.jpg
* By ratio we refer for example to the "16:9" of a 1920*1080px image.
"""
from PIL import Image
import requests, math
from io import BytesIO

def get_aspect_ratio(image_url):
    img_content = requests.get(image_url).content
    try:
        image = Image.open(BytesIO(img_content))
        width, height = image.size
        greatest_common_divisor = math.gcd(width, height)
        aspect_ratio = f"{round(width / greatest_common_divisor)}:{round(height / greatest_common_divisor)}"
        print(f"The Aspect Ratio is: {aspect_ratio}")
    except Exception:
        print("The provided URL is not a valid image.")
get_aspect_ratio("https://wallpaperaccess.com/full/109676.jpg")