/*
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal"
 * indicándole únicamente el tamaño del lado.
 *
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 */

const pascalTriangle = (side = 0) => {
  if (typeof side !== "number") return `${side} is not a number`;
  if (side === 0) return [];
  if (side === 1) return [[1]];
  if (side < 0) side = Math.abs(side);

  let triangle = [];

  for (let i = 1; i <= side; i++) {
    let arr = [];
    for (let o = 0; o < i; o++) {
      o === 0 || o === i - 1
        ? arr.push(1)
        : arr.push(triangle[i - 2][o - 1] + triangle[i - 2][o]);
    }
    triangle.push(arr);
  }
  return triangle;
};

console.log(pascalTriangle("sadasd"));
console.log(pascalTriangle());
console.log(pascalTriangle(0));
console.log(pascalTriangle(1));
console.log(pascalTriangle(6));
console.log(pascalTriangle(-3));