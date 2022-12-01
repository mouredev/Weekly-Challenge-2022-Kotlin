'''
  ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
  24 días, 24 regalos sorpresa relacionados con desarrollo de software,
  ciencia y tecnología desde el 1 de diciembre.
 
  Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne
  lo siguiente:
  - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo
    de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
  - Si la fecha es anterior: Cuánto queda para que comience el calendario.
  - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
 
  Notas:
  - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00
    y finaliza a las 23:59:59.
  - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos
    y segundos.
  - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo
    del calendario de aDEViento hasta el día de su corrección
    (sorteo exclusivo para quien entregue su solución).
 
'''
from datetime import datetime, timedelta

fecha_inicio =  datetime(2022,12,1,00,00,00,00)
fecha_final = datetime(2022,12,25,00,00,00,00)
now= datetime.now()
premios = ["Premio 1","Premio 2","Premio 3","Premio 4","Premio 5","Premio 6","Premio 7","Premio 8","Premio 9","Premio 10","Premio 11","Premio 12",
           "Premio 13","Premio 14","Premio 15","Premio 16","Premio 17","Premio 18","Premio 19","Premio 20","Premio 21","Premio 22","Premio 23","Premio 24"]

def comprobar_fecha(fecha:datetime):
    if (fecha > fecha_inicio) & (fecha < fecha_final): 
      fecha_final_dia = datetime(fecha.year,fecha.month,fecha.day,23,59,59,00) # tendriamos que saber en que dia estamos y pasarle la hora final
      dif_hora = fecha_final_dia - fecha
      print(fecha_final_dia)
      print(fecha)
      return (f'Bienvenido !!! El regalo de hoy es: {premios[fecha.day-1]}, y quedan {dif_hora} para que finalize el sorteo')
    elif (fecha < fecha_inicio):
      dif_hora = fecha_inicio - fecha
      return(f'Aun quedan {dif_hora} para que empiece el Calendario')
    else:
      dif_hora = fecha - fecha_final
      return(f'El calendario ha finalizado hace {dif_hora} ')


fecha = datetime(2022,12,22,12,12,00,00)
print(comprobar_fecha(fecha))
fecha1 = datetime(2022,11,24,12,15,00,00)
print(comprobar_fecha(fecha1))
fecha2 = datetime(2022,12,27,12,10,00,00)
print(comprobar_fecha(fecha2))
