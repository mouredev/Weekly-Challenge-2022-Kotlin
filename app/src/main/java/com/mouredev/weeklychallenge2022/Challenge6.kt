package com.mouredev.weeklychallenge2022

fun main() {
    println("We start picking".reverse())
}

private fun String.reverse() : String {

    var stringReversed = ""

    this.forEachIndexed { index, _ ->
        stringReversed = "${this[index]}$stringReversed"
    }

    return stringReversed
}
