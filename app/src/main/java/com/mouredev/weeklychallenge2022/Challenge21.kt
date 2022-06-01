package com.mouredev.weeklychallenge2022

import java.io.File
import java.util.*

/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/**
 * Enumerado que identifica el tipo de operador
 *
 */
enum class Operation(val value:String,val priority : Int) {
    Plus("+",0),
    Minus("-",0),
    Multiply("*",1),
    Divide("/",1),
    None("",-1)

}


/**
 * Funcion Principal
 */
fun main(){

    val filePath = File("\\app\\src\\main\\java\\com\\mouredev\\weeklychallenge2022\\Challenge21.txt")
    val path = System.getProperties().getProperty("user.dir") + filePath
    val operadores = readFile(path)

    val value = shuntingYard(operadores)
    if(value!=null)
        println("Resultado: $value")
    else
        println("El resultado no se ha podido evaluar")


}

/**
 * Metodo que lee un fichero linea a linea
 * @param fileName Ruta del fichero
 * @return Lista de Strings con las lineas del fichero
 */
fun readFile(fileName: String): List<String> {
    val file = File(fileName)
    return file.readLines()
}

/**
 * Funcion que convierte una lista de operaciones en una lista de operaciones en notacion polaca inversa
 * Utilizando el algoritmo de Shunting Yard
 * @param lines lista de operaciones
 * @return lista de operaciones en notacion polaca inversa
 */
fun shuntingYard(lines: List<String>): Double? {

    val stack = Stack<Operation>()
    val output = arrayListOf<String>()

    lines.forEach {

        if (it.isNumber()) {
            output.add(it)
        } else {
            if (it.isOperator()) {
                if (stack.isNotEmpty()) {
                    output.add(stack.pop().value)
                    stack.add(it.toOperation())
                } else {
                    stack.add(it.toOperation())
                }
            }
        }
    }

        while (stack.isNotEmpty()){
        output.add(stack.pop().value)
    }


    return evalExpresionInfix(output)


}


/**
 * Funcion que evalua una expresion en notacion polaca inversa
 * @param expresion lista de operaciones en notacion polaca inversa
 * @return resultado de la expresion
 */
fun evalExpresionInfix(expresion:List<String>): Double? {

    val stack = Stack<String>()

    try {


        expresion.forEach {

            if (it.isNumber()) {
                stack.add(it)
            } else {
                if (it.isOperator()) {
                    val secondNumber = stack.pop().toDouble()
                    val firstNumber = stack.pop().toDouble()
                    val result = when (it) {
                        Operation.Plus.value -> firstNumber + secondNumber
                        Operation.Minus.value -> firstNumber - secondNumber
                        Operation.Multiply.value -> firstNumber * secondNumber
                        Operation.Divide.value -> firstNumber / secondNumber
                        else -> "Error"
                    }
                    stack.add(result.toString())
                }

            }

        }


        return stack.pop().toDouble()
    }
    catch (e:Exception){
        return null
    }
}




fun String.toOperation():Operation{

        return when(this){
            Operation.Plus.value ->  Operation.Plus
            Operation.Minus.value ->  Operation.Minus
            Operation.Multiply.value ->  Operation.Multiply
            Operation.Divide.value ->  Operation.Divide
            else -> Operation.None
        }



}

/**
 * Funcion de extension que comprueba si una cadena es un numero
 */
fun String.isOperator(): Boolean {
    return this ==Operation.Plus.value  || this == Operation.Minus.value || this == Operation.Multiply.value || this == Operation.Divide.value
}

/**
 * Funcion de extension que comprueba si una cadena es una operacion
 */
fun String.isNumber():Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return this.matches(regex)
}