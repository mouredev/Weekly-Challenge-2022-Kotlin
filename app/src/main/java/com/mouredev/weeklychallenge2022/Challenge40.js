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

module.exports.func = function pascalTriangle(height) {
  let triangle = [];

  for (let row = 0; row < height; row++) {
    let temp = [];
    for (let column = 0; column < height; column++) {
      temp.push(cell_value(row, column));
    }
    triangle.push(temp);
  }
  draw(triangle);
};

const cell_value = (row, column) => {
  if (column == 0 || row == column) return 1;
  if (row - column < 0) return 0;

  return cell_value(row - 1, column - 1) + cell_value(row - 1, column);
};

const draw = (arr) => {
  arr.forEach((row) => {
    console.log(row.join(" ").replace(/0/g, "").trim());
  });
  return 0;
};
