package com.openai.chat

import java.awt.Image
import java.net.URL
import javax.imageio.ImageIO

/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea un programa en Kotlin que se encargue de calcular el aspect ratio de una imagen a partir de una url.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 * Resuelto: Sí. En 2 iteracciones.
 * Explicación:
 * · Para calcular el aspect ratio de una imagen a partir de una URL en Kotlin, podemos seguir los siguientes pasos:
 * 1. Descargar la imagen de la URL especificada.
 * 2. Leer la imagen y obtener sus dimensiones (ancho y alto en píxeles).
 * 3. Dividir el ancho por el alto para calcular el aspect ratio.
 * 4. Mostrar el aspect ratio en la salida estándar.
 * Conversación:
 * - El aspect ratio se suele mostrar separado por dos puntos (:)
 * + Exactamente. En lugar de mostrar el aspect ratio como un número decimal, se suele mostrar en formato "ancho:alto", por ejemplo, "16:9".
 * + Para hacerlo, podemos utilizar la función gcd de la clase kotlin.math.BigIntegerKt para calcular el máximo común divisor del ancho y el alto de la imagen,
 * y luego dividir el ancho y el alto por ese valor para obtener el aspect ratio en formato "ancho:alto"
 *
 */

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun main() {
    // Definimos la URL de la imagen que queremos analizar
//    val url = URL("https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png")
    val url = URL("https://upload.wikimedia.org/wikipedia/commons/7/7c/Aspect_ratio_16_9_example.jpg")
//    val url = URL("https://upload.wikimedia.org/wikipedia/commons/4/43/Aspect_ratio_4_3_example.jpg")
//    val url = URL("https://pbs.twimg.com/profile_images/918389307831934976/22ktBpnu_400x400.jpg")

    // Descargamos la imagen de la URL especificada
    val image = ImageIO.read(url)

    // Obtenemos las dimensiones de la imagen
    val width = image.getWidth(null)
    val height = image.getHeight(null)

    // Calculamos el máximo común divisor del ancho y el alto
    val gcdValue = gcd(width, height)

    // Calculamos el aspect ratio en formato "ancho:alto"
    val aspectRatio = "${width / gcdValue}:${height / gcdValue}"

    // Mostramos el aspect ratio en la salida estándar
    println("Aspect ratio: $aspectRatio")
}
