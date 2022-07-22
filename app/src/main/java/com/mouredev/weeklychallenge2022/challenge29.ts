/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

enum Order {
    Asc="Asc",
    Desc="Desc"
}

/**
 * Función que ordena una lista de números usando el algoritmo de ordenamiento QuickSort.
 * @param list Lista de números a ordenar
 * @param order Indica si la lista debe ser ordenada de menor a mayor o de mayor a menor
 * @returns Lista de números ordenada
 * @see https://www.youtube.com/watch?v=3San3uKKHgg
 * @see https://en.wikipedia.org/wiki/Quicksort
 * @see Order
 *
 */
function sort(list:number[],order:Order=Order.Asc):number[]{
    return quickSort(list,0,list.length-1,order);
}


/**
 * Funcion que orderna una lista de numberos a traves del algoritmo QuickSort
 * @param list Lista de números a ordenar
 * @param left Posición inicial de la lista
 * @param right Posición final de la lista
 * @param order Enumero que indica si se ordena de menor a mayor o de mayor a menor
 * @returns Lista de números ordenada
 */
function quickSort(list: number[],left:number,right:number,order:Order): number[] {

    if(left < right){
        let pivot = partition(list,left,right,order);
        quickSort(list,left,pivot-1,order)
        quickSort(list,pivot+1,right,order);
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
 * @param order Enum que indica si se ordena de menor a mayor o de mayor a menor
 * @returns posición del pivote en la lista
 */
function partition(list: number[],left:number,right:number,order:Order): number {

    let pivot = list[right];
    let i = left
    for(let j = left; j < right; j++){
        if(order == Order.Asc){
            if(list[j] <= pivot){
                swap(list,i,j);
                i++;
            }
        }else{
            if(list[j] >= pivot){
                swap(list,i,j);
                i++;
            }
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
console.log(`Ordenada Ascendente : ${sort(list, Order.Asc)}`)
console.log(`Ordenada descendente : ${sort(list, Order.Desc)}`)


