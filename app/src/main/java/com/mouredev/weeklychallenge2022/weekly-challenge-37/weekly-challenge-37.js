/*
 * Reto #37
 * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
 * Fecha publicación enunciado: 14/09/22
 * Fecha publicación resolución: 19/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
 * y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
 *   puedes usar el mes, o incluso inventártelo)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

const getDiffBetweenTwoGames = (gameOlder, gameNewer) => {
  let [helpDate, dateOfOlderGame, dateOfNewerGame] = [
    new Date(),
    new Date(gameOlder.released_date),
    new Date(gameNewer.released_date),
  ];

  dateOfNewerGame < dateOfOlderGame && [
    (helpDate = dateOfNewerGame),
    (dateOfNewerGame = dateOfOlderGame),
    (dateOfOlderGame = helpDate),
  ];

  const diffTime = Math.abs(dateOfNewerGame - dateOfOlderGame);
  const diffDays = diffTime / (1000 * 60 * 60 * 24);

  let diffYears = Math.round(diffDays / 365);
  let diffDaysWithoutYears = diffDays - diffYears * 365;

  [diffYears, diffDaysWithoutYears] = getYearsAndDaysIfRestDaysAreNegative(
    diffYears,
    diffDaysWithoutYears
  );

  diffDaysWithoutYears += getLeapYearCount(
    helpDate,
    dateOfOlderGame,
    dateOfNewerGame
  );
  helpDate = new Date();
  return { years: diffYears, days: diffDaysWithoutYears };
};

export default getDiffBetweenTwoGames;

const getYearsAndDaysIfRestDaysAreNegative = (
  diffYears,
  diffDaysWithoutYears
) =>
  diffDaysWithoutYears < 0
    ? [(diffYears -= 1), (diffDaysWithoutYears *= -1)]
    : [diffYears, diffDaysWithoutYears];

const getLeapYearCount = (helpDate, dateOfOlderGame, dateOfNewerGame) => {
  let leapYearCount = 0;
  helpDate = dateOfOlderGame;

  while (helpDate.getFullYear() != dateOfNewerGame.getFullYear()) {
    const year = helpDate.getFullYear();
    if ((0 == year % 4 && 0 != year % 100) || 0 == year % 400)
      leapYearCount += 1;
    helpDate.setFullYear(helpDate.getFullYear() + 1);
  }
  return leapYearCount;
};
