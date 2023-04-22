fun main(args: Array<String>) {
   var fecha = IntArray(5){0}
    fecha[0]=2022                   //Año
    fecha[1]=(1..12).random()     //Mes
    when(fecha[1]){
        1,3,5,7,8,10,12  -> fecha[2]=(1..31).random()    //dia
        2 -> fecha[2]=(1..28).random()
        4,6,9,11 -> fecha[2]=(1..30).random()
    }
    fecha[3]=(0..23).random()     //Hora
    fecha[4]=(0..59).random()     //Minutos
    for(i in fecha.indices){
        println(fecha[i])
    }
    CuantoFaltaParaLosRegalitosDeMoure(fecha)
}

fun CuantoFaltaParaLosRegalitosDeMoure(fecha:IntArray){

    if(fecha[1]==12&&fecha[2]<=25){
        println("ES ADVIENTO, HOY ES EL ${fecha[2]} DE DICIEMBRE")
        println("QUEDAN ${23-fecha[3]} Horas  ${60-fecha[4]} Minutos")

    }else if(fecha[0]>2022){
            println("El sorteo de 2022 ya termino. llegas:")
            println(" ${fecha[0]-2023} años tarde")
            println(" ${fecha[1]} meses tarde")
            println(" ${fecha[2]+5} dias tarde")
            println(" ${fecha[3]} horas tarde")
            println(" ${fecha[4]} minutos tarde")
        }else if(fecha[0]<=2022){
            println("Llegas pronto tendras que esperar")
            println(if(2022-fecha[0]!=0)" ${2022-fecha[0]} años " else "")
            println(" ${11-fecha[1]} meses ")
        when(fecha[1]) {
            1, 3, 5, 7, 8, 10, 12 -> println(" ${30 - fecha[2]} dias ")
            2 -> println(" ${27 - fecha[2]} dias ")
            4, 6, 9, 11 -> println(" ${29 - fecha[2]} dias ")
        }
            println(" ${23-fecha[3]} horas ")
            println(" ${60-fecha[4]} minutos ")
        }
    }

