package com.mouredev.weeklychallenge2022

import java.net.URL
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea un programa que se encargue de calcular y el aspect ratio de una imagen a partir de una url.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    showAspectRatioOf("https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png")
    showAspectRatioOf("https://upload.wikimedia.org/wikipedia/commons/7/7c/Aspect_ratio_16_9_example.jpg")
    showAspectRatioOf("https://upload.wikimedia.org/wikipedia/commons/4/43/Aspect_ratio_4_3_example.jpg")
    showAspectRatioOf("https://pbs.twimg.com/profile_images/918389307831934976/22ktBpnu_400x400.jpg")
}

// Necesita la librería java-rt-jar-stubs-1.5.0.jar para disponer de los paquetes java.awt.image.* y javax.imageio.*
// Descargada de: http://www.java2s.com/Code/JarDownload/java-rt/java-rt-jar-stubs-1.5.0.jar.zip
fun showAspectRatioOf(imageLink: String) {
    val imageName = imageLink.split("/").last().split(".").first()
    val imageUrl = URL(imageLink)
    val image: BufferedImage = ImageIO.read(imageUrl)
    val imageWidth = image.width
    val imageHeight = image.height
    var minWidth = imageWidth
    var minHeight = imageHeight

    (1..Math.min(imageWidth, imageHeight)).forEach { i ->
        if((imageWidth % i == 0) && (imageHeight % i == 0)) {
            minWidth = imageWidth / i
            minHeight = imageHeight / i
        }
    }
    println("$imageName tiene $minWidth:$minHeight de ratio")
}