/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */

/**
 * Función que recibe dos cadenas de texto como entrada y genera dos nuevas cadenas como salida
 * - La primera cadena de salida (`out1`) contiene los caracteres presentes en `str1` pero no en `str2`.
 * - La segunda cadena de salida (`out2`) contiene los caracteres presentes en `str2` pero no en `str1`.
 * @param {String} str1 Cadena de texto 1
 * @param {String} str2 Cadena de texto 2
 * @returns {{ out1: string, out2: string }} Un objeto con dos propiedades:
 *   - `out1`: Cadena con los caracteres exclusivos de `str1`.
 *   - `out2`: Cadena con los caracteres exclusivos de `str2`.
 */
const eliminandoCaracteres = ( str1, str2 ) => {

    if( str1.trim() === str2.trim() ) return `Cadenas de texto iguales: Cadena 1: ${str1} Cadena 2: ${str2}`;

    const str1Unique = [...new Set(str1)];
    const str2Unique = [...new Set(str2)];

    const out1 = str1Unique.filter( char  => !str2Unique.includes(char)).join('');
    const out2 = str2Unique.filter( char  => !str1Unique.includes(char)).join('');
    
    return { out1, out2 }

}

console.log(eliminandoCaracteres('cadena similar', 'cadena diferente'));
