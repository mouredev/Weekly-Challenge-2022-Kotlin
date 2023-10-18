/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 */

package retos

fun main() {
    println(findHandlers("@MoureDev es el hombre con la mejor barba del mundo. #barbaalpha"))
    println(findHandlers("Atentos con el calendario de @aDEViento. Más info en: https://adviento.dev"))
    println(findHandlers("#retos_de_programacion con @MoureDev. Todos los retos disponibles en https://retosdeprogramacion.com"))
    println(findHandlers("Aquí no hay nada extraño"))
}

/* Resultados:
[@MoureDev, #barbaalpha]
[@aDEViento, https://adviento.dev]
[@MoureDev, #retos_de_programacion, https://retosdeprogramacion.com]
[]
 */

fun findHandlers(text: String) : List<String> {
    val handlerRegex1 = "@\\w*".toRegex()
    val handlerRegex2 = "#\\w*".toRegex()
    val handlerRegex3 = "((http|https)://|www\\.)(\\w*)(\\.)(com|es|gob|gov|org|dev)".toRegex()
    return listOf(*handlerRegex1.getGroups(text), *handlerRegex2.getGroups(text), *handlerRegex3.getGroups(text))
}

fun Regex.getGroups(text: String): Array<String> {
    val results = this.findAll(text)
    val groups = mutableListOf<String>()
    results.forEach {
        groups.add(it.value)
    }
    return groups.toTypedArray()
}
