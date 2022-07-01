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

fun main(){
    Figures2D().printFigure(Figures2D.Options.SQUARE,7)
    Figures2D().printFigure(Figures2D.Options.TRIANGLE,3)
    Figures2D().printFigure(Figures2D.Options.INVERTED_TRIANGLE,2)
    Figures2D().printFigure(Figures2D.Options.TRIANGLE,10)
    Figures2D().printFigure(Figures2D.Options.DIAMOND,4)
    Figures2D().printFigure(Figures2D.Options.DIAMOND,6)
    Figures2D().printFigure(Figures2D.Options.INVERTED_TRIANGLE,5)
}

class Figures2D{
    enum class Options{
        SQUARE, TRIANGLE, DIAMOND, INVERTED_TRIANGLE;
    }

    private fun printHorizontalLine(size : Int) {
        repeat(size){
            print("*")
        }
        println()
    }

    private fun printSpacedHorizontalLine(size : Int) {
        val spaceRatio = (size*2)/size
        print(" ")
        for(x in 0 until size*2){
            if(x%spaceRatio==0 ) print("*")
            else print(" ")
        }
        println()
    }
    
    private fun printCone(_size : Int, isDiamond : Boolean) {
        // +1 por el 0 de inicio del for y 1 por le espacio del final
        var horizontalSize = _size*2+1

        // -2 por la base de linea recta e inicio de 0 en el for / o -1 si no hay base linea recta
        val verticalSize = if (isDiamond) {
            horizontalSize +=2
            _size -1
        } else {
            _size -2
        }

        for (y in 0..verticalSize){
            for(x in 0..horizontalSize){
                if (x == horizontalSize/2+y || x == horizontalSize/2-y) print("*")
                else print(" ")
            }
            println()
        }
    }

    private fun printInvertedCone(_size : Int, isDiamond : Boolean) {

        // +1 por el 0 de inicio del for y 1 por le espacio del final
        val horizontalSize = _size*2+1

        for (y in (_size-2) downTo 0){
            if (isDiamond) print(" ")
            for(x in 0..horizontalSize){
                if (x == horizontalSize/2+y || x == horizontalSize/2-y)
                    print("*")
                else print(" ")
            }
            println()
        }
    }

    private fun printSquare(size : Int){
        fun printParallelSquareBody(size: Int){
            repeat(size-2){
                print("*")
                repeat(size-2){
                    print(" ")
                }
                print("*")
                println()
            }
        }

        // Actual printing
        printHorizontalLine(size)
        printParallelSquareBody(size)
        printHorizontalLine(size)
        println()
    }

    private fun printTriangle(size : Int){
        // Actual printing
        printCone(size, false)
        printSpacedHorizontalLine(size)
        println()
    }

    private fun printDiamond(size : Int){
        printCone(size, true)
        printInvertedCone(size, true)
        println()
    }

    private fun printInvertedTriangle(size : Int){
        // Actual printing
        printSpacedHorizontalLine(size)
        printInvertedCone(size, false)
        println()
    }

    fun printFigure(figure : Options, size : Int){
        when(figure){
            Options.SQUARE -> printSquare(size)
            Options.TRIANGLE -> printTriangle(size)
            Options.DIAMOND -> printDiamond(size)
            Options.INVERTED_TRIANGLE -> printInvertedTriangle(size)
        }
    }
}