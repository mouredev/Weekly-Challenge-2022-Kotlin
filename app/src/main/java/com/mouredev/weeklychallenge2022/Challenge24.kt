package com.mouredev.weeklychallenge2022

/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    forMethod()
    whileMethod()
    doWhileMethod()
    recursiveMethod(num = 1)
    recursiveInDepthMethod(num = 100)
    forEachMethod()
    repeatMethod()
    iteratorMethod()
    artMethod()
}



// 1 - For loop method
private fun forMethod() {
    "For Method".printTitle()
    for (i in 1..100) count(i)
}

// 2 - While Method
private fun whileMethod() {
    var cont = 1
    "While Method".printTitle()
    while (cont <= 100) count(cont++)
}

// 3 - Do While Method
private fun doWhileMethod() {
    var cont = 1
    "Do While Method".printTitle()
    do count(cont++) while (cont <= 100)
}

// 4 - Recursive Method
private fun recursiveMethod(num: Int, showTitle: Boolean = true) {
    if(showTitle) "Recursive Method".printTitle()
    count(num)
    if(num < 100) recursiveMethod(num = num + 1, showTitle = false)
}

// 5 - Recursive in depth Method
private fun recursiveInDepthMethod(num: Int, showTitle: Boolean = true) {
    if(showTitle) "Recursive In Depth Method".printTitle()
    if(num != 1) recursiveInDepthMethod(num = num - 1, showTitle = false)
    count(num)
}

// 6 - Foreach Method
private fun forEachMethod() {
    "For Each Method".printTitle()
    (1..100).forEach { i ->
        count(i)
    }
}

// 7 -  Repeat Method
private fun repeatMethod() {
    "Repeat Method".printTitle()
    repeat(100) {
        count(it + 1)
    }
}

// 8 - Iterator Method
private fun iteratorMethod() {
    "Iterator Method".printTitle()
    val iterator = (1..100).iterator()
    while(iterator.hasNext()) count(iterator.next())
}

//
private fun artMethod() {
    "Ascii art Method".printTitle()
    val stream = Stream()
    (1..100).forEach { i ->
        stream.addStream(countArt(i))
    }
    stream.print()
}

private fun count(num: Int) {
    print(num)
    if(num != 100) print(", ") else println()
}

private fun String.printTitle() {
  println("##### $this #####")
}

private fun countArt(num: Int): Stream {
    val text = num.toString()
    val stream = Stream()
    text.forEach { char ->
        stream.addStream(digits[char.digitToInt()])
    }
    if(num != 100) stream.addStream(comma)
    return stream
}



val zero = Stream(
    " ███████ ",
    " ██   ██ ",
    " ██   ██ ",
    " ██   ██ ",
    " ███████ "
)
val one = Stream(
    "     ██  ",
    "     ██  ",
    "     ██  ",
    "     ██  ",
    "     ██  "
)

val two = Stream(
    " ███████ ",
    "      ██ ",
    " ███████ ",
    " ██      ",
    " ███████ "
)

val three = Stream(
    " ███████ ",
    "      ██ ",
    " ███████ ",
    "      ██ ",
    " ███████ "
)

val four = Stream(
    " ██   ██ ",
    " ██   ██ ",
    " ███████ ",
    "      ██ ",
    "      ██ "
)

val five = Stream(
    " ██████ ",
    " ██     ",
    " ██████ ",
    "     ██ ",
    " ██████ "
)

val six = Stream(
    " ███████ ",
    " ██      ",
    " ███████ ",
    " ██   ██ ",
    " ███████ "
)

val seven = Stream(
    " ███████ ",
    "      ██ ",
    "      ██ ",
    "      ██ ",
    "      ██ "
)

val eighth = Stream(
    " ███████ ",
    " ██   ██ ",
    " ███████ ",
    " ██   ██ ",
    " ███████ "
)

val nine = Stream(
    " ███████ ",
    " ██   ██ ",
    " ███████ ",
    "      ██ ",
    " ███████ "
)

val comma = Stream(
    "       ",
    "       ",
    "       ",
    "   █   ",
    "  █    "
)

val digits: List<Stream> = listOf(zero, one, two, three, four, five, six, seven, eighth, nine)

data class Stream(
    var str1: String = "",
    var str2: String = "",
    var str3: String = "",
    var str4: String = "",
    var str5: String = ""
) {
    fun print() {
        println(str1)
        println(str2)
        println(str3)
        println(str4)
        println(str5)
    }

    fun addStream(stream: Stream) {
        this.str1 += stream.str1
        this.str2 += stream.str2
        this.str3 += stream.str3
        this.str4 += stream.str4
        this.str5 += stream.str5
    }
}

