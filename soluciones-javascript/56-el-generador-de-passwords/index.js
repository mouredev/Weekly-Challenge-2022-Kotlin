/*
 * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros:
 * - Longitud: Entre 8 y 16.
 * - Con o sin letras mayúsculas.
 * - Con o sin números.
 * - Con o sin símbolos.
 * (Pudiendo combinar todos estos parámetros entre ellos)
 */

/**
 *
 * @param {Object} parameters
 */
const passwordGenerator = ( parameters ) => {

    const numbers = [1,2,3,4,5,6,7,8,9,0];
    const symbolsRules = ["@", "$","#","&","%","+"];
    const alphabet = ["a", "b", "c", "d", "e", "f", "g","h","i","j","k","l","m","ñ","o","p","q","r","s","t","w","x","y","z"];

    const { length, lowerOrUpperCase, includeNumbers, includeSymbols } = parameters;

    if ( length < 8 || length > 16 ) {
        return "Error, la longitud debe estar entre 8 y 16"
    }

    let characters = alphabet;

    if( lowerOrUpperCase ){
        characters = characters.concat(alphabet.map(c => c.toUpperCase()))
    }

    if ( includeNumbers ) {
        characters = characters.concat(numbers);
    }

    if ( includeSymbols ) {
        characters = characters.concat( symbolsRules );
    }

    let password = '';

    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * characters.length);
        password += characters[randomIndex]
    }

    return "Password: " + password;

}

// Ejemplo de uso
console.log(passwordGenerator({ length: 16, lowerOrUpperCase: true, includeNumbers: true, includeSymbols: true }));