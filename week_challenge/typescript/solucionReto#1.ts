// solucion reto #1
// Dificultad media 

// ¿ES UN ANAGRAMA?

// Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
// Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
// NO hace falta comprobar que ambas palabras existan.
// Dos palabras exactamente iguales no son anagrama.

// ejemplos Cornisa – Narciso Japonés – Esponja Valora – Álvaro Nepal – Panel amor - roma  Frase – Fresa  Acuerdo – Ecuador


const isAnagrama = (word:string, wordTwo:string) => {
    
    if (word.length !== wordTwo.length) return false;
    
    const wordSorted = word.toLowerCase().split('').sort((a,b)=> a > b ? 1 : -1).join('');
    const wordTwoSorted = wordTwo.toLowerCase().split('').sort((a, b) => a > b ? 1 : -1).join('');

    return wordSorted === wordTwoSorted ? true : false;
};

console.log(isAnagrama('Acuerdo', 'icuador'))

// big(0) time complexity = 0(2n)
// big(0) space complexity = 0(2n)