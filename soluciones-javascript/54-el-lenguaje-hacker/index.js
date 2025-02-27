/*
 * Escribe un programa que reciba un texto y transforme lenguaje natural a
 * "lenguaje hacker" (conocido realmente como "leet" o "1337"). Este lenguaje
 *  se caracteriza por sustituir caracteres alfanuméricos.
 * - Utiliza esta tabla (https://www.gamehouse.com/blog/leet-speak-cheat-sheet)
 *   con el alfabeto y los números en "leet".
 *   (Usa la primera opción de cada transformación. Por ejemplo "4" para la "a")
 */

const leetTable = {
    a: "4",
    b: "8",
    c: "(",
    d: "|)",
    e: "3",
    f: "|=",
    g: "6",
    h: "#",
    i: "1",
    j: "_|",
    k: "|<",
    l: "1",
    m: "|\\/|",
    n: "|\\|",
    o: "0",
    p: "|*",
    q: "0_",
    r: "|2",
    s: "5",
    t: "7",
    u: "|_|",
    v: "\\/",
    w: "\\/\\/",
    x: "><",
    y: "`/",
    z: "2",
};

/**
 * 
 * @param {String} sentence
 */
const convertirTextoALenguajeHacker = (sentence) => {

    return sentence.split('').map((char) => {
        const lowerChar = char.toLowerCase();
        if(leetTable[lowerChar]){
            return char === lowerChar ? leetTable[lowerChar] : leetTable[lowerChar].toUpperCase();
        }
        return char;
    }).join('');

};

console.log(convertirTextoALenguajeHacker("Hacker"));