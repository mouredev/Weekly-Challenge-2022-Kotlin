package com.mouredev.weeklychallenge2022

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

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream
import java.net.URL

class Challenge5 {

    fun calculateAspectRatio(urlString: String) {
        Thread {
            try {
                val url = URL(urlString)
                val inStream: InputStream = url.openConnection().getInputStream()
                val image: Bitmap = BitmapFactory.decodeStream(inStream)
                val aspectRatio: String = getAspectRatio(image)
                println("El aspect ratio de la imagen es $aspectRatio")
            } catch (e: Exception) {
                println(
                    "Un error inesperado ha ocurrido:$e :\n${e.stackTrace}"
                )
            }
        }.start()
    }
}

fun getAspectRatio(algo: Bitmap): String {
    val width = algo.width
    val height = algo.height

    val mcd = getMCD(width, height)

    return "${width / mcd}:${height / mcd}"
}

fun getMCD(of: Int, and: Int): Int {
    var a = of
    var b = and
    while (b != 0) {
        val temp = b
        b = a % b
        a = temp
    }
    return a
}
