# frozen_string_literal: true

require 'set'
#
#  Reto #7
#  CONTANDO PALABRAS
#  Fecha publicación enunciado: 14/02/22
#  Fecha publicación resolución: 21/02/22
#  Dificultad: MEDIA
#
#  Enunciado: Crea un programa que cuente cuantas veces se repite cada
#  palabra y que muestre el recuento final de todas ellas.
#  - Los signos de puntuación no forman parte de la palabra.
#  - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
#  - No se pueden utilizar funciones propias del lenguaje que lo resuelvan
#    automáticamente.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord)
#    "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para
#    que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de
#    su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su
#    publicación.
#

# Solución:
# Requerimientos:
# Ruby 2.7.3
#
# Ejecución:
# ruby Challenge7_test.rb

# class to call method
class Main
  def initialize(string)
    @string = string
  end

  def execute
    count_string = StringTool.new(@string)
    count_string.counting_repetitions
  end
end

# class that contains the method
class StringTool
  def initialize(string)
    @string = string
  end

  def counting_repetitions
    new_string = downcase_string(@string)
    clean_string = only_words(new_string)
    # clean_string.split(' ').group_by(&:itself).map { |k, v| [k, v.count] }.to_h
    # clean_string.split(' ').group_by(&:itself).transform_values(&:count)

    # using string procedures
    collection = Set.new(clean_string.split(' ')).to_a
    result = {}
    collection.each do |element|
      result[element] = clean_string.scan(element).size
    end
    result
  end

  private

  def downcase_string(string)
    if string.chars.any?(/[ÁÉÍÓÚ]/)
      string.downcase
    else
      # procedure can't downcase characters ÁÉÍÓÚ
      string.chars.map { |c| c.match?(/[A-Z]/) ? (c.ord + 32).chr : c }.join('')
    end
  end

  def only_words(string)
    string.gsub(/[^a-z0-9áéíóúÁÉÍÓÚ\s]/, '')
  end
end
