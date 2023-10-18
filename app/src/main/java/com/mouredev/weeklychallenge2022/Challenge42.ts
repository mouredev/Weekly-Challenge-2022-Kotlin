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

export default function tempConverter(input: string): string {
  if (typeof input !== "string") {
    throw new Error("Provided parameter must be type of string");
  }

  input = input.trim().replace("\u00BA", "\u00B0");

  if (!(input.match(/\b\u00B0C/) || input.match(/\b\u00B0F/))) {
    throw new Error("Provided parameter must match the correct format");
  }

  const [value, unit] = input.split("\u00B0");

  if (value.match(/[^0-9.]/)) {
    throw new Error("Provided value is not a valid number");
  }

  const inputValue = parseFloat(value);
  let convertedValue: number;

  if (unit === "C") {
    convertedValue = (inputValue * 9) / 5 + 32;
  } else {
    convertedValue = ((inputValue - 32) * 5) / 9;
  }

  return `${convertedValue.toString()}\u00B0${unit === "C" ? "F" : "C"}`;
}
