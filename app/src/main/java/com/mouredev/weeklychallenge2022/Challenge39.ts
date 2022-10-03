
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


/**
 * Función que ordena una lista de números usando el algoritmo de ordenamiento QuickSort.
 * @param list Lista de números a ordenar
 * @returns Lista de números ordenada
 * @see https://www.youtube.com/watch?v=3San3uKKHgg
 * @see https://en.wikipedia.org/wiki/Quicksort
 *
 */

export function sort(list: number[]): number[] {
  return quickSort(list, 0, list.length - 1);
}


/**
 * Funcion que orderna una lista de numberos a traves del algoritmo QuickSort
 * @param list Lista de números a ordenar
 * @param left Posición inicial de la lista
 * @param right Posición final de la lista
 * @returns Lista de números ordenada
 */
function quickSort(list: number[],left:number,right:number): number[] {

    if(left < right){
        let pivot = partition(list,left,right);
        quickSort(list,left,pivot-1)
        quickSort(list,pivot+1,right);
    }
    return list;

}
/**
 * Función que intercambia dos elementos de una lista usando una variable temporal
 * @param list Lista de números a ordenar
 * @param i Posición del primer elemento a intercambiar
 * @param j Posición del segundo elemento a intercambiar
 */
function swap(list: number[],i:number,j:number){
    let temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}

/**
 * Funcion que busca el pivote para usar el algoritmo quickSort
 * @param list Lista de números a ordenar
 * @param left Posición inicial de la lista
 * @param right Posición final de la lista
 * @returns posición del pivote en la lista
 */
function partition(list: number[],left:number,right:number): number {

    let pivot = list[right];
    let i = left
    for(let j = left; j < right; j++){
            if(list[j] <= pivot){
                swap(list,i,j);
                i++;

            }
    }
    swap(list,i,right);
    return i;
}


/**
 * Main
 */

const list = [28, 11, 96, -5, 21, 18, 12, 22, 30, 97, -1, -40, -500]

console.log(`Array : ${list}`)
console.log(`Ordenada ${sort(list)}`);
