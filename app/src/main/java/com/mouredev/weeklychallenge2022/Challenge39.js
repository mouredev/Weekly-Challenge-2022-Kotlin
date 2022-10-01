/*
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/* Solución:
 * Requerimientos:
 * Node v 16.15.1
 *
 * Ejecución:
 * node Challenge39_test.js
 */

// QuickSort solution: https://www.geeksforgeeks.org/quick-sort/ for Always pick the last element as pivot

// Partition function for picking the first element as pivot is original

module.exports.func = function quickSortExec(arr) {
  let newArr = arr;
  let n = newArr.length;
  quickSort(newArr, 0, n - 1);
  return newArr;
};

const quickSort = (arr, low, high) => {
  if (low < high) {
    // let pi = partition(arr, low, high);
    let pi = sortingSelect(arr, low, high);
    quickSort(arr, low, pi - 1);
    quickSort(arr, pi + 1, high);
  }
};

const partition_pivot_last = (arr, low, high) => {
  let pivot = arr[high];
  let i = low - 1;
  for (let j = low; j <= high - 1; j++) {
    if (arr[j] < pivot) {
      i++;
      swap(arr, i, j);
    }
  }
  swap(arr, i + 1, high);
  return i + 1;
};

const partition_pivot_first = (arr, low, high) => {
  let pivot = arr[low];
  let j = high + 1;
  for (let i = high; i >= low + 1; i--) {
    if (arr[i] > pivot) {
      j--;
      swap(arr, i, j);
    }
  }
  swap(arr, low, j - 1);
  return j - 1;
};

const swap = (arr, i, j) => {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
};

const sortingSelect = (arr, low, high) => {
  const sortingOption = Math.floor(Math.random() * 2);
  if (sortingOption == 0) return partition_pivot_first(arr, low, high);
  return partition_pivot_last(arr, low, high);
};
