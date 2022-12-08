# frozen_string_literal: true

#
# Reto #49
# EL DETECTOR DE HANDLES
# Fecha publicación enunciado: 05/11/22
# Fecha publicación resolución: 12/12/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que sea capaz de detectar y retornar todos
# los handles de un texto usando solamente Expresiones Regulares.
# Debes crear una expresión regular para cada caso:
# - Handle usuario: Los que comienzan por "@"
# - Handle hashtag: Los que comienzan por "#"
# - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#

# class Text
class Text
  def handle_detector(input)
    handles = []
    input.split(' ').each do |word|
      word = word.chop if word.end_with?('.', ',', ';', ':')
      # for id handles and tag handles
      handles << word if word.match(/(^@([\w+]{1,15}))|(^#\w+)/)

      # word if word.match(/^@\w+@\w+.\w+/)
      # handles << word if word.match(/^#\w+$/)
      next unless word.match(%r{(https?://(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+
        [a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.
        [^\s]{2,}|https?://(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})})

      handles << word
    end
    handles
  end

  # def id_handle(input)
  #   # puts "id_handle: #{input}"
  #   input.scan(/(?<!\w)@[\w+]{1,15}\b/).concat(input.scan(/@[\w+]{1,15}@[\w+]{1,15}.[\w+]{1,15}/))
  # end

  # def tag_handle(input)
  #   input.scan(/(?<!\w)#[\w+]{1,15}\b/)
  # end

  # def url_handle(input)
  #   input.scan(/(https?://(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?://(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/)
  # end
end
