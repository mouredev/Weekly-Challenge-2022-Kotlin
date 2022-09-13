# frozen_string_literal: true

# Reto #30
# MARCO DE PALABRAS
# Fecha publicación enunciado: 26/07/22
# Fecha publicación resolución: 01/08/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
# un marco rectangular de asteriscos.
# - ¿Qué te parece el reto? Se vería así:
#   **********
#   * ¿Qué   *
#   * te     *
#   * parece *
#   * el     *
#   * reto?  *
#   **********
#
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord)
#   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para
#   que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de
#   su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de
# su publicación.
#
# Solución:
# Requerimientos
# Ruby 2.7.3
#
# Ejecución:
# usar el archivo Challenge30_test.rb que contiene algunas pruebas necesarias.
# ruby Challenge30_test.rb

class Main
  def initialize(text)
    @text = text.strip
  end

  def execute
    framing = -> { @frame = FrameText.new(@text).frame }
    framing.call unless @text.empty?
    puts 'cadena vacia' if @text.empty?
  end
end

class FrameText
  def initialize(word)
    @words_list = word.split(' ')
  end

  def frame
    frame_width = longest_string_size
    top_bottom_frame = '*' * (frame_width + 4)
    puts top_bottom_frame
    @words_list.each do |string|
      spacing = frame_width - string.size
      puts "* #{string}#{' ' * spacing} *"
    end
    puts top_bottom_frame
  end

  private

  def longest_string_size
    @words_list.max { |a, b| a.size <=> b.size }.size
  end
end
