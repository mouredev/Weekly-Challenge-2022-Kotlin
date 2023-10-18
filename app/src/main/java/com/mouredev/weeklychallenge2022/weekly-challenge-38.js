/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

//Using multiplication method
const convertDecimalToBinary = (number, decimalNumbers = 20) => {
  const integerPortion = getIntegerPortionFromANumber(number);
  const decimalPortion = getDecimalPortionFromANumber(number);
  let integerRemainder = getBinaryArrayFromIntegerNumber(integerPortion);
  let decimalRemainder = getBinaryArrayFromDecimalNumber(
    decimalPortion,
    decimalNumbers
  );
  const resultAsString = `${integerRemainder}.${decimalRemainder.join("")}`;
  return resultAsString;
};

export default convertDecimalToBinary;
const getBinaryArrayFromIntegerNumber = (number) => {
  let n = Number(number);
  n == 0 && "0";
  let r = "";
  while (n != 0) {
    r = (n & 1 ? "1" : "0") + r;
    n = n >>> 1;
  }
  return r;
};
const getBinaryArrayFromDecimalNumber = (number, decimalNumbers) => {
  let remainder = [];
  let tempIntegerPortion = 0;
  let tempDecimalPortion = number;

  while (remainder.length < decimalNumbers) {
    const mutiplicationResult = (tempDecimalPortion * 2).toFixed(100);
    tempIntegerPortion = getIntegerPortionFromANumber(mutiplicationResult);
    tempDecimalPortion = getDecimalPortionFromANumber(mutiplicationResult);
    remainder.push(tempIntegerPortion);
    if (tempDecimalPortion === 0) break;
  }
  return remainder;
};
const getIntegerPortionFromANumber = (number) =>
  parseInt(number.toString().split(".")[0]);
const getDecimalPortionFromANumber = (number) => (number % 1).toFixed(100);
