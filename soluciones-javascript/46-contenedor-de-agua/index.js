/*
 * Dado un array de números enteros positivos, donde cada uno
 * representa unidades de bloques apilados, debemos calcular cuantas unidades
 * de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *          ⏹
 *          ⏹
 *   ⏹💧💧 ⏹
 *   ⏹💧⏹⏹💧  ⏹
 *   ⏹💧⏹⏹💧  ⏹
 *   ⏹💧⏹⏹⏹ ⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades
 *   de agua. Suponemos que existe un suelo impermeable en la parte inferior
 *   que retiene el agua.
 */

const contenedorDeAgua = (array) => {
    if (array.length < 3) return 0; // Si hay menos de 3 bloques, no puede atraparse agua

    const n = array.length;
    let aguaAtrapada = 0;

    // Arrays auxiliares para almacenar el máximo a la izquierda y a la derecha
    let maxIzq = new Array(n).fill(0);
    let maxDer = new Array(n).fill(0);

    // Rellenar maxIzq
    maxIzq[0] = array[0];
    for (let i = 1; i < n; i++) {
        maxIzq[i] = Math.max(maxIzq[i - 1], array[i]);
    }

    // Rellenar maxDer
    maxDer[n - 1] = array[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        maxDer[i] = Math.max(maxDer[i + 1], array[i]);
    }

    // Calcular el agua atrapada en cada posición
    for (let i = 0; i < n; i++) {
        aguaAtrapada += Math.max(0, Math.min(maxIzq[i], maxDer[i]) - array[i]);
    }

    return aguaAtrapada;
};

// Ejemplo de uso
console.log(contenedorDeAgua([4, 0, 3, 6, 1, 3])); // Output: 7
console.log(contenedorDeAgua([4, 0, 3, 6]));
console.log(contenedorDeAgua([5, 4, 3, 2, 1, 0]));
console.log(contenedorDeAgua([0, 1, 2, 3, 4, 5]));
console.log(contenedorDeAgua([4, 0, 3, 6, 1, 3, 0, 1, 6]));
