/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Reads the file content and returns a list with its items
 * @param {string} uri File path 
 * @returns {*[]} A list with the lines of the file
 */
const getDataFromPath = (uri) => {
  const fs = require('node:fs');
  return fs.readFileSync(uri, 'utf8').split(/\r?\n/);
};

/**
 * Receives a sucession of operations and returns the result
 * @param {number[]} data A list with the operations
 * @returns {number} Final result
 */
const calculateData = (data) => {
  const res = operateRPN(getRPN(data));
  if (isNaN(res)) throw new Error('Invalid data');
};

const getRPN = (infixExp) => {
  let stack = [];
  let postfixExp = [];
  let operators = {
    '+': 1,
    '-': 1,
    '*': 2,
    '/': 2,
  };
  function parse(expression) {
    if (expression.length === 0) {
      if (stack.length > 0) {
        while (stack.length > 0) {
          postfixExp = [...postfixExp, stack.pop()];
        }
      }
      return postfixExp;
    }
    if (/[0-9]/.test(expression[0])) {
      postfixExp = [...postfixExp, expression[0]];
    } else {
      if (expression[0] in operators) {
        while (stack.length > 0) {
          if (operators[expression[0]] <= operators[stack[stack.length - 1]]) {
            postfixExp = [...postfixExp, stack.pop()];
          } else {
            break;
          }
        }
        stack.push(expression[0]);
      }
    }
    expression = expression.slice(1);
    return parse(expression);
  }
  return parse(infixExp);
};

const operateRPN = (rpnExp) => {
  const operations = {
    '+': (a, b) => a + b,
    '-': (a, b) => a - b,
    '*': (a, b) => a * b,
    '/': (a, b) => a / b,
  };

  let stack = [];
  for (let element of rpnExp) {
    if (element === '+' || element === '-' || element === '*' || element === '/') {
      const right = stack.pop();
      const left = stack.pop();
      stack.push(operations[element](left, right));
    } else {
      stack.push(parseInt(element));
    }
  }
  return stack[0];
};


/**
 * Receives a file path which contains a sucession of operations and returns the result
 * @param {string} uri File path
 * @returns {number} Final result
 */
const calculateFromFile = (uri) => calculateData(getDataFromPath(uri));

module.exports = { calculateFromFile, calculateData };