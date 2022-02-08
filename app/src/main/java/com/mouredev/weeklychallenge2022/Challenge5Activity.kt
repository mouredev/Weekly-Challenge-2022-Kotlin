package com.mouredev.weeklychallenge2022

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URL
import kotlin.math.roundToInt

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

class Challenge5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AspectRatio().getAspectRatio("https://www.1zoom.me/big2/515/304708-blackangel.jpg")

    }

    class AspectRatio {

        fun getAspectRatio(url: String) {

            var aspectRatioString: String? = null

            Thread {
                val url = URL(url)
                val bitmap = BitmapFactory.decodeStream(url.openStream())

                val aspectRatio = convertNumberToRationalNumber(bitmap.height.toDouble() / bitmap.height.toDouble())
                aspectRatioString = "${aspectRatio.second}:${aspectRatio.first}"

                aspectRatioString?.let { ratio ->
                    println("The aspect ratio is: $ratio")
                } ?: run {
                    println("Cannot obtain aspect ratio")
                }

            }.start()
        }

        data class Quadruple(val h1: Int, val k1: Int, val h: Int, val k: Int)

        private fun convertNumberToRationalNumber(aspectRatio: Double): Pair<Int, Int> {
            val precision = 1.0E-6
            var x = aspectRatio
            var a = x.roundToInt()
            var q = Quadruple(1, 0, a, 1)

            while (x - a > precision * q.k.toDouble() * q.k.toDouble()) {
                x = 1.0 / (x - a)
                a = x.roundToInt()
                q = Quadruple(q.h, q.k, q.h1 + a * q.h, q.k1 + a * q.k)
            }
            return Pair(q.h, q.k)
        }

    }
}

