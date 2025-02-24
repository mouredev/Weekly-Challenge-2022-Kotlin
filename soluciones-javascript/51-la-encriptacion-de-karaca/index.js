/*
 * Crea una función que sea capaz de encriptar y desencriptar texto
 * utilizando el algoritmo de encriptación de Karaca
 * (debes buscar información sobre él).
 */


/**
 * Algoritmo de encriptación de karaca
 * @param {String} string
 */
const encriptarTexto = ( string ) => {

    const convencionVocales = {
        a: 0,
        e: 1,
        i: 2,
        o: 3,
        u: 4,
    };

    const reverseString = string.split('').reverse().map((element) => {
        for (let i = 0; i < Object.keys(convencionVocales).length; i++) {
            if( element === Object.keys(convencionVocales)[i]){
                return Object.values(convencionVocales)[i];
            }
        }
        return element;
    }).join('');

    return reverseString + "aca";

}

/**
 * Algoritmo de desencriptación de karaca
 * @param {String} stringEncriptado
 */
const desencriptarTexto = (stringEncriptado) => {
    const convencionVocales = {
        a: 0,
        e: 1,
        i: 2,
        o: 3,
        u: 4,
    };

    const stringWithoutAca = stringEncriptado.replace('aca', '');

    return stringWithoutAca.split('').map((element) => {
        for (let i = 0; i < Object.keys(convencionVocales).length; i++) {
            if( Number(element) === Object.values(convencionVocales)[i]){
                return Object.keys(convencionVocales)[i];
            }
        }
        return element;
    }).reverse().join('');

}

const textoEncriptado = encriptarTexto('apple');
console.log("Texto encriptado: " + textoEncriptado);
console.log("Texto desencriptado: " + desencriptarTexto(textoEncriptado));