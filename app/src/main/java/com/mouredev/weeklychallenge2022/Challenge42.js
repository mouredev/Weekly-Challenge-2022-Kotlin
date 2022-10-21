/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function temperatureConvert(tempInput) {
  const tempToChange = processInput(tempInput);
  if (!tempToChange.msg) return { msg: "Not valid" };

  switch (tempToChange.unit) {
    case "°C":
      return toFarenheit(tempToChange.digits);

    case "°F":
      return toCelsius(tempToChange.digits);
  }
};

const processInput = (temperature) => {
  let unitIndex = getUnitIndex(temperature);
  if (unitIndex == -1) return { msg: false };

  let digits = temperature.slice(0, unitIndex);
  if (isNaN(digits)) return { msg: false };

  return {
    msg: true,
    unit: temperature.trim().slice(unitIndex),
    digits: parseFloat(digits),
  };
};

const getUnitIndex = (temp) => temp.search(/(°C|°F)$/g);

const toCelsius = (digits) => ({
  temp: (((parseFloat(digits) - 32) * 5) / 9).toFixed(2),
  units: "°C",
});

const toFarenheit = (digits) => ({
  temp: ((parseFloat(digits) * 9) / 5 + 32).toFixed(2),
  units: "°F",
});
