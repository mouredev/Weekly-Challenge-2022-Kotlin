/*
 * Enunciado: Dado un array de enteros ordenado y sin repetidos,
 * crea una función que calcule y retorne todos los que faltan entre
 * el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 */

const nbetween = (array = undefined) => {
  if (array === undefined)
    return console.error("No has introducido ningun valor");
  if (!(array instanceof Array))
    return console.error("El tipo de dato introducido no es un array");
  if (array.length === 0) return console.warn("El array esta vacio");
  for (let num of array) {
    if (typeof num !== "number")
      return console.error(`El valor ${num} no es un numero`);
  }
  for (let i = 0; i < array.length; i++) {
    if (array[i] > array[i + 1])
      return console.error(
        "Los numeros introducidos en el array no estan ordenados"
      );
  }
  const set = new Set(array),
    a = Array.from(set);
  for (let i = 0; i < array.length; i++) {
    if (array[i] != a[i])
      return console.error("No puede haber numeros repetidos en el array");
  }

  let numbersToReturn = [],
    contadorNumero = 1;

  array.forEach((element) => {
    while (array[element] + contadorNumero < array[element + 1]) {
      numbersToReturn.push(array[element] + contadorNumero);
      contadorNumero++;
    }
    contadorNumero = 1;
  });
  return console.log(numbersToReturn);
};

nbetween([1, 2, 7, 13]);
