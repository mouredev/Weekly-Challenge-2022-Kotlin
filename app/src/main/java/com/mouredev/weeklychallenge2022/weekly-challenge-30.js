/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
const rectangleSentence = (sentence) => {
  if (sentence === null || sentence === "" || sentence === " ") return "";

  const splittedSentence = sentence.split(" ");

  const maxSymbols = splittedSentence.reduce((a, b) =>
    a.length > b.length ? a : b
  ).length;

  const returnArray = [];
  const startEndSymbols = "*".repeat(maxSymbols + 4);

  returnArray.push(startEndSymbols);

  splittedSentence.forEach((word) => {
    const lineToPush = composeLine(maxSymbols, word);
    returnArray.push(lineToPush);
  });

  returnArray.push(startEndSymbols);

  return returnArray;
};

function composeLine(maxSymbols, word) {
  const startOfLine = "* ";
  const endOfLine = `${" ".repeat(maxSymbols - word.length)} *`;
  const lineToPush = `${startOfLine}${word}${endOfLine}`;
  return lineToPush;
}

export default rectangleSentence;
