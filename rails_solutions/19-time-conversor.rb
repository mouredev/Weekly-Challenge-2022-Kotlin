 # Crea una función que reciba días, horas, minutos y segundos (como enteros)
 # y retorne su resultado en milisegundos.

 # Hora inicio: 19:08
 # Hora de cierre 19:25
def time_to_millis(days, hours, minutes, seconds)

    millis = seconds * 1000
    millis += minutes * 60000
    millis += hours * 3600000
    millis += days * 86400000
    puts  "You have #{millis} millis"

end

 print time_to_millis(2, 0, 0, 0)  # 
 172800000