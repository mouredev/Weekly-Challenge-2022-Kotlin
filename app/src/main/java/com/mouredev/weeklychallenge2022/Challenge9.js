/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// create a dictionary that contains all the Morse Code characters
const morseDic = {
    "A":".-", "B":"-...", "C":"-.-.", "D":"-..", "E":".", "F":"..-.", "G":"--.", "H":"....", "I":"..", "J":".---", "K":"-.-",
    "L":".-..", "M":"--", "N":"-.", "Ñ":"--.--", "O":"---", "P":".--.", "Q":"--.-", "R":".-.", "S":"...", "T":"-", "U":"..-",
    "V":"...-", "W":".--", "X":"-..-", "Y":"-.--", "Z":"--..", "0":"-----", "1":".----", "2":"..---", "3":"...--", "4":"....-",
    "5":".....", "6":"-....", "7":"--...", "8":"---..", "9":"----.", ".":".-.-.-", ",":"--..--", "?":"..--..", '"':".-..-.",
    "/":"-..-."
};

// a function to check if the string is Morse or Natural
function checkIfMorse(str){
    if(str === "") return "String is empty"; // if str = empty -> return "String is empty"
    // else -> check if there are different elements than " ", "." and "-"
	return !(/[^ .-]/g.test(str)); // if test = true (is not Morse) -> return false, if test = false (is Morse) -> return true
}

function toNatural(str){
    const mList = str.split(" "); // to get a list of Morse characters
    let toNatural = ""; // empty string
    mList.forEach(element => {
        if(element !== "") toNatural += Object.keys(morseDic).find(key => morseDic[key] === element);
        else if(element === "") toNatural += " ";
    });
    return toNatural;
}

function toMorse(str){
    let toMorse = ""; // empty string
    for(element of str){
        // if element is not a space -> take its value from morseDic and add a space at the end
        if(element!==" ") toMorse += morseDic[element.toUpperCase()] + " ";
        // if element is a space -> add it
        else toMorse += element;
    }
    return toMorse;
}

const p1 = "Hi, my name is Naia"; // should return ".... .. --..--  -- -.--  -. .- -- .  .. ...  -. .- .. .-"
const p2 = ".... . .-.. .-.. ---  .-- --- .-. .-.. -.."; // should return "HELLO WORLD"

// FIRST EXAMPLE -> from natural to Morse
let isMorse = checkIfMorse(p1); // check if it's Morse or not
// transform to the other one
if(isMorse) var result = toNatural(p1);
else result = toMorse(p1);
// print the result
console.log(result); // .... .. --..--  -- -.--  -. .- -- .  .. ...  -. .- .. .-

// SECOND EXAMPLE -> from Morse to natural
isMorse = checkIfMorse(p2); // check if it's Morse Code or not
// transform to the other one
if(isMorse) result = toNatural(p2);
else result = toMorse(p2);
// print the result
console.log(result); // HELLO WORLD