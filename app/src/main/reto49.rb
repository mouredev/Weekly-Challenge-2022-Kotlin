=begin
  * Enunciado: Crea una función que sea capaz de detectar y retornar todos los
  * handles de un texto usando solamente Expresiones Regulares.
  * Debes crear una expresión regular para cada caso:
  * - Handle usuario: Los que comienzan por "@"
  * - Handle hashtag: Los que comienzan por "#"
  * - Handle web: Los que comienzan por "www.", "http://", "https://"
  *   y finalizan con un dominio (.com, .es...)
=end
class Reto49
  # user y hashtag: Solo se comprueba que la palabra empiece por @ y #.
  # web: Comprueba que empiece por http://, https://, o www. y termine con dominio de 2 a 5
  #      caracteres alfabéticos.
  HANDLES = {
    user: /^@/,
    hashtag: /^#/,
    web: /\A(http:\/\/|https:\/\/|www.)+[\w-]+(.[a-z]{2,5})$/
  }.freeze

  ###
  # Método de clase para detectar los handles de un texto pasado como parámetro.
  # Ejemplo: Reto49.detect_handles("Un texto con varios handles #ruby @dhh") devuelve:
  #          "Los handles detectados son: #ruby, @dhh"
  #
  # @param [String] text
  # @return [String]
  def self.detect_handles(text)
    detected_handles = []

    text.split(' ').each do |word|
      HANDLES.each do |_name, regex|
        detected_handles << word if word.match(regex)
      end
    end

    "Los handles detectados son: #{detected_handles.join(', ')}"
  end
end
