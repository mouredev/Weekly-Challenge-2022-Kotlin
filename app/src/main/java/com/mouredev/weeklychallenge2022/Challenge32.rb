# frozen_string_literal: true

#
# Reto #32
# EL SEGUNDO
# Fecha publicación enunciado: 08/08/22
# Fecha publicación resolución: 15/08/22
# Dificultad: FÁCIL
#
#  Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
#
#  Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales
#   en https://retosdeprogramacion.com/semanales2022.
#

# Solución:
# Requerimiento:
# Ruby 2.7.3
#
# Ejecución:
# ruby Challenge32_test.rb

require 'set'

# Main class,
class Main
  def initialize(list)
    @list = list
  end

  def execute
    number_list = ExampleList.new(@list)
    number_list.second_biggest
  end
end

# List contains methods for list.
class ExampleList
  def initialize(list)
    @list = list
  end

  # Class methods are used to order and pick only unique.
  # the procedure is clean the list from repeated elements, order the elements
  # and pick the last but one.

  def second_biggest
    # @list.uniq.sort[-2]

    # new procedure uses Array.sort ordered in descending order
    return 'Lista inválida' if @list.size < 2

    # new_list = @list.sort { |a, b| b - a }
    new_list = sort(@list)
    (1...(new_list.size - 1)).each do |i|
      return new_list[i] if new_list[new_list.size - 1] != new_list[i]
    end
  end

  private

  def sort(arr)
    (0...arr.size - 1).each do |i|
      (i..arr.size - 1).each do |j|
        next unless arr[i] < arr[j]

        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
      end
    end
    arr
  end
end
