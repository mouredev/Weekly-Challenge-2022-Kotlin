# frozen_string_literal: true

#
# Reto #34
# LOS NÚMEROS PERDIDOS
# Fecha publicación enunciado: 22/08/22
# Fecha publicación resolución: 29/08/22
# Dificultad: FÁCIL
#
# Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
# y retorne todos los que faltan entre el mayor y el menor.
# - Lanza un error si el array de entrada no es correcto.
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#

# Solución:
# Requerimientos:
# Ruby 2.7.3
#
# Ejecución:
# rubu Challenge34_test.rb

# class that receives and checks input
class Main
  def initialize(arr)
    @arr = arr
  end

  def execute
    if check_input
      lost_numbers = LostNumbers.new(@arr)
      lost_numbers.lost_numbers
    else
      'Not correct input'
    end
  end

  private

  def check_input
    if @arr.instance_of?(Array)
      true if !@arr.empty? && integers? && ordered?
    else
      false
    end
  end

  def ordered?
    @arr.sort.uniq == @arr
  end

  def integers?
    @arr.all? { |i| i.is_a? Integer }
  end
end

# class that receives and returns the lost numbers from the input array
class LostNumbers
  def initialize(arr)
    @arr = arr
  end

  def lost_numbers
    next_num = @arr.first + 1
    index = 1
    resp = []
    while next_num < @arr.last
      @arr[index] != next_num ? resp << next_num : index += 1
      next_num += 1
    end
    resp
  end
end
