# frozen_string_literal: true

#
#  Reto #37
#  LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
#  Fecha publicación enunciado: 14/09/22
#  Fecha publicación resolución: 19/09/22
#  Dificultad: MEDIA
#
#  Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
#  y se lanzará el 12 de mayo de 2023.
#  Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
#  Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
#  - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
#    puedes usar el mes, o incluso inventártelo)
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#    para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#
#

require 'date'
# Class to execute the method
class Main
  def initialize(op1, op2)
    @game1 = op1
    @game2 = op2
  end

  def execute
    Game.new.calc_date(@game1, @game2)
  end
end

# class to contain the method and constants
class Game
  RELEASE_DATES = { '0': { name: 'The Legend of Zelda', release_date: '1987-8-22' },
                    '1': { name: 'Zelda II: The Adventure of Link', release_date: '1988-9-26' },
                    '2': { name: 'The Legend of Zelda: A Link to the Past', release_date: '1992-3-13' },
                    '3': { name: 'The Legend of Zelda: Link\'s Awakening', release_date: '1993-8-23' },
                    '4': { name: 'The Legend of Zelda: Ocarina of Time', release_date: '1998-11-23' },
                    '5': { name: 'The Legend of Zelda: Majora\'s Mask', release_date: '2000-3-27' },
                    '6': { name: 'The Legend of Zelda: Oracle of Seasons', release_date: '2001-5-13' },
                    '7': { name: 'The Legend of Zelda: Oracle of Ages', release_date: '2001-5-13' },
                    '8': { name: 'The Legend of Zelda: A Link to the Pasr & Four Swords', release_date: '2002-12-3' },
                    '9': { name: 'The Legend of Zelda: The Wind Waker', release_date: '2003-3-24' },
                    '10': { name: 'The Legend of Zelda: Four Swords Adventures', release_date: '2004-6-7' },
                    '11': { name: 'The Legend of Zelda: The Minish Cap', release_date: '2005-1-10' },
                    '12': { name: 'The Legend of Zelda: Twilight Princess', release_date: '2006-11-19' },
                    '13': { name: 'The Legend of Zelda: Phantom Hourglass', release_date: '2007-10-1' },
                    '14': { name: 'The Legend of Zelda: Spirit Tracks', release_date: '2009-12-7' },
                    '15': { name: 'The Legend of Zelda: Skyward Sword', release_date: '2011-11-22' },
                    '16': { name: 'The Legend of Zelda: A Link Between Worlds', release_date: '2013-11-22' },
                    '17': { name: 'The Legend of Zelda: Tri Force Heroes', release_date: '2015-10-23' },
                    '18': { name: 'The Legend of Zelda: Breath of the Wild', release_date: '2017-3-3' },
                    '19': { name: 'The Legend of Zelda: Tears of the Kingdom', release_date: '2023-5-12' } }.freeze

  def calc_date(game1, game2)
    diff_days = (string_to_year(game1) - string_to_year(game2)).abs
    years = diff_days.to_i / 365
    days = diff_days.to_i % 365
    { years: years, days: days }
  end

  private

  def string_to_year(game_data)
    Date.parse(RELEASE_DATES[game_data.to_sym][:release_date])
  end
end
