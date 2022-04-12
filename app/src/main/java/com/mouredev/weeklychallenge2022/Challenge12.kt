package com.example.weeklychallenge2022

/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    var expres1 = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme..."
    println(expres1)

    println(esPalindromo(expres1))
    expres1 = "Allí por la tropa portado, traído a ese paraje de maniobras, una tipa como capitán usar boina me dejara, pese a odiar toda tropa por tal ropilla"
    println(expres1)
    println(esPalindromo(expres1))
    expres1 = "á"
    println(expres1)
    println(esPalindromo(expres1))
}


private fun esPalindromo (str1: String) : Boolean {
    val sinAcent = mapOf("á" to "a", "é" to "e", "í" to "i","ó" to "o", "ú" to "u",
        "â" to "a", "ê" to "e", "î" to "i", "ô" to "o", "û" to "u",
        "à" to "a", "è" to "e", "ì" to "i", "ò" to "o", "ù" to "u",
        "ä" to "a", "ë" to "e", "ï" to "i", "ö" to "o", "ü" to "u")

    var respString=""
    val result = str1.filter { it -> it.isLetter() } // quita lo que no sean letras
    result.lowercase().forEach {
        respString += if (!sinAcent.containsKey(it.toString())) {
            it.toString()
        } else {
            sinAcent[it.toString()]
        }
    }
    val reverse = respString.reversed()
    /*var reverse =""   //tradicional
    (respString.length-1 downTo 0).forEach { i ->
        reverse+= respString[i]
    }*/
    return reverse == respString


}
/*
import java.text.Normalizer
fun main() {
    println(isPalindrome("Ana lleva al oso la avellana."))
    println(isPalindrome("Adivina ya te opina, ya ni miles origina, ya ni cetro me domina, ya ni monarcas, a repaso ni mulato carreta, acaso nicotina, ya ni cita vecino, anima cocina, pedazo gallina, cedazo terso nos retoza de canilla goza, de pánico camina, ónice vaticina, ya ni tocino saca, a terracota luminosa pera, sacra nómina y ánimo de mortecina, ya ni giros elimina, ya ni poeta, ya ni vida"))
    println(isPalindrome("¿Qué os ha parecido el reto?"))
}

private fun isPalindrome(text: String): Boolean {

    val normalizedText = Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD)
        .replace("[^\\p{ASCII}]".toRegex(), "")
        .replace("[^a-z0-9]".toRegex(), "")
    return normalizedText == normalizedText.reversed()
}
*/