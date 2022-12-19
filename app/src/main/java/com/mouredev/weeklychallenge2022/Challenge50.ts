/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


/***************************** NOTA IMPORTANTE *************************
 * Aunque el algoritmo diseñado tiene en cuenta los acentos y caracteres especiales, al desencriptar suponemos cierta
 * "perdida" de información en los acentos , ya que al ser tan simple el algoritmo de encriptacion no se puede recuperar
 * la información original de los acentos y caracteres especiales en las vocales.
 *
 * Ademas tambien a la hora de desencriptar se asume que los numeros que se encuentran en el texto son los que se han
 * encriptado, por lo que si el texto contiene numeros se asume que son parte del texto encriptado , lo que puede dar
 * lugar a errores en la desencriptación.
 */

/**
 * Mapa de sustitución de vocales
 */
let vowelsMap = new Map<string,string>()
vowelsMap.set('a', '0')
vowelsMap.set('e', '1')
vowelsMap.set('i', '2')
vowelsMap.set('o', '3')
vowelsMap.set('u', '4')
vowelsMap.set('A', '5')
vowelsMap.set('E', '6')
vowelsMap.set('I', '7')
vowelsMap.set('O', '8')
vowelsMap.set('U', '9')


/**
 * Funcion que encripta un texto utilizando el algoritmo de encriptación de Karaca
 * El algoritmo consiste en:
 * 1. Invertir el texto
 * 2. Reemplazar las vocales por los siguientes números segun el siguiente mapa:
 *   a -> 0
 *   e -> 1
 *   i -> 2
 *   o -> 2
 *   u -> 4
 *   A -> 5
 *   E -> 6
 *   I -> 7
 *   O -> 8
 *   U -> 9
 * 3. Añadir al final la cadena "aca"

 * @param text Texto a encriptar
 */
function karacaEncrypt(text: string): string {

    return normalizeText(text).split(' ').map((value) => {
        return value.split('').reverse().join('').replace(/[aeiouAEIOU]/g, (v) => {
            return vowelsMap.get(v)!!
        }) + 'aca'
    }).join(' ')

}


/**
 * Función que desencripta un texto utilizando el algoritmo de encriptación de Karaca inverso al de encriptación
 * El algoritmo consiste en:
 * 1. Quitar los 3 últimos caracteres (aca)
 * 2. Reemplazar los números por las vocales segun el siguiente mapa:
 *  0 -> a
 *  1 -> e
 *  2 -> i
 *  3 -> o
 *  4 -> u
 *  5 -> A
 *  6 -> E
 *  7 -> I
 *  8 -> O
 *  9 -> U
 *  3. Invertir el texto
 *
 * @param text
 */
function karacaDecrypt(text: string): string {
    return normalizeText(text).split(' ').map(value => {
        return value.replace(/aca$/, '').split('').reverse().join('').replace(/[0123456789]/g, (v) => {
            let key = Array.from(vowelsMap.keys()).find(key => vowelsMap.get(key) === v)
            return key!!
        })
    }).join(' ')


}

/**
 * Función que normaliza el texto quitando los acentos y caracteres especiales
 * @param str Texto a normalizar
 * @returns Texto normalizado
 */
function normalizeText(str:string) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}


function printKaraca(text: string) {
    console.log("**********************")
    const encryptedText = karacaEncrypt(text)
    console.log(`Original text: ${text}`)
    console.log(`Encrypted text: ${encryptedText}`)
    console.log(`Decrypted text: ${karacaDecrypt(encryptedText)}`)

}

/**
 * Casos de prueba
 */

printKaraca('Reto#50MoureDev')
printKaraca('La cria de berberechos en cautividad es una actividad que ha ganado popularidad en los últimos años debido a la alta demanda de este marisco en el mercado. Los berberechos son una especie de molusco bivalvo que se encuentra en aguas templadas y salobres, y que se caracteriza por su sabor y textura únicos')




