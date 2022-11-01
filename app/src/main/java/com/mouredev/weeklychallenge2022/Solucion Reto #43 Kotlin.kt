import java.io.PrintWriter

/*
 * File Name: 
 * Created by Iván Sopeña on 30,octubre,2022
 * /*
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
 * o Trato" y un listado (array) de personas con las siguientes propiedades:
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
 */
*/

data class People (val name: String, val age: Int, val size: Int)


fun main ()
{
    val kids: List<People> = listOf(People("Pepe",12,110),People("Lola",15,120),People("Antonio",13,150))

    println("¡¡Truco o Trato!!")
    val option: String = readln()

    var total = 0

    if(option == "Truco")
    {
        kids.forEach {
            total += it.name.length / 2
        }
        println("Susto por cada 2 letras del nombre: ")
        println(Actions(1,total))

        kids.forEach {
            if(it.age %2 == 0)
            {
                total += 2
            }
        }
        println("Sustos por cada edad que sea un número par:")
        println(Actions(1,total))

        kids.forEach {
           if(it.size >= 100)
           {
               total += 3 * it.size /100
           }
        }
        println("Sustos por cada 100 cm de altura: ")
        println(Actions(1,total))

    }
    else if(option.equals("Trato"))
    {
        kids.forEach {
            total += it.name.length
        }
        println("Dulce por cada letra de nombre: ")
        println(Actions(2,total))

        kids.forEach {
            if(it.age <=10)
            {
                total += it.age /3
            }
        }
        println("Dulce por cada 3 años cumplidos hasta un máximo de 10 años:")
        println(Actions(2,total))


        kids.forEach {
            if(it.size <=150)
            {
               total =+ 2 * (it.size /50)
            }
        }
        println("Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm:")
        println(Actions(2,total))
    }
    else
    {
        println("Esta opción no esta contemplada")
    }
}

private fun Actions (option: Int,numberOfPresents: Int): String
{
    val scare = arrayListOf<String>("🎃","👻","💀","🕷","🕸","🦇")
    val sweet = arrayListOf<String>("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁","🍩")
    var returned = ""

    if(option == 1)
    {
        for (i in 1..numberOfPresents)
        {
            returned += scare.random()
        }
    }
    else
    {
        for (i in 1..numberOfPresents)
        {
            returned += sweet.random()
        }
    }

    return returned
}


