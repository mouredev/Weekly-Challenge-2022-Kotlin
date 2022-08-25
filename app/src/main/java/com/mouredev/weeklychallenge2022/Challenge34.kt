package com.mouredev.weeklychallenge2022

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main(){
    var list= mutableListOf<Int>(2,3,4,56)
    println(listNumbers(list));
}


private fun listNumbers(myArray: List<Int>){
    try
    {
        if(!validateList(myArray)){
            println("error: arreglo de datos no valido(desordenado)")
            return
        }
        if(numbersRepeated(myArray)){
            println("error: arreglo de datos no valido(repetidos)")
            return
        }

        println("Numeros que faltan: "+listNum(myArray))
    }catch (ex:TypeCastException){
        print("Datos no validos")

    }

}

/*
    Validamos si el arreglo de entrada esta ordenado comparando con el mismo ordenado(usando la funcion sort),
    en caso de estar ordenado retornamos un valor booleano */
private fun validateList(myArray: List<Int>):Boolean{
    var validate:Boolean=false
    for (i in 0 until (myArray.size)){
        var arraySort=myArray.sorted()
        //comparamos si el array original es igual al ordenado.
        if( myArray[i]==arraySort[i]){
            validate = true

        }else{
            validate = false
            break
        }

    }

    return validate;
}

/*
* validamos para que no hayan datos repetidos en el array
* */
private fun numbersRepeated(myArray: List<Int>):Boolean{
    var validateRepeated=false
    for (n in 1 until(myArray.size) ){
        /*buscamos dos numeros que sean igual,
         en todo el arreglo, y cuando lo encontrmos detenemos la busqueda*/
        if((myArray[n])== (myArray[n-1])) {
            validateRepeated = true
            break
        }

    }
    return validateRepeated
}


/* en esta funcion retornamos el nuevo arreglo con los datos faltantes*/
private fun listNum(myArray: List<Int>): List<Int> {

    val arrayNew= mutableListOf<Int>() //array para todos los numeros que faltan y los que ya existen


    val numLost= mutableListOf<Int>()  //solo los numeros perdidos

    arrayNew.add(myArray[0])
    for (n in 1 until(myArray.size) ){

        var countLost:Int=myArray[n]-myArray[n-1]

        if(countLost>1){

            for(i in 1 until (countLost)){
                var num=myArray[n-1]+i
                numLost.add(num);
                arrayNew.add(num);

            }

        }

        arrayNew.add(myArray[n])
    }

    return  numLost.toList(); //retorna solo los numeros que faltan

}