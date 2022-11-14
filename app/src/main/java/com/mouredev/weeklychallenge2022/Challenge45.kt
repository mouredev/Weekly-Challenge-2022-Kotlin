package com.mouredev.weeklychallenge2022

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

const countWaterInBlocks = (array) => {
 // Si el array tiene un tamaño <3 es imposible que contenga agua
  if(array?.length < 3) {
  return 0;
  }
  // Si no hay bloques no es posible retener agua
  if(!contieneBloques(array)) return 0;
 
  let waterElements = 0;
 
  while(contieneBloques(array)) {
    const fila = getFila(array);
    waterElements = waterElements + getWaterInFile(array);
    array = removeFileArray(array);
  }
 
  return waterElements;
 
};

 // Eliminamos fila
const removeFileArray = (array) => {
  return array.map( (element) => {
    if(element > 0) {
      return element - 1;
    }
      return element
   });
}

// Metodo que nos indica si el array contiene bloques
const contieneBloques = (array) => array.some(element => element > 0);

// Obtenemos en numero de elementos de agua por fila
const getWaterInFile = (array) =>  {
  let aguaTotal = 0;
  let hayBloqueInicial = false;
  let contAgua = 0;
  for( let i= 0; i < array.length; i++) {
    if(array[i] > 0) {
      // bloque
      if(!hayBloqueInicial) {
        hayBloqueInicial = true;
      } else {
        aguaTotal = aguaTotal + contAgua;
        contAgua = 0;
      }
      hayBloqueInicial = true;
    } else {
      // agua
      if( hayBloqueInicial ) {
        contAgua++;
      } // if
    } // else
  }// for
 
  return aguaTotal;
 
}

// Ejemplo 1
 console.log(countWaterInBlocks([4, 0, 3, 6, 1, 3]));
// Ejemplo 2
console.log(countWaterInBlocks([4, 0, 0, 0, 0, 4]));
// Ejemplo 3
console.log(countWaterInBlocks([1, 0, 0, 0, 0, 4]));
// Ejemplo 4
console.log(countWaterInBlocks([4, 0, 0, 7, 0, 0, 4]));
// Ejemplo 5
console.log(countWaterInBlocks([1, 0, 0, 7, 0, 0, 4]));
// Ejemplo 6
console.log(countWaterInBlocks([2, 5, 4, 7, 8, 6, 4]));
// Ejemplo 7
console.log(countWaterInBlocks([4, 2, 6]));
// Ejemplo 8
console.log(countWaterInBlocks([4, 2]));