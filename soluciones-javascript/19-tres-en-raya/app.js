/*
 * Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
 * y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
 *   O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta.
 * Se podría representar con un vacío "", por ejemplo.
 */

/**
 * Función de Tres En Raya
 * @param {Array} matriz del juego por el usuario
 */
const tresEnRaya = (matriz) => {

    if ((matriz[0].length !== 3) || (matriz[1].length !== 3) || (matriz[2].length !== 3)) 
        return "Nulo";

    const arrayDeResultado = [ ...matriz[0], ...matriz[1], ...matriz[2] ];

    const combinacionesGanadoras = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
    ];

    const resultado = [];

    combinacionesGanadoras.forEach((combinacion) => {
        const [ a, b, c ] = combinacion;

        if( 
            arrayDeResultado[a] !== " " &&
            arrayDeResultado[a] === arrayDeResultado[b] &&
            arrayDeResultado[a] === arrayDeResultado[c]
        ){
            resultado.push(arrayDeResultado[a]);
        }

    });

    if ( resultado.includes('x') && resultado.includes('o')){
        return 'Nulo';
    }

    if (resultado.length === 0) {
        return 'Empate';
    }

    if(resultado.length > 0){
        return resultado[0].toUpperCase();
    }

    return 'Nulo';

};

console.log(
    "Gana O: " +
    tresEnRaya([
        ["x", "x", "o"],
        ["x", "o", " "],
        ["o", " ", " "],
    ])
);
console.log(
    "Gana x: " +
    tresEnRaya([
        ["x", "x", "x"],
        ["x", "o", "o"],
        ["o", "o", "x"],
    ])
);

console.log(
    tresEnRaya([
        ["o", "o", "x"],
        ["x", "x", "o"],
        ["o", "o", "x"],
    ])
);

console.log(
    tresEnRaya([
        ["o", "o", "o"],
        ["x", "x", "x"],
        [" ", " ", ""],
    ])
);