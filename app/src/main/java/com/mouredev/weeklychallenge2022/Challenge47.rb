# frozen_string_literal: true

#
# Reto #47
# VOCAL MÁS COMÚN
# Fecha publicación enunciado: 21/11/22
# Fecha publicación resolución: 28/11/22
# Dificultad: FÁCIL
#
# Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
# Si no hay vocales podrá devolver vacío.
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#

# class Vowel
class Vowel
  def most_repeated_vowels(input)
    max_vowel(count_vowels(input))
  end

  def count_vowels(input)
    vowels = /[aeiou]/
    vowels_numbers = {}
    # input.downcase.tr('áéíóúü', 'aeiouu').each_char do |elem|
    input.downcase.gsub(/[áéíóúü]/, 'á' => 'a', 'é' => 'e', 'í' => 'i', 'ó' => 'o', 'ú' => 'u',
                                    'ü' => 'u').each_char do |letter|
      next unless letter.match(vowels)

      vowels_numbers[letter] = 0 unless vowels_numbers.keys.include?(letter)
      vowels_numbers[letter] += 1
    end
    vowels_numbers
  end

  def max_vowel(counted_vowels)
    # max_value = 0
    # max_vowel = ''
    # counted_vowels.each do |key, value|
    #   if value > max_value
    #     max_value = value
    #     max_vowel = key
    #   end
    # end
    # max_vowel
    return '' if counted_vowels.empty?

    counted_vowels.max { |a, b| a[1] <=> b[1] }[0]
  end
end
