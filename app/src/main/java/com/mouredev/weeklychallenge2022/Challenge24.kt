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

// The gear functions are in reference to One Piece
fun main(){
    gearOne()
    gearTwo()
    gearThree()
    gearFourth()
    gearFive()
}

private fun gearOne(){
    for(x in 1..100){ print("$x ")}
    println()
}

private fun gearTwo(){
    var x = 1
    while (x <=100){
        print("${x++} ")
    }
    println()
}

private fun gearThree(){
    var x = 1
    repeat(100){
        print("${x++} ")
    }
    println()
}

// It is not the best practice but it is a little funnier
private fun gearFourth(){
    var x = 1
    var YaLlegamos = false
    while (YaLlegamos != true){
        if (x<=100){
            print("${x++} ")
        } else {
            YaLlegamos = true
        }
    }
    println()
}

// I haven't watch the latest episodes, I don't know if it gets to have a five transformation
private fun gearFive(){
    var x = 1
    do {
        print("${x++} ")
    } while (x<=100)
    println()
}
