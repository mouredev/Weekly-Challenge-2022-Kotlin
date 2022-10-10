/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function PrintTriangle(triangle) {
    let string = ""
    const n = triangle.length
    const m = 2*n-1
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (j < (m / 2) - i) {
                string += " "
            }
        }
        string += (triangle[i].join(" "))
        string += "\n"
    }
    console.log(string);
}

function PascalTriangle(n) {
    let triangle = []
    for (let i = 0; i < n; i++) {
        triangle[i] = []
        if (i == 0) {
            triangle[i][0] = 1
        } else if (i == 1) {
            triangle[i][0] = 1
            triangle[i][1] = 1
        } else {
            for (let j = 0; j < i + 1; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                }
                if (j + 1 < i) {
                    triangle[i][j+1] = triangle[i-1][j] + triangle[i-1][j+1] 
                }
            }
        }
        
    }
    return triangle
}

PrintTriangle(PascalTriangle(5));

