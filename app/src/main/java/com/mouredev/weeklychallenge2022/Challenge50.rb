# frozen_string_literal: true

#
# Reto #50
# LA ENCRIPTACIÓN DE KARACA
# Fecha publicación enunciado: 12/11/22
# Fecha publicación resolución: 19/12/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
# algoritmo de encriptación de Karaca (debes buscar información sobre él).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#
class Karaca
  # VOWELS = { 'a' => '0', 'e' => '1', 'i' => '2', 'o' => '3', 'u' => '4' }.freeze
  def initialize(input)
    @input = input[:input].split(' ')
    @function = input[:func]
  end

  def start
    public_send(@function)
  end

  def encryption
    @input.map { |word| word.downcase.reverse.tr('aeiouáéíóúü', '01234012344').concat('aca') }.join(' ')
  end

  def decryption
    @input.map do |word|
      return 'not encrypted input' unless word.match?(/(aca)$/)

      word.chomp('aca').reverse.tr('01234', 'aeiou')
    end.join(' ')
  end
end
