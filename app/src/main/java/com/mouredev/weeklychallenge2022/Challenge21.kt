package com.mouredev.weeklychallenge2022

import java.io.File
import kotlin.math.floor

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
                ╔═══════════════════════╗
               ═╣                       ╠═
                ║      FernanApps       ║
               ═╣                       ╠═
                ╚═══════════════════════╝

     print SIMPLE
         El resultado de 5 + 2 - 1 * 8 - 15 + 4 / 2 es [  -1.5  ]

     print NORMAL
         ╔════════════════════════════════════════════════════════════╗
         ║  El resultado de 5 + 2 - 1 * 8 - 15 + 4 / 2 es [  -1.5  ]  ║
         ╚════════════════════════════════════════════════════════════╝

     print PRETY
          -5 + 2 - 1 * 8 - 15 + 4 / 2
           ╚═╦═╝
             -3 - 1 * 8 - 15 + 4 / 2
              ╚═╦═╝
                -4 * 8 - 15 + 4 / 2
                 ╚═╦═╝
                  -32 - 15 + 4 / 2
                    ╚═╦═╝
                     -47 + 4 / 2
                      ╚═╦═╝
                       -43 / 2
                        ╚═╦═╝
                        -21.5


 */
val s: String = File.separator
fun main() {
    val nameFile = "Challenge21.txt"
    val nameDirectoryFile = "Resources"
    val patchFile = "${getRootPatch()}${s}$nameDirectoryFile${s}${nameFile}"
    val file = File(patchFile)



    if(file.isCorrectFileTxT()){
        val linesList = file.readLines() as MutableList
        textData = linesList.joinToString(" ")
        dataTextSavedList.add(textData)
        // ^[+\-*\/]{1}$
        if(!linesList[0].matches("[+\\-*/]".toRegex())){
            linesList.forEach{ line ->operations(line)
            }

            val textResult = "El resultado de ${linesList.joinToString(" ")} es [  $result  ]"
            textResult.printFernan(Print.Simple)
            textResult.printFernan(Print.Normal)
            textResult.printFernan(Print.Prety)

        } else {
            println("Tu calculadora no inicia con un número")
        }
    }

}



private var result:Double = 0.0
private var operator:String = "+"
private var textData:String = ""
fun operations(line:String){
    val operators = arrayOf("+","-","*","/")
    when(line){
        in operators -> {
            operator = line
        }
        else ->{
            val number = line.toDouble()
            operation(number)

        }
    }
}
private var isFirst = false
private var dataTextSaved = ""
private var dataTextSavedList : MutableList<String> = mutableListOf()
fun operation(value:Double){
    when(operator){
        "+" ->  {
            result += value
        }
        "-" -> {
            result -= value
        }
        "*" -> {
            result *= value
        }
        "/" -> {
            result /= value
        }
    }
    if(isFirst){
        dataTextSaved += " $operator ${value.isIntString()}"
        dataTextSavedList.add("${" ".repeat((dataTextSaved.length/2)-1)}╚═╦═╝")
        dataTextSavedList.add("${" ".repeat(dataTextSaved.length/2)}${result.isIntString()}${textData.substringAfterLast(dataTextSaved)}")

    } else {
        isFirst = true
        dataTextSaved += value.isIntString()
    }


}

fun String.printFernan(type:Print){
    when(type){
        Print.Simple -> {
            println(this)
        }
        Print.Normal -> {
            println("╔══${"═".repeat(this.length)}══╗")
            println("║  $this  ║ ")
            println("╚══${"═".repeat(this.length)}══╝")
        }
        else -> {
            dataTextSavedList.forEach{
                println(it)
            }
        }
    }
}

sealed class Print(){
    object Simple : Print()
    object Normal : Print()
    object Prety : Print()
}



fun Double.isIntString():String{
    val x = if ( this == floor(this) ) this.toInt() else this
    return x.toString()
}

fun File.isCorrectFileTxT(): Boolean {

        if(this.exists()){
            if(this.isFile){
                if(this.extension == "txt"){
                    return true
                } else {
                    println("El archivo ${this.name} no es un formato de texto")
                }
            } else {
                println("${this.name} No es un archivo")
            }
        } else {
            println("No existe el archivo ${this.name}")
        }

    return false

}

/*
        https://docs.oracle.com/javase/7/docs/api/java/io/File.html                         *//**

                        java.io                                                         *//*

        El paquete resuelve los nombres de ruta relativos utilizando el
        directorio de usuario actual. El directorio actual se representa
        como propiedad del sistema, es decir,                                           *//**

        user.dir                                                                        *//*

        el directorio desde
        donde se invocó la JVM. >
        Esto imprimirá la ruta absoluta del directorio actual
        desde donde se inicializó su aplicación.


 */

/**
    @return \....\moureDev\RetosSemanales\Weekly-Challenge-2022-Kotlin
 */

fun getRootPatch():String{
    /*
    Para mi ambos funciona

    File(".").canonicalPath
    System.getProperty("user.dir")

    Solo funciona cuando tiene la siguiente estructura

        .../app/src/main/java/unaCarpeta/unaCarpeta/unaCarpeta...../variosArchivos


     */

    val currentDir =
        File(System.getProperty("user.dir")+"${s}app${s}src${s}main${s}java${s}")
    return getDirectoryFromMultipleFiles(currentDir).absolutePath
}




fun getDirectoryFromMultipleFiles(file: File):File{
    if(file.isDirectory){
        if(file.listFiles() != null){
            when(file.listFiles().size){
                0 -> return file
                1 -> return getDirectoryFromMultipleFiles(file.listFiles()[0])
                else -> return file

            }
        }
    }
    return file

}