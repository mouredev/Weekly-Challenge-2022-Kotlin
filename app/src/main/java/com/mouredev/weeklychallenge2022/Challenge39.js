/*
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos:
 * el "Quick Sort", creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia
 *   nos ayuda a mejorar nuestro conocimiento sobre ingeniería de software.
 *   Dedícale tiempo a entenderlo, no únicamente a copiar su implementación.
 * 
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS",
 *   donde trabajaremos y entenderemos los más famosos de la historia.
 */

const quickSort = (arr) => {
  if (arr.length < 1) {
    return [];
  }

  let menores = [],
    mayores = [];

  for (let i = 1; i < arr.length; i++) {
    arr[i] < arr[0] ? menores.push(arr[i]) : mayores.push(arr[i]);
  }

  return [].concat(quickSort(menores), arr[0], quickSort(mayores));
};

console.log(quickSort([14, 8, 1234, 7, 1, 2, 4, 22, 3, 44, 5, 66, 0, 9, 2]));
