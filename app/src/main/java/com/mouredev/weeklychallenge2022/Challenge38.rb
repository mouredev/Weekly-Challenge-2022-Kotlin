# frozen_string_literal: true

#
#  Reto #38
#  BINARIO A DECIMAL
#  Fecha publicación enunciado: 19/09/22
#  Fecha publicación resolución: 27/09/22
#  Dificultad: MEDIA
#
#  Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
#  funciones propias del lenguaje que lo hagan directamente.
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#    para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#
#

# ejecución:
# ruby app/src/main/java/com/mouredev/weeklychallenge2022/Challenge38_test.rb

# requerimientos:
# ruby 2.7.3

# nota: para añadir nuevas pruebas, modificar el archivo
# app/src/main/java/mouredev/weeklychallenge2022/Challenge38_test.rb

def binary_to_decimal(binary)
  # binary.to_i(2)
  arr = binary.split('').map(&:to_i)
  arr_len = arr.length
  arr.each_with_index.reduce(0) { |resp, (num, i)| resp + num * (2**(arr_len - (i + 1))) }
end
