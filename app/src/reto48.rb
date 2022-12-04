# ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
# 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
# ciencia y tecnología desde el 1 de diciembre.
#
# Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
# lo siguiente:
# - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
#   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
# - Si la fecha es anterior: Cuánto queda para que comience el calendario.
# - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
#
# Notas:
# - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
#   y finaliza a las 23:59:59.
# - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
#   y segundos.
# - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
#   del calendario de aDEViento hasta el día de su corrección
#   (sorteo exclusivo para quien entregue su solución).

require 'date'

class Reto48
  PRESENTS = ['Libro Backend', 'Libro Frontend', 'Abrazo', 'Garmin 1030', 'Teclado mecánico', 'Ratón', 'Iphone 14',
              'Monitor LG', 'Disco duro SSD 1TB', 'Portatil Acer', 'Mac Studo', 'Airpods', 'Ipad',
              'Maceta', 'Viaje a Ibiza', 'Apple TV', "Libro 'Curso intensivo de Ruby'", 'Sugus de piña',
              'Apple Watch', 'XBOX Series X', 'Play 5', 'Samsung Q70', 'Año de HBO Max',
              'Smartwatch', 'Cecotec Mambo'].freeze

  START_DATE = Time.new(2022, 12, 1)
  END_DATE = Time.new(2022, 12, 25)

  def advent_calendar(date:)
    raise ArgumentError, 'Debes introducir una fecha válida' unless date.is_a?(Time)

    return "Quedan #{formatted_duration(START_DATE - date)} para que comience el calendario" if date < START_DATE
    return "Hace #{formatted_duration(date - END_DATE)} que terminó el calendario" if date >= END_DATE

    day = date.day
    end_of_day = Time.new(date.year, date.month, day, 23, 59, 59)

    "¡Enhorabuena! Has ganado un increible #{PRESENTS[day - 1]}. Quedan #{formatted_duration(end_of_day - date)} horas para que finalice el sorteo del día"
  end

  private

  def formatted_duration(seconds)
    dhms = [60, 60, 24].reduce([seconds]) { |m, o| m.unshift(m.shift.divmod(o)).flatten }

    return "%d días %d horas %d minutos %d segundos" % dhms unless dhms[0].zero?
    return "%d horas %d minutos %d segundos" % dhms[1..3] unless dhms[1].zero?
    return "%d minutos %d segundos" % dhms[2..3] unless dhms[2].zero?

    "%d segundos" % dhms[3]
  end
end
