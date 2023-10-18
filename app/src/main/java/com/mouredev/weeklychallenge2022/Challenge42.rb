# frozen_string_literal: true

#
#  Reto #42
#  CONVERSOR DE TEMPERATURA
#  Fecha publicación enunciado: 17/10/22
#  Fecha publicación resolución: 24/10/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que transforme grados Celsius en Fahrenheit
#  y viceversa.
#  - Para que un dato de entrada sea correcto debe poseer un símbolo "°"
#    y su unidad ("C" o "F").
#  - En caso contrario retornará un error.
#  - ¿Quieres emplear lo aprendido en este reto?
#    Revisa el reto mensual y crea una App:
#    https://retosdeprogramacion.com/mensuales2022
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#    "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#
#

def temperature_convert(temperature_input)
  temp_to_change = process_input(temperature_input.strip)

  return { msg: 'Not valid' } unless temp_to_change[:msg]

  case temp_to_change[:unit]
  when '°C'
    to_fahrenheit(temp_to_change[:digits])

  when '°F'
    to_celsius(temp_to_change[:digits])
  end
end

def process_input(temp_input)
  unit_index = get_unit_index(temp_input)
  return { msg: false } unless unit_index

  digits = temp_input.slice(0, unit_index)

  begin
    new_digits = Float(digits)
  rescue StandardError => _e
    { msg: false }
  else
    { msg: true, digits: new_digits, unit: temp_input.slice(unit_index, 2) }
  end
end

def get_unit_index(temp_input)
  temp_input.index(/(°C|°F)$/) || false
end

def to_fahrenheit(digits)
  {
    temp: ((digits.to_f * 9) / 5 + 32).round(2),
    units: '°F'
  }
end

def to_celsius(digits)
  {
    temp: (((digits.to_f - 32) * 5) / 9).round(2),
    units: '°C'
  }
end
