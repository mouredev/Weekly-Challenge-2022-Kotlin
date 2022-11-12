# frozen_string_literal: true

require 'pry'
#
# Reto #45
# CONTENEDOR DE AGUA
# Fecha publicación enunciado: 07/10/22
# Fecha publicación resolución: 14/11/22
# Dificultad: MEDIA
#
# Enunciado: Dado un array de números enteros positivos, donde cada uno
# representa unidades de bloques apilados, debemos calcular cuantas
# unidades de agua quedarán atrapadas entre ellos.
#
# - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
#
#        ⏹
#        ⏹
#   ⏹💧💧⏹
#   ⏹💧⏹⏹💧⏹
#   ⏹💧⏹⏹💧⏹
#   ⏹💧⏹⏹⏹⏹
#
#   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
#   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
#
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#

# class WaterContainer
class WaterContainer
  def calculate_saved_water(input)
    saved_water = 0
    (1...input.size - 1).each do |column|
      left_wall = find_left_wall(input, column)
      right_wall = find_right_wall(input, column)
      if input[column] < left_wall && input[column] < right_wall
        saved_water += (left_wall < right_wall ? left_wall - input[column] : right_wall - input[column])
      end
    end
    saved_water
  end

  def find_left_wall(block_list, right_limit)
    left_wall = 0
    (0...right_limit).each do |position|
      left_wall = block_list[position] if block_list[position] > left_wall
    end
    left_wall
  end

  def find_right_wall(block_list, left_limit)
    right_wall = 0
    (left_limit + 1...block_list.size).reverse_each do |position|
      right_wall = block_list[position] if block_list[position] > right_wall
    end
    right_wall
  end
end
