package com.mouredev.weeklychallenge2022

/**
 * Vamos a indicar si un número es primo 
 * vamos a suponer que los valores que se introducen son naturales 
 */

import kotlin.math.*

fun main() {
	
    var n = 104729
    
    if (primo(n)){
        println("$n es primo")
    }else{
        println("$n no es primo")
        }
        
    println("los números primos hasta $n son:")
    for(i in 1..n){
        if (primo(i)) println("$i")
    }
}

private fun primo(num: Int): Boolean{
    var cont = 0 //cuenta las veces que un número es divisible, es decir que da de resto 0
    var raiz = sqrt(num.toDouble()).toInt() //pasamos el número introducido a Double para realizar la raiz cuadrada
    
    //hacemos un recorrido desde el 1 hasta la raiz, debido a propiedades de los número primos
    //que me indican que sólo he de probar si es divisible desde el 1 hasta la raiz de dicho número
    //Si da de resto cero incrementamos el contador
    for(i in 1..raiz){
        if(num%i==0) cont++
    }
    
    //Si el contador es menor de 2 significa que el número sólo ha sido divisible
    //por dos números, es decir, entre 1 y entre si mismo, por lo que SI es primo
    
    if(cont<2) return true
    else return false
}
	


