"""
/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
"""

defmodule Challenge32 do
  def second_largest([_ | _] = input) do
    [_, second | _] = Enum.sort(input, :desc)
    {:ok, second}
  end
  
  def second_largest(_input) do
    {:error, :empty_list}
  end
end

# Examples:
 
# Challenge32.second_largest([1, 2, 6, 9, 3, 4, 10])
# {:ok, 9}

# Challenge32.second_largest([])
# {:error, :empty_list}
