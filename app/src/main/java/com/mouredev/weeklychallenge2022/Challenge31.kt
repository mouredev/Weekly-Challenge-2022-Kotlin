package com.mouredev.weeklychallenge2022

/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(){
 leapYears(0)
}

fun isLeap(year : Int) = year%400 == 0 || (year%4 == 0 && year%100 != 0)

fun leapYears(year: Int){
    val toFindLeap = year..(year+4)
    var firstLeap : Int = 0
    toFindLeap.forEach { if (isLeap(it)) { firstLeap = it} }
    val thirtyYears = firstLeap..(firstLeap+120) step 4
    thirtyYears.forEach { if (isLeap(it)) println(it)}
}
