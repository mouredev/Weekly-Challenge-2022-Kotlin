/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function advent(input) {
  const response = {};
  if (
    input.getTime() > startAdvent.getTime() &&
    input.getTime() < endAdvent.getTime()
  )
    response.gift = gift();
  response.timeLeft = calculateTime(input);
  return response;
};

const startAdvent = new Date("2022-12-01T00:00:00+01:00");
const endAdvent = new Date("2022-12-24T23:59:59+01:00");
const gifts = ["ebooks", "ecourses", "games"];

const gift = () => {
  const pos = Math.floor(Math.random() * gifts.length);
  return gifts[pos];
};

const calculateTime = (input) => {
  const difference = calcDiff(input);

  let seconds = difference % 60;
  let minutes = difference / 60;
  let hours = minutes / 60;
  minutes = minutes % 60;
  let days = hours / 24;
  hours = hours % 24;
  let months = days / 30.437;
  days = days % 30.437;
  let years = months / 12;
  months = months % 12;

  return {
    years: Math.floor(years),
    months: Math.floor(months),
    days: Math.floor(days),
    hours: Math.floor(hours),
    minutes: Math.floor(minutes),
    seconds: Math.floor(seconds),
  };
};

const calcDiff = (time) => {
  if (time.getTime() < startAdvent.getTime())
    return Math.floor((startAdvent.getTime() - time.getTime()) / 1000);
  if (time.getTime() > endAdvent.getTime())
    return Math.floor((time.getTime() - endAdvent.getTime()) / 1000);
  let endDate = new Date(
    `${time.getUTCFullYear()}-${time.getUTCMonth() + 1}-${time.getUTCDate()}`
  );
  endDate.setUTCHours(23, 59, 59);
  return Math.floor((endDate.getTime() - time.getTime()) / 1000);
};
