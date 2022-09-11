// solucion reto #6
// Dificultad facil

// INVIRTIENDO CADENAS

// Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
// Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
//input hola mundo 
//expect odnum aloh

const reverse = (word:string):string => {

    let reverseWord:string = ''

    for (let i = word.length -1; i >= 0; i--) {
        reverseWord += word[i]
    }

    return  reverseWord
};

reverse('hola mundo');

//big(0) time complexity = 0(n)
//big(0) space complexity = 0(n)