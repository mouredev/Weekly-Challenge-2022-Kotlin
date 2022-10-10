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

/**
 * https://es.wikipedia.org/wiki/Tri%C3%A1ngulo_de_Pascal
 * */

/**
 * Funcion que calcula el factorial de un numero
 * @param n numero a calcular el factorial
 * @returns factorial del numero
 */
function factorial(n: number): number {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
}

/**
 * Funcion que calcula la combinacion de 2 numeros
 * @param n1 Primer numero de la combinacion
 * @param n2 Segundo numero de la combinacion
 * @returns Calculo de la combinacion
 */
function combining(n1: number, n2: number): number {
    return factorial(n1) / (factorial(n2) * factorial(n1 - n2));
}

/**
 * Funcion que calcula el triangulo de pascal
 * @param size tamaño del triangulo
 * @returns triangulo de pascal
 * */

export function pascalTriangle(size: number): number[]{
   let triangle = [];

   for(let i = 0; i < size; i++) {
       for(let j = 0; j <= i; j++) {
            triangle.push(combining(i, j));
       }
   }

   return triangle


}


/**
 * Funcion que dibuja el triangulo de pascal en pantalla
 * @param size Tamaño del triangulo que se quiere dibujar
 */
function drawPascalTriangle(size:number): void {
    let triangle = pascalTriangle(size);
    console.log(triangle);
    let initial=0
    for (let i = 0; i < size; i++) {
        console.log("  ".repeat(size-i) + triangle.slice(initial, initial+i+1).join("   "));
        initial+=i+1

   }
}

drawPascalTriangle(3)
