package com.mouredev.weeklychallenge2022

/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


fun main(){
    trickOrTreat(
        arrayListOf(Children("Barry", 8, 143),
                    Children("Martha", 12, 150)),
        Option.TRICK
    )
    trickOrTreat(
        arrayListOf(Children("Isabel", 9, 140),
                    Children("Mario", 7, 123)),
        Option.TREAT
    )
}



private fun trickOrTreat(personList:List<Children>,trickOrTreat:Option){
    when(trickOrTreat){
        Option.TRICK->{
            println("TRICK")

            var sumHeight=0
            personList.forEach { person->
                print("${person.name} :" )
                println()
                for(i in 1..person.name.replace(" ","").length){
                    //un susto por cada  2 letras del nombre
                    if(i%2==0) printScareOrSweetRandom(1,true)
                }
                //dos sustos por cada edad par
                if(person.age%2==0) printScareOrSweetRandom(2,true)

                sumHeight +=person.height
                println()
           }
            //tres sustos por cada 100 cm de altura entre todas las personas
            println("FOR ALL: ")

            val numOfTimes=sumHeight /100 * 3
            printScareOrSweetRandom(numOfTimes,true)
            println()
            println()
        }
        Option.TREAT->{
            println("TREAT")

            personList.forEach { person->
                print("${person.name} :")
                println()
                //un dulce por cada letra del nombre
                printScareOrSweetRandom(person.name.replace(" ","").length,false)
                //un dulce por cada 3 años cumplidos hasta 10 años
                for(year in 1..person.age){
                     if(year%3==0 && year<10) printScareOrSweetRandom(1,false)
                }
                //Dos dulces por cada 50 cm de estatura de cada persona
                val numOfTimes = person.height / 50 *2
                printScareOrSweetRandom(numOfTimes, false)
                println()
            }
        }
    }

}
private fun printScareOrSweetRandom(timesToPrint:Int, isScare:Boolean){
    val scareList= arrayListOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    val sweetList= arrayListOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫" ,"🧁", "🍩")
    for(i in 0 until timesToPrint) {
        if (isScare) print(scareList[Random.nextInt(scareList.size)])else print(sweetList[Random.nextInt(sweetList.size)])
        }
}
enum class Option{
    TRICK,TREAT
}
data class Children(val name:String, val age:Int, val height:Int)

