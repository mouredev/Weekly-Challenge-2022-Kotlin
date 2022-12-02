"""/*
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
 */"""



from datetime import datetime
from datetime import timedelta


def trs_segundos(s):
    horas = int(s/60/60)
    s -= horas*60*60
    minutos = int(s/60)
    s -= minutos*60
    segundos = int(s)
    return (horas, minutos, segundos)



# LISTA DE LOS REGALOS
start_date = datetime.strptime('01/12/2022', '%d/%m/%Y')
Regalos = list()
for i in range(24+1):   # Sumamos un dia más pora tener en cuenta el último día del sorteo. La fecha de empezar el sorteo el dia 25 es para marcar el final del sorteo de dia 24.
    Regalos.append([start_date + timedelta(days=i), "Regalo {}".format(i)])

# COMPARAMOS LAS FECHAS:
def comprovar_fecha(date, start_date = datetime.strptime('01/12/2022', '%d/%m/%Y')):
    if date < start_date:           # La fecha és anterior al concurso. Indicamos cuanto falta para que empieze el concurso.
        time = start_date - date    # Los timedelta solo almacena los días, segundos y microsegundos.
        d =time.days
        h, m, s = trs_segundos(time.seconds)
        return (print( "Falta {} dias, {} horas, {} minutos y {} segundos para que empiezen los sorteos".format(d,h,m,s)))

    elif date < Regalos[-1][0]:     # Comprovamos si la fecha se encuentra dentro del sorteo
        for regalo in Regalos:
            if date < regalo[0]:    #
                print("El regalo sorteado es: {}".format(regalo[1]))
                time = regalo[0] - date
                h, m, s = trs_segundos(time.seconds)    # Tendriamos que restar 1 segundo? Ya que utilizamos la fecha de cuando empieza el siguiente sorte.
                return (print("Faltan {} horas, {} minutos y {} segundos para que termine el sorteo.".format(h,m,s)))

    else:                           #Este seria el caso en que la fecha introdució es despues del calendiario.
        time = date -Regalos[-1][0] 
        d =time.days
        h, m, s = trs_segundos(time.seconds)
        return (print( "El sorteo termino hace {} dias, {} horas, {} minutos y {} segundos".format(d,h,m,s)))


def pedir_fecha():  # Pedir que el usuario introduzca una fecha o utilizar la fecha actual. 
    """
    El usuaripo puede escoger entre utilizar la fecha actual o poner manualmente una fecha.
    En caso de poner una fecha manual se suponoe que es la hora 00:00 del día escogido. 
    """
    Entrada = input(print("Seleccionar una Fecha manual (Y), presionar cualquier tecla para utilitzar fecha actual:"))     # El usuario puede escoger entre
    selec_date = Entrada == 'Y' or Entrada == 'y'

    if selec_date:
        while True:
            try:
                date = input("Introduce una fecha con el formato DD/MM/YYYY: ")
                datetime.strptime(date, '%d/%m/%Y')
                print("Fecha valida")
                break
            except:
                print("Fecha inválida")       
    else:
        date = datetime.now()
    
    return date


#Caso que la fecha sea anterior al concurso
año, mes, dia, hora, minuto, segundos = (2022, 11, 29, 23, 00, 30)
fecha = datetime(año, mes, dia, hora, minuto, segundos)
comprovar_fecha(fecha)

# Caso que la fecha sea posterior al concurso
año, mes, dia, hora, minuto, segundos = (2022, 12, 25, 4, 00, 00)
fecha = datetime(año, mes, dia, hora, minuto, segundos)
comprovar_fecha(fecha)

# Caso que la fecha sea el primer dia del concurso
año, mes, dia, hora, minuto, segundos = (2022, 12, 1, 1, 00, 00)
fecha = datetime(año, mes, dia, hora, minuto, segundos)
comprovar_fecha(fecha)
# Caso que la fecha sea intermedia al concurso
año, mes, dia, hora, minuto, segundos = (2022, 12, 10, 12, 00, 00)
fecha = datetime(año, mes, dia, hora, minuto, segundos)
comprovar_fecha(fecha)
# Caso que la fecha sea el útlimo dia del concurso
año, mes, dia, hora, minuto, segundos = (2022, 12, 24, 12, 00, 00)
fecha = datetime(año, mes, dia, hora, minuto, segundos)
comprovar_fecha(fecha)


