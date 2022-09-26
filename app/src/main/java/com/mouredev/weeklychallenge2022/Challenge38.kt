package com.mouredev.weeklychallenge2022

/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main(){
    //determinamos el formato, si es int lo convertimos en string
    var binario=100101
    var binarioS:String = binario.toString()
    println("el numero binario es " + binarioS)
    //cantidad de digitos del numero binario y le restamos 1 para el exponente y lo convertimos en double para la funcion Math.pow()
    var pos=(binarioS.length-1).toDouble()
    var numDecimal=0
    //saltamos de numero a numero
    for	(num in binarioS){
        //println("$num  "+ "posicion $pos") --> con esta linea podemos verificar la posicion y el elemenot del numero binario
        //guardamos en una variable el resultado de 2 a la exponente "pos" y los convertimos en integer
        var expo=(Math.pow(2.0,pos)).toInt()
        // tuve problemas con el toInt asi que use una condicional comparando el char
        if (num=='0'){
            numDecimal=numDecimal+(0*expo)
        }
        if (num=='1'){
            numDecimal=numDecimal+(1*expo)
        }
        //restamos -1 para cambiar disminuir la posicion hasta llegar a la posicion 0
        pos-=1

    }
    print("el numero decimal es $numDecimal")

}