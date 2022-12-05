# frozen_string_literal: true

#
# Reto #48
# EL CALENDARIO DE ADEVIENTO 2022
# Fecha publicación enunciado: 28/11/22
# Fecha publicación resolución: 05/12/22
# Dificultad: FÁCIL
#
# ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
# 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia
# y tecnología desde el 1 de diciembre.
#
# Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
# - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el
#   regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
# - Si la fecha es anterior: Cuánto queda para que comience el calendario.
# - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
#
# Notas:
# - Tenemos en cuenta que cada día del calendario comienza a medianoche
#   00:00:00 y finaliza a las 23:59:59.
# - Debemos trabajar con fechas que tengan año, mes, día, horas,
#   minutos y segundos.
# - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del
#   calendario de aDEViento hasta el día de su corrección
#   (sorteo exclusivo para quien entregue su solución).
#
# Información adicional:
# - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Tienes toda la información sobre los retos semanales en
#   https://retosdeprogramacion.com/semanales2022.
#
#

require 'time'

# main class Year
class Year
  # aDEVent start time, Spain time zone
  START_ADVENT = Time.parse('2022-12-01T00:00:00+01:00')
  # aDEVent end time, Spain time zone
  END_ADVENT = Time.parse('2022-12-24T23:59:59+01:00')
  # Advent gifts
  GIFTS = %w[ebooks ecourses games].freeze

  def adevent(input)
    response = {}
    response[:gift] = gift if input.to_i > START_ADVENT.to_i && input.to_i < END_ADVENT.to_i

    response[:time_left] = calculate_time(input)
    response
  end

  # randomly return a gift
  def gift
    GIFTS[rand(GIFTS.size)]
  end

  def calculate_time(input)
    difference = calc_diff(input)

    partial_minutes, seconds = difference.divmod(60)
    partial_hours, minutes = partial_minutes.divmod(60)
    partial_days, hours = partial_hours.divmod(24)
    partial_months, days = partial_days.divmod(30.437)
    years, months = partial_months.divmod(12)

    { years: years.round, months: months.round, days: days.round, hours: hours.round, minutes: minutes.round,
      seconds: seconds.round }
  end

  def calc_diff(input)
    return START_ADVENT.to_i - input.to_i if input.to_i < START_ADVENT.to_i
    return input.to_i - END_ADVENT.to_i if input.to_i > END_ADVENT.to_i

    Time.parse("#{Date.parse(input.to_s)}T23:59:59+00:00").to_i - input.to_i
  end
end
