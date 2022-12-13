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


function karacasAlgorithm(text:string):string{
    // reverse the input
    let splitString = text.split(""); // ["h", "e", "l", "l", "o"]
    let reverseArray = splitString.reverse(); // ["o", "l", "l", "e", "h"]
    let joinArray = reverseArray.join(""); //"olleh"

    //Replace all vowels {a => 0, e => 1, i => 2, o => 2, u => 3}
    let replaceVovel=joinArray.replace(/a/g,"0").replace(/e/g,"1").replace(/i/g,"2").replace(/o/g,"2").replace(/u/g,"3");

    //Add "aca" to the end of the word
    let concatString=replaceVovel+"aca";

    return concatString;
}

function main():void{
    let text:string="apple";
    let textEncrypt:string="";

    textEncrypt=karacasAlgorithm(text);
    console.log(`Encrypt(${text})`+" => "+`${textEncrypt}`) //"1lpp0aca"

    text="banana";
    textEncrypt=karacasAlgorithm(text);
    console.log(`Encrypt(${text})`+" => "+`${textEncrypt}`) //"0n0n0baca"

    text="karaca";
    textEncrypt=karacasAlgorithm(text);
    console.log(`Encrypt(${text})`+" => "+`${textEncrypt}`) //"0c0r0kaca"

    text="burak";
    textEncrypt=karacasAlgorithm(text);
    console.log(`Encrypt(${text})`+" => "+`${textEncrypt}`) //"k0r3baca"

    text="alpaca";
    textEncrypt=karacasAlgorithm(text);
    console.log(`Encrypt(${text})`+" => "+`${textEncrypt}`) //"0c0pl0aca"


}

//run
console.clear();
main();