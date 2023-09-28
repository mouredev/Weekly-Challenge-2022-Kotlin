"""
  Reto #5
  ASPECT RATIO DE UNA IMAGEN
  Fecha publicación enunciado: 01/02/22
  Fecha publicación resolución: 07/02/22
  Dificultad: DIFÍCIL
 
  Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
  - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
  - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
  - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 
  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""

from PIL import Image
import requests
import math
from io import BytesIO


def ratio(url):
  img_content = requests.get(url).content
  image = Image.open(BytesIO(img_content))
  width, height = image.size
  greatest_common_divisor = math.gcd(width, height)
  aspect_ratio = f"{round(width / greatest_common_divisor)}:{round(height / greatest_common_divisor)}"
  print(f"El Aspect Ratio es: {aspect_ratio}")


ratio('https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png')