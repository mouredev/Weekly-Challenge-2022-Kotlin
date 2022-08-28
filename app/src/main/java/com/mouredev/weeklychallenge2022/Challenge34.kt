package com.mouredev.weeklychallenge2022

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
const arrayNum = [10,2,7,8,21]
const main = (array) => {
  if(Array.isArray(array)){
  const arrayResult = []
  const minNumber = Math.min(...array)
  const maxNumber = Math.max(...array)
  for(var i = minNumber; i<maxNumber;i++){
      if(!array.includes(i)){
        arrayResult.push(i)
      }
    }
    return arrayResult
  }
  console.log('No es un array')
}

console.log(main(arrayNum))

