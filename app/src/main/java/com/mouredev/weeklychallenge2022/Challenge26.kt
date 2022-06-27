package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun drawChristmasTree(size: Int, year: Int){
    val congrats = listOf("Feliz y Próspero Año $year",
        "Heureux et prospère année $year",
        "Happy and prosperous year $year")
    IntRange(1, size).map{r ->
        println(if (r % 4 == 0 || r > 26)
            "**".padStart(size + 1)
        else
            "*".repeat(r).repeat(2).padStart(size + r))
    }

    congrats.map { c -> println(c.padStart(size + c.length/2))}

    println()
}

fun drawSquare(length: Int, filled: Boolean){
    println("Cuadrado ${length}x${length}")
    IntRange(1, length).map { row ->
        val border = row == 1 || row == length
        println("*  ${"*  ".repeat(length - 2).replace("*", if(filled || border) "*" else " ")}*")
    }

    println()
}

fun drawTriangle(length: Int, inverted: Boolean, filled: Boolean){
    println("Triángulo Equilátero Base $length} (${if(inverted) "" else "NO "}Invertido) Relleno: $filled")
    val triangleRows = IntRange(1, length).map { row ->
        val vertex = row == 1
        val line = row == length
        val preLast = row == 2
        val endRowText = if (vertex) "" else " |"
        val pad = length - row
        val leftPad = if (pad > 0) " " else ""

        val rowContent = if (vertex || preLast)
                            ""
                         else if (line)
                            " *".repeat(length - 2)
                         else
                            " *".repeat(row - 2).replace("*", if (filled) "*" else " ")

        "${leftPad.padStart(pad)}|$rowContent$endRowText".replace("|", "*")
    }

    if (inverted)
        triangleRows.reversed().forEach { x -> println(x) }
    else
        triangleRows.forEach { x -> println(x) }

    println()
}

fun drawDiamond(width: Int, filled: Boolean){
    val triangleRows = IntRange(1, width).map { row ->
        val vertex = row == 1
        val line = row == width
        val preLast = row == 2
        val endRowText = if (vertex) "" else " |"
        val pad = width - row
        val leftPad = if (pad > 0) " " else ""

        val rowContent = if (vertex || preLast)
            ""
        else if (line)
            " *".repeat(width - 2).replace("*", if (filled) "*" else " ")
        else
            " *".repeat(row - 2).replace("*", if (filled) "*" else " ")

        "${leftPad.padStart(pad)}|$rowContent$endRowText".replace("|", "*")
    }

    println("Rombo Base $width Relleno: $filled")

    val inverted = triangleRows.subList(0, triangleRows.size - 1).asReversed()


    triangleRows.forEach { x -> println(x) }
    inverted.forEach { x -> println(x) }
}

fun main(){
    drawSquare(5, filled = true)
    drawSquare(5, filled = false)
    drawTriangle(5, inverted = false, true)
    drawTriangle(4, inverted = true, false)

    drawDiamond(5, true)
    drawDiamond(6, false)

    drawChristmasTree(20, 2022)
}