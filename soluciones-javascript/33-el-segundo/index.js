/*
 * Dado un listado de números, encuentra el SEGUNDO más grande
 */

/**
 * 
 * @param {Array} lista 
 */
const elSegundoMasGrande = (lista) => {

    const listaFormateada = lista.filter( (value, index, array) => array.indexOf(value) === index); 

    listaFormateada.sort((a, b) => b - a ).shift();

    return listaFormateada.shift();

}

console.log(elSegundoMasGrande([1,98,2,4,56,8,9,55]));
console.log(elSegundoMasGrande([100, 100, 50])); // Retorna 50 (Correcto)
console.log(elSegundoMasGrande([100, 100])); // Retorna 100 (Incorrecto, debería ser undefined o indicar que no hay segundo más grande)
console.log(elSegundoMasGrande([42])); // Retorna undefined (No hay segundo más grande)
console.log(elSegundoMasGrande([])); // Retorna undefined (Correcto, pero podría manejarse mejor)
