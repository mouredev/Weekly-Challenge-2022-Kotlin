package com.openai.chat

/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función en Kotlin que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 * Resuelto: Sí
 * Iteracciones: 2
 * Explicación:
 * Conversación:
 * - Reemplazar los espacios y símbolos de puntuación con expresiones regulares
 *
 */
fun esPalindromo(texto: String): Boolean {
    // Eliminar espacios en blanco y signos de puntuación del texto.
    val textoSinEspacios = texto.replace(Regex("[\\s,\\.¡!¿?]"), "")

    // Sustituir las vocales acentuadas por sus versiones sin acento.
    val textoSinTildes = textoSinEspacios.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u")

    // Convertir el texto a minúsculas.
    val textoMinusculas = textoSinTildes.toLowerCase()

    // Invertir el texto.
    val textoInvertido = textoMinusculas.reversed()

    // Comparar el texto original con su inversión.
    return textoMinusculas == textoInvertido
}

fun main() {
    println(esPalindromo("Ana lleva al oso la avellana."))  // Imprime "true"
    println(esPalindromo("Hola mundo!"))                    // Imprime "false"

    // Brais cases
    println(esPalindromo("Adivina ya te opina, ya ni miles origina, ya ni cetro me domina, ya ni monarcas, a repaso ni mulato carreta, acaso nicotina, ya ni cita vecino, anima cocina, pedazo gallina, cedazo terso nos retoza de canilla goza, de pánico camina, ónice vaticina, ya ni tocino saca, a terracota luminosa pera, sacra nómina y ánimo de mortecina, ya ni giros elimina, ya ni poeta, ya ni vida")) // Imprime "true"
    println(esPalindromo("¿Qué os ha parecido el reto?"))   // Imprime "false"

    // Jaime cases
    println(esPalindromo("Allí ves Sevilla"))   // Imprime "true"
}

