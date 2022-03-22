package com.mouredev.weeklychallenge2022

/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/*
 * SOLUCION PALINDROMO
 * BY: Rodolfo Rojas
 * Github: @jrodolforojas
 * Twitch: @fofocr
 * Lenguaje: Go(Golang)
 */

//func IsPalindrome(text string) bool {
//    // remove all spaces from text string
//    text = strings.ReplaceAll(text, " ", "")
//    // convert all chars of string to lower case
//    text = strings.ToLower(text)
//
//    length := len(text) - 1
//    for i := 0; i < len(text); i++ {
//        currentChar := text[i]
//        reverseChar := text[length-i]
//
//        // convert the vars to string because the type of them are byte
//        if string(currentChar) != string(reverseChar) {
//            return false
//        }
//    }
//    return true
//}
//
//func main() {
//    fmt.Println("result: ", IsPalindrome("Ana lleva al oso la avellana")) // true
//    fmt.Println("result: ", IsPalindrome("kayak"))                        // true
//    fmt.Println("result: ", IsPalindrome("my gym"))                       // true
//    fmt.Println("result: ", IsPalindrome("Hello my name is Rodolfo"))     // false
//}
