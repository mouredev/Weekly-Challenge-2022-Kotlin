package com.openai.chat

/*
 * Reto #17
 * LA CARRERA DE OBSTÁCULOS
 * Fecha publicación enunciado: 25/04/22
 * Fecha publicación resolución: 02/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función en Kotlin que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
 *        variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 *
 * Resuelto: Sí
 * Iteracciones: 6
 * Explicación: Esta función recibe dos parámetros: un array de String que representa las acciones que ha realizado el atleta (correr o saltar) y una String que representa la pista de la carrera
 * (con "|" para vallas y "_" para suelo). Recorre ambos elementos secuencialmente y, si se encuentra con una acción incorrecta en un tramo de la pista, modifica la pista y finaliza la función retornando false.
 * Si se han realizado todas las acciones correctamente, imprime la pista final y retorna true.
 * Conversación:
 * - Track debe tener el mismo número de caracteres que elementos en la lista de acciones
 * - Ponme un caso que devuelva true
 * - Pero cada segmento debe estar representado por un único carácter
 * - Comprueba que en el track que entra como parámetro solo llegan los símbolos "|" y "_" y que las acciones solo contienen "run" o "jump", en caso contrario devuelve false
 * - Muestra por pantalla siempre la pista final que representa las acciones de entrada, incluso cuando el resultado sea false
 *
 */

fun evaluateRace(actions: Array<String>, track: String): Boolean {
    // Comprobamos que el tamaño del array de acciones y la pista original coinciden
    if (actions.size != track.length) return false
    // Comprobamos que la pista solo contiene los símbolos "|" y "_"
    if (!track.all { it == '|' || it == '_' }) return false
    // Comprobamos que las acciones solo contienen "run" o "jump"
    if (!actions.all { it == "run" || it == "jump" }) return false

    // Creamos una variable para almacenar la pista final
    var modifiedTrack = track

    // Recorremos el array de acciones y la pista original para evaluar cada tramo
    for (i in actions.indices) {
        val action = actions[i]
        val segment = track[i]

        // Si el atleta hace "jump" en "_" (suelo) o "run" en "|" (valla), la carrera se ha fallado
        if ((action == "jump" && segment == '_') || (action == "run" && segment == '|')) {
            // Si se ha fallado, modificamos la pista en ese tramo
            if (segment == '_') modifiedTrack = modifiedTrack.substring(0, i) + "x" + modifiedTrack.substring(i + 1)
            else modifiedTrack = modifiedTrack.substring(0, i) + "/" + modifiedTrack.substring(i + 1)
            // Finalizamos la función con un resultado negativo
            return false
        }
    }

    // Si se ha llegado hasta aquí es porque se han realizado todas las acciones correctamente
    // Mostramos la pista final y retornamos un resultado positivo
    print(modifiedTrack)
    return true
}

fun main() {
    val actions1 = arrayOf("run", "jump", "run", "jump")
    val track1 = "____|___|_"
    println(evaluateRace(actions1, track1)) // false

    val actions4 = arrayOf("run", "jump", "run", "jump", "run", "jump", "run", "jump")
    val track4 = "____|___|_______|___|_"
    println(evaluateRace(actions4, track4)) // false
    
    // Brais cases
    println(evaluateRace(arrayOf("run", "jump", "run", "jump", "run"), "_|_|_"))    // true
    println(evaluateRace(arrayOf("run", "run", "run", "jump", "run"), "_|_|_"))     // false
    println(evaluateRace(arrayOf("run", "run", "jump", "jump", "run"), "_|_|_"))    // false
    println(evaluateRace(arrayOf("run", "run", "jump", "jump", "run"), "_|_|_|_"))  // false
    println(evaluateRace(arrayOf("run", "jump", "run", "jump"), "_|_|_"))           // false
    println(evaluateRace(arrayOf("run", "jump", "run", "jump", "run", "jump", "run"), "_|_|_")) // false
    println(evaluateRace(arrayOf("jump", "jump", "jump", "jump", "jump"), "|||||")) // true
    println(evaluateRace(arrayOf("jump", "jump", "jump", "jump", "jump"), "||?||")) // false
}

