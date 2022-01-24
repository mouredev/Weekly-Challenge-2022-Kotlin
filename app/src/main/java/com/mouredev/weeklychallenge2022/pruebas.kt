package com.mouredev.weeklychallenge2022

fun main() {

    (2..100).forEach(){

        if(primeNumber(it))

            //print("$it, ")

        print("")

    }

}




private fun primeNumber(number : Int): Boolean {




    var isPrime = true




    for (i in 2..number / 2) {

        if (number % i == 0) {

            isPrime = false


        }
        println("number es $number y la i es $i")
    }

    return isPrime

}