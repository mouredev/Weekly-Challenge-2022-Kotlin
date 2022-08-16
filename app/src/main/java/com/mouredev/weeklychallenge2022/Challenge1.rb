#
# Reto #1
# ¿ES UN ANAGRAMA?
# Fecha publicación enunciado: 03/01/22
# Fecha publicación resolución: 10/01/22
# Dificultad: MEDIA
#
# Enunciado: Escribe una función que reciba dos palabras (String) y retorne 
# verdadero o falso (Boolean) según sean o no anagramas.
# Un Anagrama consiste en formar una palabra reordenando TODAS las letras 
# de otra palabra inicial.
# NO hace falta comprobar que ambas palabras existan.
# Dos palabras exactamente iguales no son anagrama.
#
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord) 
#  "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para 
#   que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al 
#   de su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de 
#   su publicación.
#

class Main
  def initialize options={}
    @word1 = options[:word1].strip
    @word2 = options[:word2].strip
  end

  def execute
    response = { msg: false }
    unless (@word1.empty? || @word2.empty?)
      anagram_test = Anagram.new(@word1, @word2)
      response[:msg] = anagram_test.is_anagram?
    end
    response
  end
end

class Anagram
  def initialize(word1, word2)
    @new_word1 = clean_word(word1)
    @new_word2 = clean_word(word2)
  end

  def is_anagram?
    @new_word1.eql? @new_word2
  end

  private
  def clean_word word
    word.downcase.split('').select { |elem| elem =~ /\w/ }.sort.join('')
  end
end
