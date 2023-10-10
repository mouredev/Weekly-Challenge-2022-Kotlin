"""
/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
 * - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
"""
import requests
from PIL import Image
from io import BytesIO

def getApectRatio(imageUrl):
    # Descargar la imagen del enlace
    response = requests.get(imageUrl)
    if response.status_code != 200:
        raise Exception("Error getting image")
     # Abrir la imagen con PIL
    image = Image.open(BytesIO(response.content))
    # Obtener las dimensiones
    width, height = image.size
    # Calcular el aspect ratio
    aspectRatio = width/height
    return aspectRatio

url= "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"
print(getApectRatio(url))


