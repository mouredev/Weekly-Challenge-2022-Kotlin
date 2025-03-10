/*
 * Dado un array de enteros ordenado y sin repetidos,
 * crea una función que calcule y retorne todos los que faltan entre
 * el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 */

/**
 * 
 * @param {Array} array 
 */
const numerosPerdidos = (array) => {

    if (!Array.isArray(array)) throw new Error("El parámetro debe ser un array.");
    if (array.length === 0) throw new Error("El array no debe estar vacío.");
    if (!array.every(num => Number.isInteger(num))) throw new Error("Todos los elementos deben ser números enteros.");
    
    // Verificar si el array está ordenado de menor a mayor
    for (let i = 0; i < array.length - 1; i++) {
        if (array[i] >= array[i + 1]) {
            return "El array debe estar ordenado de menor a mayor y sin repetidos.";
        }
    }
    
    const numerosFaltantes = [];

    for (let i = 0; i < array.length; i++) {
        
        const numeroSuperior = array[i + 1] || 0;

        if ( (numeroSuperior - array[i]) > 1){
            const diferencial = (numeroSuperior - array[i]);  
            
            for (let j = 1; j < diferencial; j++) {
                numerosFaltantes.push(numeroSuperior - (diferencial - j));       
            }

        }

    }

    return numerosFaltantes;

}

// Pruebas
console.log(numerosPerdidos([1, 3, 4, 7])); // [2, 5, 6]
console.log(numerosPerdidos([1, 4, 10]));   // [2, 3, 5, 6, 7, 8, 9]
console.log(numerosPerdidos([5, 6, 8, 17, 20])); // [7, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19]
console.log(numerosPerdidos([1, 2, 3, 4, 5])); // []