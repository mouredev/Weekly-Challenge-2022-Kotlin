package com.mouredev.weeklychallenge2022

/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    pascalTriangle(size = 1)
    pascalTriangle(size = 5)
    pascalTriangle(size = 10)
    pascalTriangle(size = 15)
}

fun pascalTriangle(size: Int) {
    if (size < 1) {
        println("Size should be bigger than 0!")
    }

    val list = mutableListOf<MutableList<String?>>()
    repeat(size) {
        val row = mutableListOf<String?>()
        list += row
    }

    (1..size).forEachIndexed { index, i ->
        if (i == 1) {
            repeat(size - 1) { list[index].add(" ") }
            list[index].add("1")
            repeat(size - 1) { list[index].add(" ") }
        } else {
            if (size - i != 0) {
                repeat(size - i) { list[index].add(" ") }
            }

            if (i % 2 == 0) {
                val halfLine = i / 2
                for (current in halfLine downTo 1) {
                    if (i / current == 2 && i % current == 0) {
                        list[index].add("1")
                        list[index].add(" ")
                    } else {
                        val place = size - (current * 2)
                        val num = sendNum(list[index - 1][place - 1]) +
                                sendNum(list[index - 1][place + 1])
                        list[index].add(num.toString())
                        list[index].add(" ")
                    }
                }
                for (current in 1..halfLine) {
                    if (i / current == 2 && i % current == 0) {
                        list[index].add("1")
                    } else {
                        val place = size - (current * 2)
                        val num = sendNum(list[index - 1][place - 1]) +
                                sendNum(list[index - 1][place + 1])
                        list[index].add(num.toString())
                        list[index].add(" ")
                    }
                }
            } else {
                val halfLine = i / 2
                for (current in halfLine downTo 0) {
                    if (current * 2 + 1 == i) {
                        list[index].add("1")
                        list[index].add(" ")
                    } else {
                        val place = size - (current * 2) - 1
                        val num = sendNum(list[index - 1][place - 1]) +
                                sendNum(list[index - 1][place + 1])
                        list[index].add(num.toString())
                        list[index].add(" ")
                    }
                }
                for (current in 1..halfLine) {
                    if (current * 2 + 1 == i) {
                        list[index].add("1")
                    } else {
                        val place = size - (current * 2) - 1
                        val num = sendNum(list[index - 1][place - 1]) +
                                sendNum(list[index - 1][place + 1])
                        list[index].add(num.toString())
                        list[index].add(" ")
                    }
                }
            }

            if (size - i != 0) {
                repeat(size - i) { list[index].add(" ") }
            }
        }
    }
    list.forEach {
        println(it)
    }
}

fun sendNum(str: String?): Int {
    return if (str == " ") {
        0
    } else {
        str?.toInt() ?: 0
    }
}