/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

const isAnagram = (string1 = '', string2 = '') => {

    //Si algún String está vacío retorna false
    if(!string1 || !string2 ) return false; 
    
    if(string1.length !== string2.length ) return false; 
    
    const stringLowerCase1 = string1.toLowerCase().trim();
    const stringLowerCase2 = string2.toLowerCase().trim();

    //Si las palabras son exactamente iguales retorna false
    if(stringLowerCase1 === stringLowerCase2) return false;

    const arrayString1 = stringLowerCase1.split("").sort().join('');
    const arrayString2 = stringLowerCase2.split("").sort().join('');
    
    return arrayString1 === arrayString2; 
    
}


console.log("Es un anagrama (amor + roma): " + isAnagram("amor", "roma"));
console.log("Es un anagrama (listen + silent): " + isAnagram("listen", "silent"));
console.log("Es un anagrama (test + test): " + isAnagram("test", "test"));
console.log("Es un anagrama ( + word): " + isAnagram("", "word"));
console.log("Es un anagrama (test + testing): " + isAnagram("test", "testing"));
console.log("Es un anagrama (Listen + Silent): " + isAnagram("Listen", "Silent"));
console.log("Es un anagrama (Dormitory + Dirty room): " + isAnagram("Dormitory", "Dirty room"));



