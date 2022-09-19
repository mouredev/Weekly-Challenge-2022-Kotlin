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
 */

void main() {
  daysBetweenGames("The Legend of Zelda", "Tears of the Kingdom");
  daysBetweenGames("Breath of the Wild", "Majora's Mask");
  daysBetweenGames("Breath of the Wild", "Ocarina of Space");
}

void daysBetweenGames(String firstGame, String secondGame) {
  final String? firstDateString = gameInfo[firstGame]?["releaseDate"];
  final String? secondDateString = gameInfo[secondGame]?["releaseDate"];

  if (firstDateString == null) {
    print('The first game is not a Zelda game');
    return;

  } else if (secondDateString == null) {
    print('The second game is not a Zelda game');
    return;
  }

  final DateTime firstDate = DateTime.parse(firstDateString);
  final DateTime secondDate = DateTime.parse(secondDateString);

  final daysBetween = firstDate.difference(secondDate).inDays.abs();

  print('There were $daysBetween days between the releases of those two games');
}

const Map gameInfo = {
  "The Legend of Zelda": {
    "releaseDate": "1986-02-21"
  },
  "Zelda II: The Adventure of Link": {
    "releaseDate": "1987-01-14"
  },
  "A Link to the Past": {
    "releaseDate": "1991-11-21"
  },
  "Link's Awakening": {
    "releaseDate": "1993-06-06"
  },
  "Ocarina of Time": {
    "releaseDate": "1998-11-21"
  },
  "Majora's Mask": {
    "releaseDate": "2000-04-27"
  },
  "Oracle of Seasons": {
    "releaseDate": "2001-02-27"
  },
  "Oracle of Ages": {
    "releaseDate": "2001-02-27"
  },
  "A Link to the Past & Four Swords": {
    "releaseDate": "2003-03-14"
  },
  "The Wind Waker": {
    "releaseDate": "2002-12-13"
  },
  "Four Swords Adventures": {
    "releaseDate": "2004-03-18"
  },
  "The Minish Cap": {
    "releaseDate": "2004-11-04"
  },
  "Twilight Princess": {
    "releaseDate": "2006-12-02"
  },
  "Phantom Hourglass": {
    "releaseDate": "2007-06-23"
  },
  "Spirit Tracks": {
    "releaseDate": "2009-12-23"
  },
  "Skyward Sword": {
    "releaseDate": "2011-11-23"
  },
  "A Link Between Worlds": {
    "releaseDate": "2013-12-26"
  },
  "Tri Force Heroes": {
    "releaseDate": "2015-10-22"
  },
  "Breath of the Wild": {
    "releaseDate": "2017-03-03"
  },
  "Tears of the Kingdom": {
    "releaseDate": "2023-05-12"
  }
};