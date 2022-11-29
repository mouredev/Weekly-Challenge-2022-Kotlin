
'''
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software,
 * ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
 * lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
 *   de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
 * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
 *   y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
 *   y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
 *   del calendario de aDEViento hasta el día de su corrección
 *   (sorteo exclusivo para quien entregue su solución).
 *
'''
from datetime import  datetime, timedelta

datetime_str  = "01/01/2022 23:55:26"
datetime_str  = datetime.strptime(datetime_str, "%d/%m/%Y %H:%M:%S")
#print(type(datetime_str))
#datetime_str = datetime.strptime(datetime_str, %/%m/%y %H:%M:%S)
def aviento(date: datetime):
  prime = ["Curso Gratis X1 Semana","Curso Gratis X2 Semana","Curso Gratis X1 Mes"
          ,"Curso Gratis X2 Meses","Curso Gratis X3 Meses","Curso Gratis X4 Meses"
          ,"Iphone X","Iphone XI","Iphone XII"
          ,"Teclado Pro","Mouse Pro","Web Cam Pro"
          ,"Monitor(19'')","Monitor(20'')","Monitor(32'')"
          ,"100$","200$","300$"
          ,"400$","500$","600$"
          ,"Laptop Core I3","Laptop Core I5","Laptop Core I7"]
  if date >= datetime.fromisoformat("2022-12-01") and date < datetime.fromisoformat("2022-12-25"):
   print(f"Felicidades el premio que ganaste es: {prime[date.day-1]}")
  elif date < datetime.fromisoformat("2022-12-01"):
    day = (datetime(year=2022, month=12, day=1)-date)
    time = timedelta(seconds=(day.seconds))
    print(f"Fanta {day.days} dia(s) y {time} horas")
  else:
    day = (date-datetime(year=2022, month=12, day=25, hour=23, minute= 59, second=59))
    time = timedelta(seconds=(day.seconds))
    print(f"Han pasado {day.days} dia(s) y {time} horas")

aviento(datetime_str)