# frozen_string_literal: true

#  Reto #43
#  TRUCO O TRATO
#  Fecha publicación enunciado: 24/10/22
#  Fecha publicación resolución: 02/11/22
#  Dificultad: FÁCIL
#
#  Enunciado: Este es un reto especial por Halloween.
#  Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
#  un listado (array) de personas con las siguientes propiedades:
#  - Nombre de la niña o niño
#  - Edad
#  - Altura en centímetros
#
#  Si las personas han pedido truco, el programa retornará sustos (aleatorios)
#  siguiendo estos criterios:
#  - Un susto por cada 2 letras del nombre por persona
#  - Dos sustos por cada edad que sea un número par
#  - Tres sustos por cada 100 cm de altura entre todas las personas
#  - Sustos: 🎃 👻 💀 🕷 🕸 🦇
#
#  Si las personas han pedido trato, el programa retornará dulces (aleatorios)
#  siguiendo estos criterios:
#  - Un dulce por cada letra de nombre
#  - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
#  - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
#  - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#    para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#

# main class for Trick or Treat
class TrickOrTreat
  PRIZES = { treat: ['🍰', '🍬', '🍡', '🍭', '🍪', '🍫', '🧁', '🍩'],
             trick: ['🎃', '👻', '💀', '🕷', '🕸', '🦇'] }.freeze

  def trick_or_treat(input)
    case input[:option]
    when 'treat'
      input[:children].map { |child| prizes(calc_treats(child), PRIZES[:treat]) }
    when 'trick'
      input[:children].map { |child| prizes(calc_tricks(child), PRIZES[:trick]) }
    end
  end

  def calc_tricks(person_data)
    tricks_by_name(person_data[:name].size) +
      tricks_by_age(person_data[:age]) +
      tricks_by_height(person_data[:height])
  end

  def tricks_by_name(name_size)
    name_size / 2
  end

  def tricks_by_age(age)
    age.even? ? 2 : 0
  end

  def tricks_by_height(height)
    (height / 100) * 3
  end

  def calc_treats(person_data)
    treats_by_name(person_data[:name].size) +
      treats_by_age(person_data[:age]) +
      treats_by_height(person_data[:height])
  end

  def treats_by_name(name_size)
    name_size
  end

  def treats_by_age(age)
    return 3 if age >= 10
    return age / 3 if age < 10
  end

  def treats_by_height(height)
    return 6 if height > 150
    return (height / 50) * 2 if height <= 150
  end

  def prizes(prizes_amount, prizes_source)
    prize = ''
    prizes_amount.times { prize += prizes_source[rand(prizes_source.size - 1)] }
    prize
  end
end
