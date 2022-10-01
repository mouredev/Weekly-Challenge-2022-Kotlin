# frozen_string_literal: true

#
#  Reto #39
#  TOP ALGORITMOS: QUICK SORT
#  Fecha publicación enunciado: 27/09/22
#  Fecha publicación resolución: 03/10/22
#  Dificultad: MEDIA
#
#  Enunciado: Implementa uno de los algoritmos de ordenación más famosos:
#  el "Quick Sort", creado por C.A.R. Hoare.
#  - Entender el funcionamiento de los algoritmos más utilizados
#    de la historia nos ayuda a mejorar nuestro conocimiento sobre
#    ingeniería de software. Dedícale tiempo a entenderlo, no únicamente
#    a copiar su implementación.
#  - Esta es una nueva serie de retos llamada "TOP ALGORITMOS",
#    donde trabajaremos y entenderemos los más famosos de la historia.
#
#  Información adicional:
#  - Usa el canal de nuestro Discord (https://mouredev.com/discord)
#    "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Tienes toda la información sobre los retos semanales en
#    https://retosdeprogramacion.com/semanales2022.
#

# Solución:
# Requerimientos:
# Ruby 2.7.3
#
# Ejecución:
# ruby Challenge39_test.rb

# QuickSort solution: https://www.geeksforgeeks.org/quick-sort/ for Always pick the last element as pivot

# Partition function for picking the first element as pivot is original

# class to execute quicksort
class Main
  def initialize(arr)
    @arr = arr
  end

  def execute
    SortingMethods.new.quick_sort_runner(@arr)
  end
end

# class for sorting methods
class SortingMethods
  def quick_sort_runner(arr)
    quick_sort(arr, 0, arr.size - 1) if arr.size >= 2
    arr
  end

  private

  def quick_sort(arr, low, high)
    return unless low < high

    pi = sorting_select(arr, low, high)
    quick_sort(arr, low, pi - 1)
    quick_sort(arr, pi + 1, high)
  end

  def partition_pivot_first(arr, low, high)
    pivot = arr[low]
    j = high + 1
    high.downto(low + 1) do |i|
      next if arr[i] < pivot

      j -= 1
      swap(arr, i, j)
    end
    swap(arr, low, j - 1)
    j - 1
  end

  def partition_pivot_last(arr, low, high)
    pivot = arr[high]
    i = low - 1
    (low..high - 1).each do |j|
      next if arr[j] > pivot

      i += 1
      swap(arr, i, j)
    end
    swap(arr, i + 1, high)
    i += 1
  end

  def swap(arr, low, high)
    temp = arr[low]
    arr[low] = arr[high]
    arr[high] = temp
  end

  def sorting_select(arr, low, high)
    sorting_option = rand(2)
    partition_pivot_first(arr, low, high) if sorting_option.zero?
    partition_pivot_last(arr, low, high)
  end
end
