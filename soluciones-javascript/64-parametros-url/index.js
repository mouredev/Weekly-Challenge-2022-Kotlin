/*
 * Dada una URL con parámetros, crea una función que obtenga sus valores.
 * No se pueden usar operaciones del lenguaje que realicen esta tarea directamente.
 *
 * Ejemplo: En la url https://retosdeprogramacion.com?year=2023&challenge=0
 * los parámetros serían ["2023", "0"]
 */

/**
 *
 * @param {String} url
 */
const getParametrosByURL = ( url ) => {
    const valores = [];

    // Buscar la parte de los parámetros en la URL
    const indiceInterrogacion = url.indexOf("?");
    if(indiceInterrogacion === -1) return valores;

    const parametros = url.slice(indiceInterrogacion + 1);
    const pares = parametros.split("&");

    for (const par of pares) {
        const partes = par.split("="); // separar clave y valor
        if(partes.length === 2){
            valores.push(partes[1]); // Agregar solo el valor
        }
    }

    return valores;
}

console.log(getParametrosByURL("https://retosdeprogramacion.com?year=2023&challenge=0"));