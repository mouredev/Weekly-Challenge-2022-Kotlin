/*
 * Implementa uno de los algoritmos de ordenación más famosos:
 * el "Quick Sort", creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia
 *   Nos ayuda a mejorar nuestro conocimiento sobre ingeniería de software.
 *   Dedícale tiempo a entenderlo, no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS",
 *   donde trabajaremos y entenderemos los más famosos de la historia.
 */

/**
 * 
 * @param {Array} array 
 */
const quickSort = (array) => {

    if (array.length <= 1 ) {
        return array;
    }

    const pivot = array[array.length - 1];
    const left = [];
    const right = [];

    for (let i = 0; i < array.length - 1; i++) {
        
        if (array[i] < pivot ) {
            left.push(array[i]);
        } else{
            right.push(array[i]);
        }

    }

    console.log({left, right})

    return [ ...quickSort(left), pivot, ...quickSort(right) ];

}

console.log(quickSort([ 8, 9, 3, 7, 1, 2, 6, 4]));