package com.openai.chat

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa en Kotlin que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Resuelto: Sí.
 * Iteracciones: 1
 * Explicación: Este código utiliza un mapa (también conocido como diccionario) para almacenar las palabras y su recuento. Luego, itera sobre cada palabra de la frase ingresada por el usuario,
 * elimina los signos de puntuación y convierte la palabra a minúsculas. Después, si la palabra ya existe en el mapa, aumenta su recuento en 1, de lo contrario, agrega la palabra al mapa
 * con un recuento de 1. Finalmente, se muestra el recuento final de cada palabra.
 * Nota: si se le pide un programa no suele implementar una función reusable a llamar desde el main.
 *
 */

fun main() {
    val frase = "Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev)."
//    val frase = "Hola Brais, yo no me llamo brais."

    // Creamos un mapa (diccionario) para almacenar las palabras y su recuento
    val palabras = mutableMapOf<String, Int>()

    // Dividimos la frase en palabras usando el espacio como separador
    val palabrasFrase = frase.split(" ")

    // Iteramos sobre cada palabra de la frase
    for (palabra in palabrasFrase) {
        // Eliminamos los signos de puntuación de la palabra
        val palabraLimpia = palabra.replace(",", "").replace(".", "").replace("!", "").replace("?", "")

        // Convertimos la palabra a minúsculas para que no se consideren palabras diferentes
        // si solo varía en mayúsculas y minúsculas
        val palabraMinusculas = palabraLimpia.toLowerCase()

        // Si la palabra ya existe en el mapa, aumentamos su recuento en 1
        // Si no existe, agregamos la palabra al mapa con un recuento de 1
        palabras[palabraMinusculas] = (palabras[palabraMinusculas] ?: 0) + 1
    }

    // Mostramos el recuento final de cada palabra
    for ((palabra, recuento) in palabras) {
        println("$palabra se repite $recuento veces")
    }
}

