# frozen_string_literal: true

#
#  Reto #41
#  LA LEY DE OHM
#  Fecha publicación enunciado: 10/10/22
#  Fecha publicación resolución: 17/10/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que calcule el valor del parámetro
#  perdido correspondiente a la ley de Ohm.
#  - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y
#    retornará el valor del tercero (redondeado a 2 decimales).
#  - Si los parámetros son incorrectos o insuficientes, la función
#    retornará la cadena de texto "Invalid values".
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#    para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#
#

# Requirements:
# Ruby 2.7.6
#
# Execution:
# ruby Challenge41_test.rb

# class to execute
class Main
  def initialize(arr)
    @arr = arr
  end

  def execute
    Electricity.new.ohm(@arr)
  end
end

# class to contain function
class Electricity
  def ohm(input)
    return 'Invalid values' if invalid_arr(input)

    new_input = input.map(&:to_f)

    case return_empty_index(input)
    when 0
      { var: 'voltage', val: voltage(new_input[1], new_input[2]) }
    when 1
      { var: 'current', val: current(new_input[0], new_input[2]) }
    when 2
      { var: 'resistance', val: resistance(new_input[0], new_input[1]) }
    end
  end

  private

  def invalid_arr(arr)
    return true if arr.any? { |elem| elem.match(/[a-zA-Z]/) }

    return true if arr.count(&:empty?) != 1

    false
  end

  def return_empty_index(arr)
    arr.index('')
  end

  def voltage(current, resistance)
    (current * resistance).round(2)
  end

  def current(voltage, resistance)
    (voltage / resistance).round(2)
  end

  def resistance(voltage, current)
    (voltage / current).round(2)
  end
end
