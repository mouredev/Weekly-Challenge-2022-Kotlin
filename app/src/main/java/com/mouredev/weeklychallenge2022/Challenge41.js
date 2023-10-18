/*
 * Enunciado: Crea una función que calcule el valor del parámetro perdido
 * correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
 *   el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará
 *   la cadena de texto "Invalid values".
 */

const ohm = (V = undefined, R = undefined, I = undefined) => {
  if (V !== undefined && R !== undefined && I !== undefined)
    return "Invalid values";
  if (
    (V === undefined && R === undefined) ||
    (V === undefined && I === undefined) ||
    (I === undefined && R === undefined)
  )
    return "Invalid values";
  if ((typeof (V, R, I) !== "number" && typeof (V, R, I) !== "undefined")) {
    return "Invalid values";
  }

  let result = 0;

  if (V === undefined) {
    result = R * I;
  } else if (R === undefined) {
    result = V / I;
  } else {
    result = V / R;
  }

  return result.toFixed(2);
};

console.log(ohm(10, "12", undefined));
console.log(ohm(10, undefined, undefined));
console.log(ohm(10, 12, undefined));
