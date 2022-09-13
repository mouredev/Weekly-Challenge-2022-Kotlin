# frozen_string_literal: true

#
#  Reto #36
#  LOS ANILLOS DE PODER
#  Fecha publicación enunciado: 06/09/22
#  Fecha publicación resolución: 14/09/22
#  Dificultad: MEDIA
#
#  Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
#  contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
#  Cada raza tiene asociado un "valor" entre 1 y 5:
#  - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
#  - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
#  Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
#  - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
#    suma del valor del ejército y el número de integrantes.
#  - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
#  - Tienes total libertad para modelar los datos del ejercicio.
#  Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#    para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#

# Clase para ejecución
class Main
  def initialize(input)
    @free_people = input[0]
    @enslaved = input[1]
  end

  def execute
    middle_earth_battle = MiddleEarthWar.new(@free_people, @enslaved)
    middle_earth_battle.battle_result
  end
end

# clase batalla de tierra media
class MiddleEarthWar
  def initialize(free_people, enslaved)
    @free_army = free_people
    @slave_army = enslaved
  end

  def army_battle
    army_power = ->(arr) { arr.map.with_index { |elem, index| elem * (index + 1) }.sum }
    # free_people = army_power @free_army
    # slaves = army_power @slave_army
    army_power.call(@free_army) - army_power.call(@slave_army)
  end

  def battle_result
    if army_battle.positive?
      'Free People Army wins'
    elsif army_battle.negative?
      'Slave Army wins'
    elsif army_battle.zero?
      "It's a tie"
    end
  end

  # private

  # def army_power(arr)
  #   sum = 0
  #   arr.each_with_index do |elem, index|
  #     sum += elem * (index + 1)
  #   end
  #   sum
  # end
end
