import com.diogonunes.jcolor.Ansi.colorize
import com.diogonunes.jcolor.AnsiFormat
import com.diogonunes.jcolor.Attribute.*
import java.util.InputMismatchException

fun main(){
    var trucoTotal:Int= 0
    var tratoTotal:Int= 0
    val listado = arrayOf(
       arrayOf ("Carlos","8","120"),
        arrayOf("Patricia","15","170"),
        arrayOf("Juan","8","110")
    )
    var trucoOTrato= peticionInformacionUsuario()
    when{
        trucoOTrato == "trato" -> tratoTotal= trato(listado)
        trucoOTrato == "truco" -> trucoTotal= truco(listado)
    }
    imprimirtruco(trucoTotal)
    imprimirtrato(tratoTotal)

    //println(listado[0][2])
}

/**
 * Funcion para pedir Truco o trato Usuario
 */
fun peticionInformacionUsuario():String {
    do {
        val fHallo = AnsiFormat(TEXT_COLOR(4), BOLD())
        println(colorize("¿Truco o Trato?", fHallo))
        print(":")
         val respuesta = readln().lowercase()
        if (respuesta== "truco" || respuesta == "trato") {
            return respuesta
        }else{
            println("Tienes que introducir Truco o Trato")
        }
    } while (respuesta !== "truco" || respuesta !== "trato")
   return "Esto nunca se leera"
}

/**
 * funcion para calcular total de Truco
 */
fun truco(listado: Array<Array<String>>):Int{
    var trucostotal:Int= 0
    trucostotal+= (listado[0][0].length + listado[1][0].length + listado[2][0].length)/2
    when{
        listado[0][1].toInt() % 2 == 0 -> trucostotal+=2
        listado[1][1].toInt() % 2 == 0 -> trucostotal+=2
        listado[2][1].toInt() % 2 == 0 -> trucostotal+=2
    }
    trucostotal+=((listado[0][2].toInt() + listado[1][2].toInt() + listado[2][2].toInt())/100)*3
    return trucostotal
}

fun imprimirtruco(trucoTotal:Int) {
    var vectortruco=Array<String>(trucoTotal){""}
    var vectorEmoji = arrayOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    for(i in vectortruco.indices){
        vectortruco[i]= vectorEmoji.random()
    }
    println(vectortruco.joinToString())
}

fun trato(listado:Array<Array<String>>):Int {
    var tratoTotal: Int = 0
    var temporalNombres= listado[0][0] .toCharArray() + listado[1][0].toCharArray() + listado[2][0] .toCharArray()
    for(i in temporalNombres.indices){
       if(temporalNombres[i]== 'a'||temporalNombres[i]== 'e'||temporalNombres[i]== 'i'||temporalNombres[i]== 'o'||temporalNombres[i]== 'u'){
           tratoTotal+=1
       }
    }

     var temporalEdad1 = listado[0][1].toInt()/3
     var temporalEdad2 = listado[1][1] .toInt()/3
     var temporalEdad3 = listado[2][1].toInt()/3
    when{
        temporalEdad1>3 -> temporalEdad1 = 3
        temporalEdad2>3 -> temporalEdad2 = 3
        temporalEdad3>3 -> temporalEdad3 = 3
    }
    tratoTotal+= temporalEdad1 + temporalEdad2 + temporalEdad3

    var temporalAltura1 = (listado[0][2].toInt()/50)*2
    var temporalAltura2 = (listado[1][2] .toInt()/50)*2
    var temporalAltura3 = (listado[2][2].toInt()/50)*2
    when {
        temporalAltura1 > 6 -> temporalAltura1 = 6
        temporalAltura2 > 6 -> temporalAltura2 = 6
        temporalAltura3 > 6 -> temporalAltura3 = 6
    }
    tratoTotal+= temporalAltura1 + temporalAltura2 + temporalAltura3
     return tratoTotal
}

fun imprimirtrato(tratoTotal:Int){
    var vectortrato=Array<String>(tratoTotal){""}
    var vectorEmoji = arrayOf("🍰","🍬","🍡","🍭","🍪","🍫","🧁","🍩")
    for(i in vectortrato.indices){
        vectortrato[i]= vectorEmoji.random()
    }
    println(vectortrato.joinToString())
}
/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
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
