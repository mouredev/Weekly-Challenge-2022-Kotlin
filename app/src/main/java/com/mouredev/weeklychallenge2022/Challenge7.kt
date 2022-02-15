package com.mouredev.weeklychallenge2022

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

var arrayPalabras = arrayListOf<String>()
var arrayContador = arrayListOf<Int>()
fun main() {

   // cuentaPalabras("Lo que pasa y lo que no pasa: es lo que pasa al final si pasa?")
cuentaPalabras("Mi pokemon  es sobble porque sobble es supermono y si tuviera un pokemon seria sobble porque los que no tienen un sobble son tontos")
    //cuentaPalabras("no se si voy a poder repetir o no se si no voy a repetir")

}
fun cuentaPalabras(cadena: String){

    arrayPalabras.clear()
    arrayContador.clear()
    var palabra = ""
    var indiceBucle = 0

    val caracteresEspeciales= ",?¿:.!¡"
    while(indiceBucle < cadena.length){

        if(cadena[indiceBucle] != ' '){
            var x=0
            while (x < caracteresEspeciales.length-1){ if(caracteresEspeciales[x]==cadena[indiceBucle]){ x=1000 }
                x++
            }
            if(x!=1001){
                palabra += cadena[indiceBucle]
            }
        }else
        {
            anadirPalabra(palabra)
            palabra = ""
        }
        indiceBucle++
    }
    anadirPalabra(palabra)
    var x=0
    var sintaxis = " veces"
    while(x< arrayPalabras.size-1){
        x++

        if(arrayContador[x]==1){
            sintaxis=" vez"
        }else{
            sintaxis =" veces"
        }
        {
        }
        println(arrayPalabras[x] +" aparece " + arrayContador[x] + sintaxis)

    }
}
fun anadirPalabra(palabra: String){

    arrayPalabras.add(palabra)
    arrayContador.add(1)
    var x = 0
    while(x < arrayPalabras.size-1){
       if(arrayPalabras[x].lowercase() == palabra.lowercase() ){
            arrayPalabras.removeAt(arrayPalabras.size-1)
            arrayContador.removeAt((arrayContador.size-1))
            arrayContador[x]++
            x=arrayPalabras.size+1
        }
        x++
    }

}