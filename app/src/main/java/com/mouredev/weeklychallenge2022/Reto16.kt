/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 */

val byteCodeDifference = 32

fun main() {
    println(firstToUpperCase("Mi moto alpina derrapante"))
    println(firstToUpperCase("El que entendió, entendió ;)"))
    println(firstToUpperCase("brais moure y la comunidad"))
    println(firstToUpperCase("terminamos de picar jaja"))
    println(firstToUpperCase("En la montaña había un ñu llamado arturo"))
    println(firstToUpperCase("mamá se me rompió el ábaco"))
    println(firstToUpperCase("el ácido te puede quemar la piel"))
    println(firstToUpperCase("me tira barbies de élite pero defiendo con poco elixir. acabo ganando"))
    println(firstToUpperCase("La formación cívica y ética"))
    println(firstToUpperCase("Este libro no tiene índice"))
}
/*
    Resultados:
    Mi Moto Alpina Derrapante
    El Que Entendió, Entendió ;)
    Brais Moure Y La Comunidad
    Terminamos De Picar Jaja
    En La Montaña Había Un Ñu Llamado Arturo
    Mamá Se Me Rompió El Ábaco
    El Ácido Te Puede Quemar La Piel
    Me Tira Barbies De Élite Pero Defiendo Con Poco Elixir. Acabo Ganando
    La Formación Cívica Y Ética
    Este Libro No Tiene Índice
* */

private fun firstToUpperCase(text: String): String{
    if(text.isEmpty()){ //Directamente retornar el string vacío
        return text
    }
    var pendingUppercase = true
    var upperedText = ""
    for(pos in text.indices){
        if(text[pos] == ' '){
            pendingUppercase = true
            upperedText += text[pos].toString() //Lo pongo porque si no se carga los espacios
        } else if(text[pos] in 'a'..'z'
            && pendingUppercase){ //La diferencia de bytecode entre una letra minuscula y mayuscula es de 32
            upperedText += ((text[pos].code - byteCodeDifference).toChar()).toString()
            pendingUppercase = false
        } else if(text[pos] in 'A'..'Z' || text[pos] == 'Ñ' || text[pos] in 'Á'..'Ú') {
            upperedText += text[pos].toString()
            pendingUppercase = false //Para que si la primera letra ya esta en mayuscula, no haga mayuscula la 2da.
        } else if(text[pos] in 'á'..'ú' && pendingUppercase){ //El bytecode de la ñ no esta en el rango de la a-z asi que hay que especificarla
            upperedText += ((text[pos].code - byteCodeDifference).toChar()).toString()
            pendingUppercase = false
        } else if(text[pos] == 'ñ'
            && pendingUppercase) {
            upperedText += ((text[pos].code - byteCodeDifference).toChar()).toString()
            pendingUppercase = false
        } else upperedText += text[pos].toString()
    }
    return upperedText
}
