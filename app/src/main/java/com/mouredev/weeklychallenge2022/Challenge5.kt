package com.mouredev.weeklychallenge2022

<<<<<<< HEAD
import android.graphics.BitmapFactory
import androidx.core.graphics.get
import com.squareup.picasso.Picasso
import java.net.URL

=======
>>>>>>> origin/main
/*
 * Reto #5
 * ASPECT RATIO DE UNA IMAGEN
 * Fecha publicación enunciado: 01/02/22
 * Fecha publicación resolución: 07/02/22
 * Dificultad: DIFÍCIL
 *
<<<<<<< HEAD
 * Enunciado: Crea un programa que se encargue de calcular y el aspect ratio de una imagen a partir de una url.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 */

fun main() {
    println("Hola")
    val url = URL("https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png")
    println("$url")
    var bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
    //println("${bitmap.height}")


}
=======
 * Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
 * - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
 * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
 *
 *
 */
>>>>>>> origin/main
