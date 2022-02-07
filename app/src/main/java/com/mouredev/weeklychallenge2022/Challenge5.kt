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

import java.io.ByteArrayOutputStream
import java.net.URL
import java.net.URLConnection
import java.nio.ByteBuffer
import java.nio.ByteOrder

data class Size(val width: Int = 0, val height: Int = 0)

fun main() {
  val imageURL = "https://wallpapercave.com/wp/wp6079265.png"
  //val imageURL = "https://avatarfiles.alphacoders.com/286/thumb-1920-286386.png"
  //val imageURL = "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"
  //val imageURL = "https://wallpapercave.com/wp/wp6058379.png"

  val size = getSizeImage(imageURL)
  val aspectRatio = getAspectRatio(size.width, size.height)
  println(aspectRatio)
}

fun getAspectRatio(width: Int, height: Int): String {
  val r = getGCD(width, height)

  return "${width/r}:${height/r}"
}

fun getGCD(width: Int, height: Int): Int{
  if (height == 0) {
    return width
  }

  return getGCD(height, width % height)
}

fun getSizeImage(urlStr: String): Size {
  val url = URL(urlStr)
  val output = ByteArrayOutputStream()
  val conn: URLConnection = url.openConnection()
  conn.getInputStream().use { inputStream ->
    var n = 0
    val buffer = ByteArray(1024)
    while (-1 != inputStream.read(buffer).also { n = it }) {
      output.write(buffer, 0, n)
    }
  }

  val buffer = output.toByteArray()

  if (isPNG(buffer)) {
    val bufferWidth = ByteArray(4)
    val bufferHeight = ByteArray(4)

    var firstW = 16
    var lastW = 19

    var firstH = 20
    var lastH = 23

    if (isPNGFried(buffer)) {
      firstW = 32
      lastW = 35

      firstH = 36
      lastH = 39
    }

    var index = 0
    for (i in firstW..lastW) {
      val b = buffer[i]
      bufferWidth[index] = b
      index += 1
    }

    index = 0
    for (i in firstH..lastH) {
      val b = buffer[i]
      bufferHeight[index] = b
      index += 1
    }

    val width = getUInt32BE(bufferWidth)
    val height = getUInt32BE(bufferHeight)

    return Size(width, height)
  }

  println("El formato de la imagen no es soportada o PNG no soportado")

  return Size()
}


fun getUInt32BE(payload: ByteArray?): Int {
  val buffer: ByteBuffer = ByteBuffer.wrap(payload)
  buffer.order(ByteOrder.BIG_ENDIAN)
  return buffer.int
}



fun isJPEG() {
  // F, no me dio tiempo
}


fun isPNG(buffer: ByteArray): Boolean {
  val pngSignature = byteArrayOf(80, 78, 71, 13, 10, 26, 10)
  val pngFriedChunk = byteArrayOf(73, 72, 68, 82)
  val pngImageHeaderChunk = byteArrayOf(67, 103, 66, 73)

  val bufferSignature = ByteArray(7)

  var index = 0
  for (i in 1..7) {
    val b = buffer[i]
    bufferSignature[index] = b
    index += 1
  }

  val isSignature: Boolean = bufferSignature.contentEquals(pngSignature)
  if (!isSignature) {
    return false
  }

  val bufferChunk = ByteArray(4)

  index = 0
  for (i in 12..15) {
    val b = buffer[i]
    bufferChunk[index] = b
    index += 1
  }

  val isFried: Boolean = bufferChunk.contentEquals(pngFriedChunk)

  index = 0
  for (i in 28..31) {
    val b = buffer[i]
    bufferChunk[index] = b
    index += 1
  }

  val isImage: Boolean = bufferChunk.contentEquals(pngImageHeaderChunk)

  if (!isFried && !isImage) {
    return false
  }

  return true
}

fun isPNGFried(buffer: ByteArray): Boolean {
  val pngFriedChunk = byteArrayOf(73, 72, 68, 82)
  val bufferChunk = ByteArray(4)

  var index = 0
  for (i in 12..15) {
    val b = buffer[i]
    bufferChunk[index] = b
    index += 1
  }

  val isFried: Boolean = bufferChunk.contentEquals(pngFriedChunk)
  if (isFried) {
    return false
  }

  return true
}