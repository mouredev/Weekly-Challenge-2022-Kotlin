/*
 * Reto #27
 * VECTORES ORTOGONALES
 * Fecha publicación enunciado: 07/07/22
 * Fecha publicación resolución: 11/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */



/*
* Dos vectores son ortogonales si su producto punto es cero.
* cos(a) = u.v / |u||v|
* si cos(a) = 0 => a = 90 grados => son ortogonales
*/

const AreOrtogonals = (u, v) => {

    if( !ValidVector(u) || !ValidVector(v) ) return "Entrada no valida";
    if( u.length !== v.length ) return "Los vectores no tienen el mismo tamanno";

    return ( PointProduct(u, v) == 0 ) ? "Los vectores son ortogonales" : "Los vectores no son ortogonales";
}

const PointProduct = (u, v) => {
    let product = 0;
    for(let i = 0; i < u.length; i ++)
        product += (u[i] * v[i]);

    return product;
}

const ValidVector = ( vector ) => {
    return ( vector !== null && vector !== undefined && vector.length > 0 );
}


const u = [1, 3];
const v = [-3, 1];

console.log( AreOrtogonals(u, v) );

