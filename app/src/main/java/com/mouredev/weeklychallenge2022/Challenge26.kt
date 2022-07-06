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
 
fun main() {
    print("Enter a shape [square, rectangle, triangle, reversedTriangle]: ")

    when(val shape = readLine()?.lowercase()) {
        "square" -> {
            val num = readNum("Enter a square side: ") ?: return
            drawSquare(num)
        }
        "rectangle" -> {
            val width = readNum("Enter rectangle width: ") ?: return
            val height = readNum("Enter rectangle height: ") ?: return
            drawRectangle(width, height)
        }
        "triangle", "reversedtriangle" -> {
            val side = readNum("Enter the triangle side: ") ?: return
            if(shape == "triangle"){
                drawTriangle(side)
            }else {
                drawReversedTriangle(side)
            }
        }
        else -> {
            print("Ciao")
        }
    }
}

fun readNum(message: String): Int? {
    print(message)
    return readLine()?.toIntOrNull()
}

fun drawSquare(side: Int) {
    val string = "*  ".repeat(side)

    for(i in 0 until side){
        println(string)
    }
}

fun drawRectangle(width: Int, height: Int) {
    for(i in 0 until height) {
        println("* ".repeat(width))
    }
}

fun drawTriangle(side: Int) {
    for(i in 1..side){
        println("* ".repeat(i))
    }
}

fun drawReversedTriangle(side: Int) {
    for(i in side downTo 1){
        println("* ".repeat(i))
    }
}
