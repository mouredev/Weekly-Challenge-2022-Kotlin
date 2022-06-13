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
  return operateTree(buildOperationsTree(data));
};

const buildOperationsTree = (data) => {
  const getPriorityCode = (element) => {
    const priorities = {
      '+': 1,
      '-': 1,
      '*': 2,
      '/': 2,
    };
    return priorities[element] ?? -1;
  };

  const validateElement = (element, previousElement) => {
    if (previousElement !== null && getPriorityCode(element) * getPriorityCode(previousElement) > 0) {
      throw new Error(`Invalid data. Element: ${element} while previousElement: ${previousElement}`);
    }
    return true;
  };

  const Node = (element, left, right) => {
    return { element, left, right };
  };

  let root = null;
  let previousElement = null;

  for (let element of data) {
    validateElement(element, previousElement);
    previousElement = element;
    const parsedElement = +element;
    if (isNaN(parsedElement)) {
      //element is an operator
      const elementPriority = getPriorityCode(element);
      if (
        elementPriority <= getPriorityCode(root.element) ||
        typeof root.element === 'number'
      ) {
        const newNode = Node(element, root, null);
        root = newNode;
      } else {
        const newNode = Node(element, root.right, null);
        root.right = newNode;
      }
    } else {
      //element is a number
      if (root === null) {
        root = Node(parsedElement, null, null);
      } else {
        const newNode = Node(parsedElement, null, null);
        let pAux = root;
        while (pAux.right !== null) {
          pAux = pAux.right;
        }
        pAux.right = newNode;
      }
    }
  }
  if (isNaN(+previousElement)) {
    throw new Error(`Invalid data. Last element: ${previousElement}`);
  }
  return root;
};



const operateTree = (tree) => {
  const operations = {
    '+': (a, b) => a + b,
    '-': (a, b) => a - b,
    '*': (a, b) => a * b,
    '/': (a, b) => a / b,
  };
  if (!tree.left && !tree.right) return tree.element;
  return operations[tree.element](
    operateTree(tree.left),
    operateTree(tree.right)
  );
};


/**
 * Receives a file path which contains a sucession of operations and returns the result
 * @param {string} uri File path
 * @returns {number} Final result
 */
const calculateFromFile = (uri) => calculateData(getDataFromPath(uri));

module.exports = { calculateFromFile, calculateData };