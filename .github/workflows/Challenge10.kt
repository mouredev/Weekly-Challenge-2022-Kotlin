package com.example.reto_10
/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/*
* Lo he hecho implementado una pila con un array y la funcion devuelve un boolean, la pila se va llenando con los carateres de apertura
*  y en el momento que encuentra uno de cierre comprueba se es el que esta en lo alto de la pila. Si lo es lo borra
*  y si no pone al boolean a false y se sale del bucle.
*  También compruebo que si lo primero que encuentra es un caracter de cierre y la pila esta vacia el boolean es falso
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }
}
fun main() {
    var expresion = "{ [ a * ( c + d ) ] - 5 }"
    println(expresion +": "+ comprobacion(expresion))
    expresion = "{ a * ( c + d ) ] - 5 }"
    println(expresion +": "+ comprobacion(expresion))
    expresion = "{ [ a * ( c + d ) ] - 5"
    println(expresion +": "+ comprobacion(expresion))
    expresion = "} a * ( c + d ) ] - 5 }"
    println(expresion +": "+ comprobacion(expresion))
}


private fun comprobacion (input: String): Boolean {

    var balanceado = true

    val pila = arrayListOf<String>()

    for (caracter in input){
        when (caracter.toString()) {
            "{","(","[" ->{
                pila.add(caracter.toString())
            }
            "]" ->{
                if (pila.size !=0){
                    if (pila[pila.lastIndex] == "["){
                        pila.removeLast()
                    } else {
                        balanceado=false
                        break
                    }
                }else{
                    balanceado=false
                    break
                }
            }
            "}" ->{
                if (pila.size !=0){
                    if (pila[pila.lastIndex] == "{"){
                        pila.removeLast()
                    } else {
                        balanceado=false
                        break
                    }
                }else{
                    balanceado=false
                    break
                }
            }
            ")" ->{
                if (pila.size !=0){
                    if ( pila[pila.lastIndex] == "("){
                        pila.removeLast()
                    } else {
                        balanceado=false
                        break
                    }
                }else{
                    balanceado=false
                    break
                }
            }
        }
    }
    if (pila.size !=0){
        balanceado = false
    }
    return balanceado
}
