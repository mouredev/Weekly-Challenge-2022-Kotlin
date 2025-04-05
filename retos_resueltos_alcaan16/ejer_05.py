"""
#5-ASPECT RATIO DE UNA IMAGEN
/*
 * Crea un programa que se encargue de calcular el aspect ratio de una
 * imagen a partir de una url.
 * - Url de ejemplo:
 *   https://raw.githubusercontent.com/mouredevmouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una
 *   imagen de 1920*1080px.
 */

Tienes que dividir la altura original por la anchura original 
y luego multiplicar este número por la nueva anchura para obtener la nueva altura. 
Estos pasos le darán la altura correcta para su imagen editada.



def ratio(num_1, num_2):
    var= num_1 / num_2
    print (var)




num_1 = 1920
num_2 = 1080
ratio(num_1, num_2)
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