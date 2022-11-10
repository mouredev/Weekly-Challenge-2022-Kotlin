/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


/**
 * Emojis para representar el agua y los bloques y el vacio
 */
let emojis = ["🕋", "💧","🪖"];


/**
 * Funcion que rellena una fila con los emojis correspondientes de agua 💧 o bloque 🕋
 * @param maxValue Valor maximo de altura del bloque para el agua
 * @param value  Numero de bloques total que hay
 */
function fillRow(maxValue:number,value:number):string[]{
    let row = [];
    for(let i=0;i<value;i++){
        row.push(emojis[0]);
    }
    for(let i=0;i<maxValue - value;i++){
        row.push(emojis[1]);
    }
    return row
}

/**
 * Funcion que calcula las unidades de agua que se quedan atrapads entre los bloques
 * Se recorre empezando por los extremos del array comparando cada elemento.
 *  - Si el de la izquierda es mayor y es el mayor encontrado por la derecha , entonces ponemos
 * como maximo bloqque de altura ese valor.Si no contamos como bloques de agua , los bloques de altura maxima menos los que tiene
 * esa columna ya que son los que quedan atrapados , avanzamos a la siguiente columna y repetimos el proceso
 *  - Si la derecha es mayor que la izquierda y es el mayor de la izquierda , entonces ponemos
 *  como maximo bloque de altura por la izquierda ese valor.Si no contamos como bloques de agua los bloques de altura maxima menos
 *  los que tiene esa columna , avanzamos a la siguiente columna y repetimos el proceso.
 *  Avanzamos y repetimos hasta que la izquierda y la derecha se crucen.
 *
 * @param blocks Array de bloques de altura
 * @returns Numero de bloques de agua que quedan atrapados
 */
export function waterCount(blocks: number[]): number {
    let matrix = new Array<Array<string>>(blocks.length);
    let water = 0;
    let left = 0;
    let right = blocks.length - 1;

    let maxLeft = 0;
    let maxRight = 0;
    let maxTotal = 0

    while (left < right) {

        if(blocks[left]>blocks[right]){
            if (blocks[right] >= maxRight) {
                maxRight = blocks[right];
            } else {
                water += maxRight - blocks[right];
            }
            matrix[right] = fillRow(maxRight,blocks[right])
            right--;
        }
        else{
            if (blocks[left] >= maxLeft) {
                maxLeft = blocks[left];
            } else {
                water += maxLeft - blocks[left];

           }

            matrix[left] = fillRow(maxLeft,blocks[left])
            left++;
        }

        if(maxTotal < maxLeft){
            maxTotal = maxLeft;
        } else if(maxTotal < maxRight){
            maxTotal = maxRight;
        }

    }

    matrix[right] = fillRow(blocks[left],blocks[right]);

    if(maxTotal < blocks[right]){
        maxTotal = blocks[right];
    }


    //Draw matrix

    drawMatrixAsColumn(matrix,maxTotal)


    return water;

}

/**
 * Funcion que rellena la matriz de bloques y agua relleando las columnas que no tienen valor
 * para poder pintarla correctamente
 * @param matrix Matriz de bloques y agua
 * @param max Total de bloques de altura maxima
 */
 function calculateMatrix(matrix: Array<Array<string>>,max:number):string[][]{

     let val = new Array<Array<string>>(max);

     for(let i=0;i<max;i++){
         val[i] = new Array<string>(matrix.length);
         for (let j = 0; j < matrix.length; j++) {
             if(matrix[j][i] == undefined){
                 val[i][j] = emojis[2];
             }else{
                 val[i][j] = matrix[j][i];
             }
         }
     }
     return val

 }

/**
 * Funcion que pinta la matriz de bloques y agua ya rellenada por consola
 * @param matrix Matriz de bloques y agua
 * @param maxTotal Total de bloques de altura maxima
 */
function drawMatrixAsColumn(matrix: Array<Array<string>>,maxTotal:number){

    console.log("**********************")

    calculateMatrix(matrix,maxTotal).reverse().map((row, index) => {
        let rowString = "";
        row.map((column, index) => {
            rowString += column;
        })
        console.log(rowString);
    })

    console.log("**********************")


}

/*

         🕋
🕋💧💧💧💧🕋
🕋💧💧🕋💧🕋
🕋💧💧🕋💧🕋

*/


console.log(`Numero de bloques ${waterCount([3, 0, 0, 2, 0, 4])}`)

/*
     🕋
🕋💧💧🕋
🕋💧🕋🕋💧🕋
🕋💧🕋🕋💧🕋
🕋💧🕋🕋🕋🕋

*/

console.log(`Numero de bloques ${waterCount([3, 1, 6, 3, 0, 4])}`)

/*
     🕋
   🕋🕋💧💧💧💧💧💧💧💧💧💧💧 🕋
   🕋🕋💧💧🕋💧💧💧🕋💧💧💧💧🕋🕋💧🕋
🕋💧🕋🕋💧💧🕋🕋💧🕋🕋🕋💧🕋💧🕋🕋🕋🕋🕋

*/

console.log(`Numero de bloques ${waterCount([1,0,3,4,0,0,2,1,0,1,2,1,0,1,0,3,2,1,2,1])}`)