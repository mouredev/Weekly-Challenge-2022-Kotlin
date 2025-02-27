/*
 * Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras
 *        "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo)
 *        o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
 *        será correcto y no variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 */

/**
 * Función para determinar si un atleta ha superado correctamente un carrera de obstaculos
 * @param {Array} acciones Array de palabras run | jump
 * @param {String} pista String que contiene la pista
 */
const carreraObstaculos = ( acciones, pista ) => {
    
    if ( acciones.length !== pista.length ) 
        throw new Error("Las longitudes no coinciden");

    if( !Array.isArray(acciones) || typeof pista !== 'string') 
        throw new Error("Parámetros inválidos: Se espera un array y un string");
        
    let resultado = true;
    let nuevaPista = '';

    acciones.forEach(( accion, index) => {

        const tramo = pista[index];

        if( tramo === '_' && accion === 'run' ){
            nuevaPista += tramo;
        } else if ( tramo === '|' && accion === 'jump' ){
            nuevaPista += tramo;
        }else if( tramo === '_' && accion === 'jump' ){
            nuevaPista += 'x';
            resultado = false;
        } else if ( pista[index] === '|' && accion === 'run' ){
            nuevaPista += '/';
            resultado = false; 
        } else {
            throw new Error("Tramo no identificado");
        }
    });

    console.log(nuevaPista);
    
    return resultado; 

}

const arrayDeAcciones = ['run', 'run', 'run', 'jump', 'run', 'jump', 'jump', 'jump', 'run', 'run', 'jump', 'run',];

carreraObstaculos( arrayDeAcciones, '___|_|||__|_');