/*
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto
 * utilizando el algoritmo de encriptación de Karaca. 
 * (Debes buscar información sobre él)
 * 
 * 2022-12-15
 *
 * Make a function that encrypts a given input with these steps:
 * Input: “apple”
 * Step 1: Reverse the input: “elppa”
 * Step 2: Replace all vowels using the following chart:
    a => 0, e => 1, i => 2, o => 3, u => 4 # “1lpp0”
 * Step 3: Add “aca” to the end of the word: “1lpp0aca”
 * Output: “1lpp0aca”
 * All inputs are strings, no uppercases and all output must be strings.
 */


/**
 * Función en JavaScript que encripta y desencripta texto en minúsculas en 
 * inglés, sin números, utilizando el algoritmo de encriptación de Karaca.
 * +info: https://javguerra.github.io/2022-12-15-karaca/
 * @param {String} str
 * @returns String
 * @author Javier Guerra
 */
function karacaAlgorithm(str = "") {

    if (str === null || str === undefined) str = "";

    else if (typeof str === "string" && str.trim().length && str.match(/\D/g)) {

        str = str.trim().toLowerCase().split("").reverse().join("");

        const vowels = "aeiou".split("");
        const control = "aca";

        if (
            str.slice(0, 3) === control &&
            str.match(/\d/g) &&
            str.length > control.length
        ) {
            // decode
            str = str.slice(control.length);
            vowels.forEach((chr, i) => {
                if (str.includes(i)) str = str.replaceAll(i, chr);
            });
        } else {
            // encode
            vowels.forEach((chr, i) => {
                if (str.includes(chr)) str = str.replaceAll(chr, i);
            });
            str += control;
        }
    }

    return str.toString();
}


// Testing
const str = "Solving an equation produces, instantly, great euphoria.";
console.log(karacaAlgorithm(str));
console.log(karacaAlgorithm(karacaAlgorithm(str)));
