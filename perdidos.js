/*
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, 
 * crea una función que calcule y retorne todos los que faltan entre
 * el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 */

let array = [2, 4, 6, 8, 14, 24];

buscaPerdidos = (matriz) => {
    //Verificamos que el array es OK!
    let error = false;

    matriz.map((n) => {isNaN(n) ? error = "No son sólo números!" : ""});
    matriz.map((n) => {!Number.isInteger(n) ? error = "No son enteros!" : ""});
    matriz.map((n, i) => { (n >= array[i+1]) ? error = "No están ordenados o hay alguno repetido!" : ""});
    
    if (error) { return error }

    let min = matriz[0];
    let max = matriz[matriz.length - 1];
    let resultado = [];

    for (let i = min; i <= max; i++) {
        !matriz.includes(i) ? resultado.push(i) : console.log(`${i} está en el array.`);
    }
    return resultado;
}
console.log(buscaPerdidos(array));

