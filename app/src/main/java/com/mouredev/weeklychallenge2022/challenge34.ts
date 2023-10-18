/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


function missingNumbers(array:number[]):number[] {

    let missingNumbersArray: number[] = []
    if(!checkArray(array)) {
        return [];
    }



    else{

        let min = array[0];
        let max = array[array.length - 1];

        for(let i = min; i < max; i++){
            if(array.includes(i) === false){
                missingNumbersArray.push(i);
                }
            }
        }

        return missingNumbersArray
    }



function checkArray(array:number[]):boolean {

    if(array.length < 2) {
        console.log("Array debe tener al menos 2 elementos");
        return false;
    }
    var uniqs = (array.filter(function(item, index, array) {
        return array.indexOf(item) === index;
    }))

    if(uniqs.length !== array.length) {
        console.log("Array no debe tener elementos repetidos");
        return false;
    }

    let copyArray = array.slice();

    let arraysorted = array.sort((a,b) => a - b);

    for(let i = 0; i < arraysorted.length - 1; i++) {
        if(arraysorted[i]!= copyArray[i]) {
            console.log("Array no está ordenado");
            return false;
        }
    }

    return true
}

console.log(missingNumbers([1,6,10]));
console.log(missingNumbers([16,1]));
console.log(missingNumbers([1,2,2,10,30]));
