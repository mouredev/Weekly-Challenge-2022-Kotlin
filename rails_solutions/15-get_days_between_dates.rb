 #  Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 #  de texto que representen fechas.
 # - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 # - La función recibirá dos String y retornará un Int.
 # - La diferencia en días será absoluta (no importa el orden de las fechas).
 # - Si una de las dos cadenas de texto no representa una fecha correcta se
 #   lanzará una excepción.


# Hora de inicio 19:40
# Hora de inicio 19:59

require 'date'
 
def get_days_between_dates(strDateBegin, strDateEnd) 

    validDate1 = validate_date(strDateBegin)
    validDate2 = validate_date(strDateEnd)

    strDateBegin = Date.parse(strDateBegin)
    strDateEnd = Date.parse(strDateEnd)


    if validDate1 && validDate2
    puts "La cantidad de días transcurridos entre la fecha inicial: #{strDateBegin} y la fecha final: #{strDateEnd} fueron #{strDateEnd.mjd - strDateBegin.mjd} días"
    end
end

def validate_date(string)
  format_ok = string.match(/\d{2}\/\d{2}\/\d{4}/)
  parseable = Date.strptime(string, '%d/%m/%y') rescue false

  if !format_ok && !parseable
    puts "date is not valid"
    return false
  end

    return true
end

 print get_days_between_dates("11/05/2005","11/06/2005")  # True
 print get_days_between_dates("11-05-200","11/06/2005")  # True