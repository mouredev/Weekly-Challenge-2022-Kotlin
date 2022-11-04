# frozen_string_literal: true

#
# Reto #44
# BUMERANES
# Fecha publicación enunciado: 02/10/22
# Fecha publicación resolución: 07/11/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que retorne el número total de bumeranes de
# un array de números enteros e imprima cada uno de ellos.
# - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
#   seguidos, en el que el primero y el último son iguales, y el segundo es
#   diferente. Por ejemplo [2, 1, 2].
# - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#

# class boomerang
class Boomerang
  def find_boomerang(input)
    # boomerangs = input.each_cons(3).filter { |a, b, c| a == c && a != b }
    boomerangs = []
    (input.size - 2).times do |idx|
      boomerangs << input[idx, 3] if (input[idx] == input[idx + 2]) && (input[idx] != input[idx + 1])
    end
    { nro: boomerangs.size, boomerangs: boomerangs }
  end
end
