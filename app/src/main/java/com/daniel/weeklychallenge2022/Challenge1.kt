/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
*/

fun main() {
   	println(verifyAnagrama("letras", "lastre")) // true
	println(verifyAnagrama("aguardentosa", "engatusadora")) // true
   	println(verifyAnagrama("nacionalista", "altisonancia")) // true
   	println(verifyAnagrama("kklla", "kkadd")) // false 
   	println(verifyAnagrama("pedrp", "pedro")) // false
}

fun verifyAnagrama (word1: String, word2: String): Boolean {
   	if (word1.length != word2.length) return false
    if (word1 == word2) return false
    
   	var words1: MutableList<Char> = word1.map{it}.toMutableList()
    var words2: MutableList<Char> = word2.map{it}.toMutableList()
    
    for (char in word1) {
        if (char in words1) {
            words1.remove(char)
            words2.remove(char)
        }
    }
    
    if (words1.size == words2.size) return true
    else return false
}