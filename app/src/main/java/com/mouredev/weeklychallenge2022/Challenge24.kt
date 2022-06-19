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

fun main(){
   // firstCase()
   // secondCase()
   // thirdCase()
   // fourthCase()
   // fifthCase()
   // sixthCase()
}

private fun firstCase(){
    // con un for de toda la vida
    for(i in 1..100){
        println(i)
    }
}

private fun secondCase(){
    // con un bucle while
    var i = 1

    while(i <= 100){
        println(i)
        i += 1
    }
}

private fun thirdCase(){
    // bucle do-while
    var i = 1

    do{
        println(i)
        i += 1
    }while(i <= 100)
}

private fun fourthCase(){
    // for para agregar los numeros a una lista y despues un for para imprimir cada numero de esa lista
    var lista = arrayListOf(1)

    for(i in 2..100){
        lista.add(i)
    }

    for(i in lista){
        println(i)
    }
}

private fun fifthCase(){
    // for para agregar los numeros a una lista de forma decreciente y despues un for para imprimir cada numero de esa lista revertida
    var lista = arrayListOf(100)

    for(i in 99 downTo 1){
        lista.add(i)
    }

    for(i in lista.reversed()){
        println(i)
    }
}

private fun sixthCase(){
    // de 1 a 100 crear un array de numeros impares y pares, posterior mente unir ambos y ordenarlos, recorrer el array e imprimir cada valor en él
    val even = arrayListOf<Int>()
    val odd = arrayListOf<Int>()
    for(i in 1..100){
        if(i % 2 == 0){
            even.add(i)
        }
        if(i % 2 != 0){
            odd.add(i)
        }
    }

    odd.addAll(even)
    odd.sort()

    for(i in odd){
        println(i)
    }
}
