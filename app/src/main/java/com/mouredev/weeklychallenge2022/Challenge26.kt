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


/**
 * Enumerado que contiene las figuras posibles
 */
enum class Figures(val value :String) {
    SQUARE("1"),
    TRIANGLE("2"),
    CIRCLE("3");

    companion object {
        fun getFigure(value: String): Figures {
            return when (value) {
                "1" -> SQUARE
                "2" -> TRIANGLE
                "3" -> CIRCLE
                else -> throw IllegalArgumentException("Opcion invalida")

            }
        }
    }

}


/**
 * Funcion Principal
 */
fun main() {

    figures()

}


/**
 * Funcion que imprime el menu de opciones y solicita la opcion del usuario para pintar la figura
 */
fun figures() {

    var option = ""

    while(option!="0") {
        println()
        println("************** FIGURAS *****************************")
        println()
        println("1. Cuadrado")
        println("2. Triangulo")
        println("3. Circulo")
        println("0. Salir ")
        println("Ingrese el tipo de figura a dibujar: ")
        option = readLine()!!

        if(option=="0"){

            println("Gracias por usar el programa")
        } else {

            println("Ingrese el tamaño: ")

            val size = readLine()!!.toInt()

            when (Figures.getFigure(option)) {
                Figures.SQUARE -> drawSquare(size)
                Figures.TRIANGLE -> drawTriangle(size)
                Figures.CIRCLE -> drawCircle(size)


            }

        }

    }
}

/**
 * Funcion que dibuja un triangulo con asteriscos de un tamaño determinado
 * @param size tamaño del triangulo
 */
fun drawTriangle(size: Int) {


    println("******* TRIANGULO ********")
    println()


    for (i in 0..size) {

        for (j in 0..(size-1-i)) {
            print(" ")
        }

        for (j in 0..(i*2)) {
            print("*")
        }

        println()
    }
}

/**
 * Funcion que dibuja un cuadrado con asteriscos de un tamaño determinado
 * @param size tamaño del cuadrado
 */

fun drawSquare(size: Int) {

    println("******* CUADRADRO ********")
    println()

    for (i in 1..size) {
        for (j in 1..size) {
            if(i==1 || i==size || j==1 || j==size) {
                print("**")
            } else {
                print("**")
            }
        }
        println()
    }
}


/**
 * Funcion que dibuja un circulo con asteriscos de un tamaño determinado
 * @param radius tamaño del circulo
 */
fun drawCircle(radius:Int){


    println("******* CIRCULO ********")
    println()

    val formuleRadius = -radius*4/3
    for (y in -radius..radius) {
        for (x in -radius..radius) {
            val circle = (x * x + y * y) / radius.toDouble() - radius

            if (circle > formuleRadius && circle < 1) {
                print("**")
            } else {
                print("  ")
            }
        }

        println()

    }

}

