/*
 * Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 */

/**
 * 
 * @param {Array} vectorA 
 * @param {Array} vectorB 
 * @returns boolean
 */
const esVectorOrtogonal = (vectorA, vectorB) => {

    if ( vectorA.length !== vectorB.length ) throw new Error("Los Vectores deben tener la misma longitud");
    
    let productoEscalar = 0;

    vectorA.forEach( (vector, index) => {
        productoEscalar += ( vector * vectorB[index]);
    });

    return productoEscalar === 0;

}

// Ejemplo de uso:
console.log(esVectorOrtogonal([1, -2], [2, 1])); // true (son ortogonales)
console.log(esVectorOrtogonal([1, 2, 3], [4, 5, 6])); // false (no son ortogonales)