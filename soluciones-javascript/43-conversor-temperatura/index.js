/*
 * Crea una función que transforme grados Celsius en Fahrenheit
 * y viceversa.
 *
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°"
 *   y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 */

/**
 * 
 * @param {String} grados 
 */
const conversorTemperatura = ( grados ) => {

    const reglaRegex = /^-?\d+(\.\d+)?\s*°\s*[cCfF]$/;
    
    if (!reglaRegex.test(grados)) {
        return "Error en el formato"
    }

    const numGrado = grados.split('').map((g) => {
        return !isNaN(Number(g)) ? g : null 
    }).join('');

    const condicion = grados.split('').filter((letra) => letra === "C" || letra === "F" ).join('');

    if (condicion === "C") {

        return `${numGrado * (9 / 5) + 32} °F`; 

    } else if ( condicion === "F" ){

        return `${(numGrado - 32 ) * (5 / 9)} °C`; 

    } else {
        return "Error en la letra"
    }
}

// Pruebas
console.log(conversorTemperatura("25 °C"));   // 77.00 °F
console.log(conversorTemperatura("77 °F"));   // 25.00 °C
console.log(conversorTemperatura("abc °C"));  // Error en el formato