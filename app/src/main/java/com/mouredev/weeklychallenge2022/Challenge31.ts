/**
 * Reto semanal 31: Años bisiestos
 * Crear una función que reciba un año y devuelva los siguientes 30 años bisiestos
 * language: typescript
 */
export const bisiestos = (year: number): number[] => Array.from({ length: 30 }, (v: any, i) => (v = (latestYear: number) => ((latestYear % 400 === 0 && latestYear % 100 !== 0) || latestYear % 4 === 0 ? (year = latestYear + 1) && latestYear : v(latestYear + 1))) && v(year));

/**
 * Explicación de la solución en una linea de código
 */

const bisiestosFn = (
  year: number
): number[] => // Arrow function que recibe un año y devuelve los siguientes 30 años bisiestos
  Array.from(
    { length: 30 }, // crea un array de 30 elementos
    (
      v: any, // valor actual de la iteración del array
      _i: number // índice actual de la iteración del array
    ) =>
      // el valor actual (v) es undefined ya que el array se crea con elementos vacíos por lo que la aprovechamos para crear una función recursiva que devuelve el siguiente año bisiesto
      (v = (latestYear: number) =>
        (latestYear % 400 === 0 && latestYear % 100 !== 0) || latestYear % 4 === 0 // validamos si el año es bisiesto
          ? (year = latestYear + 1) && // si es bisiesto se reasigna el valor del año (year) para que en la próxima ejecución empiece desde ese año
            latestYear //devolvemos el año bisiesto
          : v(latestYear + 1)) && // si no es bisiesto se llama a la función recursiva con el año + 1
      v(year) // se inicia la ejecución de la función recursiva con el año que se ingresó a la función principal
  );
