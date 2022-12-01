

"""


---------------------------------
author of solution:
LeonardoReichert@github.com
(RearlanFDX@twitch)
---------------------------------



Challenge MoureDev@Twitch

/*
 * Reto #48
 * EL CALENDARIO DE ADEVIENTO 2022
 * Fecha publicación enunciado: 28/11/22
 * Fecha publicación resolución: 05/12/22
 * Dificultad: FÁCIL
 *
 * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
 * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
 *
 * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
 * - Si la fecha coincide con el calendario de aDEViento 2022:
         Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
         
 * - Si la fecha es anterior:
      Cuánto queda para que comience el calendario.
 * - Si la fecha es posterior:
      Cuánto tiempo ha pasado desde que ha finalizado.
 *
 * Notas:
 * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
 * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
 * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


"""


import time;
from datetime import datetime;
from random import choice;



premios = ["curso de Cobol certificado",
           "curso cobol",
           "curse of Cobol",
           "curse of Cobol :D",
           "Desarrollo web, disenyo",
        ];


def seconds2strtime(seconds):
    #usado para mostrar el tiempo corrido de fechas, no diario

    days, seconds = seconds//(60*60*24), seconds%(60*60*24);
    hours, seconds = seconds//(60*60), seconds%(60*60);
    mins, seconds = seconds//60, seconds%60;
    
    return "%d dias, %d horas %02d segundos" % (days, hours, mins);
    

def pedirRegaloDeMoure(dtNowUTC):

    """
    Gestiona regalos del calendario aDEViento
    
    dtNowUTC: es una clase "datetime" en UTC (GMT+0)

    devuelve tupla de dos valores:
            (0: Regalo random en string o None,
             1: el tiempo que falta para el evento o cuanto ha pasado,
                   si hay regalo se refiere a cuanto tiempo queda del dia en el evento actual
             )

    el tiempo devuelto es una cadena
    
    Debemos comprobar si la funcion devuelve regalo para gestionar a que se debe el tiempo devuelto             
    """

    #la corregimos al horario de españa GMT+1, agregando 1hs:
    #dtime.hour += 1; #<- no se puede, es readonly
    dtNowUTC = datetime.fromtimestamp(dtNowUTC.timestamp()+(60*60));
    
    #definimos la fecha del evento aDEViento:
    startEventDatetime = datetime(2022, 12, 1, 0, 0, 0);  #1 de diciembre
    endEventDatetime = datetime(2022, 12, 24, 0, 0, 0);   #24 de diciembre

    #convertimos toda dos fechas a formato segundos:
    nowSecs = dtNowUTC.timestamp();
    startSecs = startEventDatetime.timestamp();
    endSecs = endEventDatetime.timestamp();
    

    #comprobamos si no hemos llegado a la fecha del evento:
    if nowSecs < startSecs:
        diffStart = startSecs-nowSecs;
        return (None, "evento no ha empezado, falta %s." % seconds2strtime(diffStart));

    #comprobamos si el evento ha terminado de fecha:
    elif nowSecs > endSecs:
        diffEnd = nowSecs-endSecs;
        return (None, "evento terminado, ha pasado %s." % seconds2strtime(diffEnd));

    #el evento esta on aun, obtenemos los segundos que faltan para que termine:
    eventEndSecs = datetime(dtNowUTC.year, dtNowUTC.month, dtNowUTC.day+1).timestamp()  -  nowSecs;
    
    return (choice(premios), "evento terminara en %s" % time.strftime("%H:%M:%S", time.gmtime(eventEndSecs)));



print("El programa imprime el premio por el dia de aDEViento:")


#obtenemos hora GMT+0 (utc):    
currentDatetime = datetime.utcnow();
premio, msgtiempo = pedirRegaloDeMoure(currentDatetime);
    

if premio:
    print("Felicidades! el premio es", premio);
    print(msgtiempo);
else:
    print("No hay premio.");
    print(msgtiempo);


print("Fin del programa, saludos a MoureDev");

#RearlanFDX









