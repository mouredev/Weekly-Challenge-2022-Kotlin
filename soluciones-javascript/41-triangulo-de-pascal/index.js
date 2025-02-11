/*
 * Crea una función que sea capaz de dibujar el "Triángulo de Pascal"
 * indicándole únicamente el tamaño del lado.
 *
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 */

const generarTrianguloPascal = (n) => {
    let triangulo = [];
    
    for (let i = 0; i < n; i++) {
        triangulo[i] = [];
        for (let j = 0; j <= i; j++) {
            if (j === 0 || j === i) {
                triangulo[i][j] = 1;
            } else {
                triangulo[i][j] = triangulo[i - 1][j - 1] + triangulo[i - 1][j];
            }
        }
    }
    
    return triangulo;
}

const imprimirTrianguloPascal = (triangulo) => {
    let n = triangulo.length;
    let resultado = "";
    
    for (let i = 0; i < n; i++) {
        let espacio = " ".repeat(n - i);
        let fila = triangulo[i].join(" ");
        resultado += espacio + fila + "\n";
    }
    
    console.log(resultado);
}

let n = 5; // Tamaño del triángulo
let triangulo = generarTrianguloPascal(n);
imprimirTrianguloPascal(triangulo);
