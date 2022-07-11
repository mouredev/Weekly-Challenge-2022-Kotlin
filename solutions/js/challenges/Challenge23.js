/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const { getRelatedElements } = require('./Challenge22');

const getMCD = (a, b) => {
  validateInput(a, b);
  const commonPrimes = getRelatedElements(getDivisors(a), getDivisors(b), true);
  return Math.max(...commonPrimes);
};

const getMcm = (a, b) => {
  validateInput(a, b);
  const [factorsA, factorsB] = [factorize(a), factorize(b)];
  const allUniqueFactors = [...new Set([...Object.keys(factorsA), ...Object.keys(factorsB)])].map(k => +k);
  return allUniqueFactors
    .reduce((acc, f) => acc * Math.pow(f, Math.max(factorsA[f] ?? 1, factorsB[f] ?? 1)), 1);
};

const getDivisors = (a, predicate = () => true) => {
  const primes = [];
  for (let i = 1; i <= a; i++) {
    if (a % i === 0 && predicate(a, i, primes)) primes.push(i);
  }
  return primes;
};

const factorize = (a) => {
  const isFactorPrime = (_, candidate, primes) => {
    return primes.every(
      (p) => p === 1 || (p % candidate !== 0 && candidate % p !== 0)
    );
  };

  const factors = getDivisors(a, isFactorPrime).filter((e) => e > 1);
  return factors
    .sort((x, y) => x - y)
    .reduce((acc, f) => {
      let i = 0;
      let auxA = a;
      while (auxA % f === 0 && auxA >= 0) {
        auxA /= f;
        i++;
      }
      return { ...acc, [f]: i };
    }, {});
};

const validateInput = (...input) => {
  if (!input.every(e => Number.isSafeInteger(e) && e >= 1)) throw new Error('Numbers must be a safe integer greater than 1');
  return true;
};

console.log(getMCD(27, 81));

module.exports = { getMCD, getMcm };