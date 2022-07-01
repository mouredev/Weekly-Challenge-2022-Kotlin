package com.mouredev.weeklychallenge2022

import kotlin.collections.HashMap

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

object abc {
   val abecedario : Array<Char> = arrayOf(
       'a',
       'b',
       'c',
       'd',
       'e',
       'f',
       'g',
       'h',
       'i',
       'j',
       'k',
       'l',
       'm',
       'n',
       'o',
       'p',
       'q',
       'r',
       's',
       't',
       'u',
       'v',
       'w',
       'x',
       'y',
       'z',
       'á',
       'é',
       'í',
       'ó',
       'u'
   )
}

fun main(){

    val parrafoTexto:String =
        "Este es un párrafo de ejemplo para comprobar el " +
                "funcionamiento del código; Debe de evaluar SI o NO como si fueran sí o no indistintamente." +
                "tomando en cuenta todos los signos de puntuación. (o todo lo que no sea una letra)"
    val textoClasificado : Map<String, Int>  = clasificar(parrafoTexto)

    imprimirListaDePalabras(textoClasificado)

}

// Clasifica las palabras dentro del bloque de texto y devuelve un objeto de mapa con cada palabra y sus ocurrencias.
fun clasificar(parrafoTexto: String):Map<String, Int>{

    val parrafoTextoSeparado : List<String> = parrafoTexto.split(" ")
    val parrafoClasificado : MutableMap<String, Int> = HashMap<String,Int>()

    for (palabra in parrafoTextoSeparado){
        val palabraNormalizada = normalizar(palabra)
        if (parrafoClasificado.containsKey(palabraNormalizada)){
            parrafoClasificado[palabraNormalizada] = (parrafoClasificado[palabraNormalizada]!!+1)
        } else {
            parrafoClasificado[palabraNormalizada] = 1
        }
    }

    return parrafoClasificado
}

// Remueve signos de puntuación y convierte a minúsculas
fun normalizar(palabra: String):String{

    // convierte a minúsculas
    var palabraMod =  palabra.toLowerCase()

    // obtiene el último caracter de la palabra
    var caracter = palabraMod.get(palabra.length - 1)

    // recorre el abecedario comparando en el último elemento
    var seEncontroSigno = true
    do {
        for (letra in abc.abecedario){
            if (letra.equals(caracter)){
                seEncontroSigno = false
                break
            }
        }
        if (seEncontroSigno){
            palabraMod = palabraMod.subSequence(0,palabraMod.length-1).toString()
            caracter = palabraMod.get(palabraMod.length - 1)
            //println("Se quito un signo en ${palabraMod}")  // Por si se quisiera ver los signos removidos
        }
    }while (seEncontroSigno && palabraMod.length>0)

    caracter = palabraMod.get(0)
    // recorre el abecedario comparando en el último elemento
    seEncontroSigno = true
    // recorre el abecedario comparando en el primer elemento
    do {
        for (letra in abc.abecedario){
            if (letra.equals(caracter)){
                seEncontroSigno = false
                break
            }
        }
        if (seEncontroSigno){
            palabraMod = palabraMod.subSequence(1,palabraMod.length).toString()
            caracter = palabraMod.get(0)
            //println("Se quito un signo en ${palabraMod}")  // Por si se quisiera ver los signos removidos
        }
    }while (seEncontroSigno && palabraMod.length>0)

    return palabraMod
}

// Imprime cada una de las palabras contenidas dentro del texto clasificado.
fun imprimirListaDePalabras(textoClasificado: Map<String, Int>){
    for(palabra in textoClasificado){
        val unaOMas : String = if(palabra.value>1){
            "veces"
        } else
            "ves"
        println("La palabra: \"${palabra.key}\" se repite ${palabra.value} $unaOMas")
    }
}
