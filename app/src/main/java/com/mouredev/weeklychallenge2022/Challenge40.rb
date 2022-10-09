# frozen_string_literal: true

#
#  Reto #40
#  TRIÁNGULO DE PASCAL
#  Fecha publicación enunciado: 03/10/22
#  Fecha publicación resolución: 10/10/22
#  Dificultad: MEDIA
#
#  Enunciado: Crea una función que sea capaz de dibujar
#  el "Triángulo de Pascal" indicándole únicamente el tamaño del lado.
#  - Aquí puedes ver rápidamente cómo se calcula el triángulo:
#    https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#    "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#
#

# class to execute Pascal Triangle
class Main
  def initialize(height)
    @height = height
  end

  def execute
    PascalTriangle.new.draw(@height) if @height.positive?

    puts 'no valid height' unless @height.positive?
  end
end

# class to draw the method
class PascalTriangle
  def draw(height)
    triangle_container(height).each do |rows|
      puts rows.join(' ').gsub(/0/, '').strip
    end
  end

  def triangle_container(height)
    # create triangle container
    # triangle = []
    # height.times { triangle << Array.new(height) }
    # @triangle = Array.new(@height) { Array.new(@height, 0) }

    # triangle.map.with_index do |rows, r_index|
    #   rows.map.with_index do |_cell, c_index|
    #     cell_value(r_index, c_index)
    #   end
    # end
    Array.new(height) { |row| Array.new(height) { |column| cell_value(row, column) } }
  end

  private

  def cell_value(row, column)
    return 1 if column.zero? || row == column
    return 0 if (row - column).negative?

    cell_value(row - 1, column - 1) + cell_value(row - 1, column)
  end
end
