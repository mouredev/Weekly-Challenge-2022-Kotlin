 *
 */

fun main() {
  val text = "Hola mundo"

  val codigoMorse = hashMapOf(".-" to "A", "-..." to "B", "-.-." to "C", "-.." to "D", "." to "E", "..-." to "F", "--." to "G", "...." to "H", ".." to "I", ".---" to "J", "-.-" to "K", ".-.." to "L", "--" to "M", "-." to "N", "---" to "O", ".--." to "P", "--.-" to "Q", ".-." to "R", "..." to "S", "-" to "T", "..-" to "U", "...-" to "V", ".--" to "W", "-..-" to "X", "-.--" to "Y", "--.." to "Z", "-----" to "0", ".----" to "1", "..---" to "2", "...--" to "3", "....-" to "4", "....." to "5", "-...." to "6", "--..." to "7", "---.." to "8", "----." to "9", ".-.-.-" to ".", "--..--" to ",", "..--.." to "?", ".----." to "'", " " to " ")

  if (check(text)) {
    println(toNatural(text, codigoMorse))
  } else {
    println(toMorse(text, codigoMorse))
  }
}

fun check(text: String): Boolean {
  val textArray = text.toCharArray()

  for (i in textArray.indices) {
    if (textArray[i] != '.' && textArray[i] != '-' && textArray[i] != ' ') {
      return false
    }
  }
  return true
}

fun toMorse(text: String, codigoMorse: HashMap<String, String>): String {
  var morse = ""
  val textArray = text.uppercase().toCharArray()

  for (i in textArray.indices) {
    for ((key, value) in codigoMorse) {
      if (textArray[i] == value[0] && key != " ") morse += key
    }
    morse += " "
  }
  return morse.trim()
}

fun toNatural(text: String, codigo: Map<String, String>): String {
  var natural=""
  val frase = text.uppercase().split("  ")

  for (i in frase.indices) {
    val palabra = frase[i].split(" ")
    for (j in palabra.indices) {
      natural += codigo[palabra[j]]
    }
    natural += " "
  }
  return natural.trim()
}