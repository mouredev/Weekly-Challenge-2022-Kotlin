# frozen_string_literal: true

#
# Reto #33
# CICLO SEXAGENARIO CHINO
# Fecha publicación enunciado: 15/08/22
# Fecha publicación resolución: 22/08/22
# Dificultad: MEDIA
#
# Enunciado: Crea un función, que dado un año, indique el elemento y animal
# correspondiente en el ciclo sexagenario del zodíaco chino.
# - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
# - El ciclo sexagenario se corresponde con la combinación de los
#   elementos madera, fuego, tierra, metal, agua y los animales rata, buey,
#   tigre, conejo, dragón, serpiente, caballo, oveja, mono, gallo, perro,
#   cerdo (en este orden).
# - Cada elemento se repite dos años seguidos.
# - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales
#   en https://retosdeprogramacion.com/semanales2022.
#
#

# Solución:
# Requerimientos:
# Ruby 2.7.1

# Ejecución:
# ruby Challenge33_test.rb

# class that receives and checks input
class Main
  def initialize(input_year)
    @year = input_year
  end

  def execute
    if positive_number?
      year = Year.new(@year)
      year.chinese_element_animal
    else
      { msg: 'not valid year' }
    end
  end

  private

  def positive_number?
    (@year.is_a? Numeric) && @year.positive? ? true : false
  end
end

# class that receives and returns the animal and element of an specific year
class Year
  CYCLE_YEAR = 60
  START_CYCLE = 1924
  ANIMALS = %w[rat ox tiger rabbit dragon snake horse sheep monkey rooster dog pig].freeze
  ELEMENTS = %w[wood wood fire fire earth earth metal metal water water].freeze

  def initialize(input_year)
    @year = input_year
  end

  def chinese_element_animal
    years = ((START_CYCLE - @year).abs % CYCLE_YEAR)
    years = (years - CYCLE_YEAR).abs if @year < START_CYCLE
    { animal: return_animals(years), element: return_element(years) }
  end

  private

  def return_element(years)
    ELEMENTS[years % ELEMENTS.size]
  end

  def return_animals(years)
    ANIMALS[years % ANIMALS.size]
  end
end
