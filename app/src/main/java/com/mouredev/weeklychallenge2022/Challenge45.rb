# frozen_string_literal: true

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
    column = 1
    while column < input.size - 1
      left_wall = find_left_wall_position(input, column)
      right_wall = find_right_wall_position(input, column)

      if input[column] >= input[left_wall] || input[column] >= input[right_wall]
        column += 1
        next
      end

      saved_water += water_stored(input, left_wall, right_wall)
      column = right_wall
    end
    saved_water
  end

  private

  def find_left_wall_position(block_list, right_limit)
    left_wall = { val: 0, position: 0 }
    (0...right_limit).each do |position|
      if block_list[position] > left_wall[:val]
        left_wall[:val] = block_list[position]
        left_wall[:position] = position
      end
    end
    left_wall[:position]
  end

  def find_right_wall_position(block_list, left_limit)
    right_wall = { val: 0, position: 0 }
    (left_limit + 1...block_list.size).reverse_each do |position|
      if block_list[position] > right_wall[:val]
        right_wall[:val] = block_list[position]
        right_wall[:position] = position
      end
    end
    right_wall[:position]
  end

  def water_stored(block_list, left_wall, right_wall)
    used_space = 0
    height = block_list[left_wall] < block_list[right_wall] ? block_list[left_wall] : block_list[right_wall]
    length = right_wall - (left_wall + 1)

    (left_wall...right_wall).drop(1).each do |position|
      used_space += block_list[position]
    end

    (height * length) - used_space
  end

  # Code copied from Java Solution: https://github.com/mouredev/Weekly-Challenge-2022-Kotlin/pull/1036/files
  # def calculate_saved_water(input)
  #   saved_water = 0
  #   (1...input.size - 1).each do |column|
  #     left_wall = find_left_wall(input, column)
  #     right_wall = find_right_wall(input, column)
  #     if input[column] < left_wall && input[column] < right_wall
  #       saved_water += (left_wall < right_wall ? left_wall - input[column] : right_wall - input[column])
  #     end
  #   end
  #   saved_water
  # end

  # def find_left_wall(block_list, right_limit)
  #   left_wall = 0
  #   (0...right_limit).each do |position|
  #     left_wall = block_list[position] if block_list[position] > left_wall
  #   end
  #   left_wall
  # end

  # def find_right_wall(block_list, left_limit)
  #   right_wall = 0
  #   (left_limit + 1...block_list.size).reverse_each do |position|
  #     right_wall = block_list[position] if block_list[position] > right_wall
  #   end
  #   right_wall
  # end
end
