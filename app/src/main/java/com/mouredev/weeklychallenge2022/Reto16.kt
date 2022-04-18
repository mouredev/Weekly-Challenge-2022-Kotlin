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
}

//Esta función usa la antigua regla: Las mayúsculas no llevan acento
private fun firstToUpperCase(text: String): String{
    if(text.isEmpty()){ //Directamente retornar el string vacío
        return text
    }
    var pendingUppercase = true
    var upperedText = ""
    for(pos in text.indices){
        if(text[pos] == ' '){
            pendingUppercase = true
            upperedText += text[pos].toString()
            //Lo pongo porque si no se carga los espacios
        } else if(text[pos] in 'a'..'z'
        && pendingUppercase){ //La diferencia de bytecode entre una letra minuscula y mayuscula es de 32
            upperedText += ((text[pos].toInt() - byteCodeDifference).toChar()).toString()
            pendingUppercase = false
        } else if(text[pos] in 'A'..'Z' || text[pos] == 'Ñ') {
            upperedText += text[pos].toString()
            pendingUppercase = false //Para que si la primera letra ya esta en mayuscula, no haga mayuscula la 2da.
        } else if(text[pos] == 'ñ'
        && pendingUppercase){ //El bytecode de la ñ no esta en el rango de la a-z asi que hay que especificarla
            upperedText += ((text[pos].toInt() - byteCodeDifference).toChar()).toString()
            pendingUppercase = false
        } else upperedText += text[pos].toString()
    }
    return upperedText
}
