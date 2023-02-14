/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/*
 * requirements
 * Node
 *
 * Execution:
 * node Challenge41_test.js
 */

module.exports.func = function ohm(input) {
  if (invalidArr(input)) return "Invalid values";

  let usedFunction = "";
  let operation = 0;
  switch (emptyIndex(input)) {
    case 0:
      usedFunction = "voltage";
      operation = voltage(parseFloat(input[1]), parseFloat(input[2]));
      break;
    case 1:
      usedFunction = "current";
      operation = current(parseFloat(input[0]), parseFloat(input[2]));
      break;
    case 2:
      usedFunction = "resistance";
      operation = resistance(parseFloat(input[0]), parseFloat(input[1]));
      break;
  }
  return { var: usedFunction, val: operation };
};

const invalidArr = (arr) => {
  if (arr.some((elem) => elem.match(/[a-zA-Z]/g))) return true;

  if (arr.filter((elem) => elem == "").length != 1) return true;

  return false;
};

const emptyIndex = (arr) => arr.indexOf("");

const voltage = (current, resistance) => (current * resistance).toFixed(2);

const current = (voltage, resistance) => (voltage / resistance).toFixed(2);

const resistance = (voltage, current) => (voltage / current).toFixed(2);
