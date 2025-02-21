/*
 * Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro
 *   adicional "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor
 *   o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan
 *   automáticamente.
 */

const ordenarAsc = (lista) => {
    let n = lista.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (lista[j] > lista[j + 1]) {
                let temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
    return lista;
};

const ordenarDesc = (lista) => {
    let n = lista.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (lista[j] < lista[j + 1]) {
                let temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
            }
        }
    }
    return lista;
};
/**
 * Función para ordenar un array de números
 * @param {Array} lista 
 * @return ArrayOrdenado
 */
const ordenarLista = ( lista, indicacion ) => {
    
    if ( !lista.every((num) => typeof num === "number" )){
        return "Error: los elementos del array no son un número"
    };

    switch (indicacion) {
        case "Asc":
            return ordenarAsc([...lista]);
        case "Desc":
            return ordenarDesc([...lista]);
        default:
            return "Error: indicación no válida";
    }

}

// Pruebas
console.log(ordenarLista([5, 2, 9, 1, 5, 6], "Asc"));  // [1, 2, 5, 5, 6, 9]
console.log(ordenarLista([3, 8, 2, 7, 4], "Desc"));   // [8, 7, 4, 3, 2]
