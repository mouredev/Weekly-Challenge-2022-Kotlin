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

        println("------------TRIANGLE-------------")
        createFigure(10 ,Figure.TRIANGLE)
        println("------------SQUARE-------------")
        createFigure(10 ,Figure.SQUARE)

}
enum class Figure(){
        SQUARE, TRIANGLE
}

fun createFigure(sideSize: Int, figura:Figure) {
        when(figura){

                Figure.SQUARE -> makeSquare(sideSize)
                Figure.TRIANGLE -> makeTriangle(sideSize)
        }
}


fun makeSquare(sideSize: Int){


        var yaxis = 0
        var xaxis = 1
        while(yaxis<sideSize)
        {
                if(xaxis<sideSize) {
                        print("*")
                        xaxis++
                }
                else
                {
                        yaxis++
                        xaxis=1
                        println("*")
                }

        }
}

fun makeTriangle(sideSize: Int){

        var yaxis = 0
        var pointerX = 0
        var astCount = 1
        while(yaxis<sideSize)
        {
                if(pointerX<astCount) {
                        print("*")
                }
                else {
                        print(" ")
                }
                pointerX++
                if(pointerX>sideSize){
                        println("")
                        yaxis++
                        astCount++
                        pointerX =0
                }
        }
}
