# frozen_string_literal: true

# Reto #31
# AÑOS BISIESTOS
# Fecha publicación enunciado: 01/08/22
# Fecha publicación resolución: 08/08/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que imprima los 30 próximos años bisiestos
# siguientes a uno dado.
# - Utiliza el menor número de líneas para resolver el ejercicio.
#
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord)
#   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para
#   que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de
#   su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de
#   su publicación.
#

# Solución
# Requerimientos:
# Ruby 2.7.3
#
# Ejecución:
# ruby Challenge31_test.rb
# en el archivo Challenge31_test.rb se han definido algunos años para devolver
# los resultados requeridos.

# Class to call the Year class and execute the required method
# require 'date'
class Main
  def initialize(year)
    @year = year
  end

  def execute
    leap_year = Year.new(@year)
    leap_year.return_30_leap_years
  end
end

# Class to verify leap year and return the next 30 leap years after
class Year
  def initialize(year)
    @year = year
  end

  def return_30_leap_years
    result = []

    # se puede usar `if Date.gregorian_leap(@year)` eliminando la necesidad
    # de crear un función
    if leap_year? @year
      result << next_leap_year(@year)
      29.times { result << next_leap_year(result.last) }
    end
    result
  end

  def leap_year?(year)
    (year % 4).zero? && !(year % 100).zero? || (year % 400).zero?
  end

  private

  def next_leap_year(year)
    year + 4
  end
end
