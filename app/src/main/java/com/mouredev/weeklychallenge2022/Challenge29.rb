# 
# Reto #29
# ORDENA LA LISTA
# Fecha publicación enunciado: 18/07/22
# Fecha publicación resolución: 26/07/22
# Dificultad: FÁCIL
#
# Enunciado: Crea una función que ordene y retorne una matriz de números.
# - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
#   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
# - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
# 
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
# 

# Solución
# Solución desarrollada en Ruby sin usar los comandos propios para ordenar.
# Algoritmo usado es select sort
# Previamente se realiza una revisión si se están pasando los comandos apropiados ('ASC', 'DESC') y
# si los elementos de la lista son del tipo requerido (entero).
# Las pruebas están definidas en Challenge29_test.rb
# Cualquier comentario será bienvenido.

class Main
  def initialize options = {}
    @list = clean_list(options[:list])
    @order = options[:order]
  end

  def execute
    response = { list: [] }
    if review_order && !@list.empty? 
      sorting = ListSorting.new(clean_list(@list), @order)
      response[:list] = sorting.sort
      response[:msg] = 'Ok'
    end
    response[:msg] = 'Comando no apropiado' unless review_order
    response[:msg] = 'Lista sin números' if @list.empty?
    response
  end

  private
  def review_order
    order_options = ['ASC', 'DESC']
    order_options.include? @order
  end

  def clean_list list
    list.select { |elem| elem.is_a?(Integer) }
  end
end

class ListSorting
  def initialize(unordered_list, order)
    @list = unordered_list
    @order = order
  end

  def sort
    select_sort
    @list
  end

  private
  def swap pos, element_pos
    temp = @list[pos]
    @list[pos] = @list[element_pos]
    @list[element_pos] = temp
  end

  def find_by_order position
    start_pos = position
    element_pos = start_pos
    (start_pos...@list.size).each do |elem|
      case @order
      when 'ASC'
        element_pos = elem if @list[elem] < @list[element_pos]
      when 'DESC'
        element_pos = elem if @list[elem] > @list[element_pos]
      end
    end
    element_pos
  end
  
  def select_sort
    start = 0
    @list.each_with_index do |_, pos|
      element_pos = find_by_order(pos)
      swap(pos, element_pos)
    end
  end
end
