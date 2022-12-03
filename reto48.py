#
# Reto #48
# EL CALENDARIO DE ADEVIENTO 2022
# Fecha publicación enunciado: 28/11/22
# Fecha publicación resolución: 05/12/22
# Dificultad: FACIL
#
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
#

from datetime import datetime
from dateutil.relativedelta import relativedelta

class Calendario_adeviento:
    def __init__(self):
        self.regalos = list()

    def crea_regalos(self):
        self.regalos.append([datetime.strptime("2022-12-01 00:00:00", "%Y-%m-%d %H:%M:%S"), "Programación 1"])
        self.regalos.append([datetime.strptime("2022-12-02 00:00:00", "%Y-%m-%d %H:%M:%S"), "Programación 2"])
        self.regalos.append([datetime.strptime("2022-12-03 00:00:00", "%Y-%m-%d %H:%M:%S"), "Diseño 1"])
        self.regalos.append([datetime.strptime("2022-12-04 00:00:00", "%Y-%m-%d %H:%M:%S"), "Diseño 2"])        
        self.regalos.append([datetime.strptime("2022-12-05 00:00:00", "%Y-%m-%d %H:%M:%S"), "Diseño 3"])
        self.regalos.append([datetime.strptime("2022-12-06 00:00:00", "%Y-%m-%d %H:%M:%S"), "Análisis 1"])
        self.regalos.append([datetime.strptime("2022-12-07 00:00:00", "%Y-%m-%d %H:%M:%S"), "Subscripción Discord 1 mes"])
        self.regalos.append([datetime.strptime("2022-12-08 00:00:00", "%Y-%m-%d %H:%M:%S"), "Subscripción Discord 2 mes"])
        self.regalos.append([datetime.strptime("2022-12-09 00:00:00", "%Y-%m-%d %H:%M:%S"), "Subscripción Discord 3 mes"])
        self.regalos.append([datetime.strptime("2022-12-10 00:00:00", "%Y-%m-%d %H:%M:%S"), "Subscripción Discord 1 año"])
        self.regalos.append([datetime.strptime("2022-12-11 00:00:00", "%Y-%m-%d %H:%M:%S"), "Mentoria con Brais 30 minutos"])
        self.regalos.append([datetime.strptime("2022-12-12 00:00:00", "%Y-%m-%d %H:%M:%S"), "Mentoria con Brais 1 hora"])
        self.regalos.append([datetime.strptime("2022-12-13 00:00:00", "%Y-%m-%d %H:%M:%S"), "Backend con Python 1"])
        self.regalos.append([datetime.strptime("2022-12-14 00:00:00", "%Y-%m-%d %H:%M:%S"), "Backend con Python 2"])
        self.regalos.append([datetime.strptime("2022-12-15 00:00:00", "%Y-%m-%d %H:%M:%S"), "Backend con Python 3"])
        self.regalos.append([datetime.strptime("2022-12-16 00:00:00", "%Y-%m-%d %H:%M:%S"), "Camiseta logo MoureDev"])
        self.regalos.append([datetime.strptime("2022-12-17 00:00:00", "%Y-%m-%d %H:%M:%S"), "Calcetines log MoureDev"])
        self.regalos.append([datetime.strptime("2022-12-18 00:00:00", "%Y-%m-%d %H:%M:%S"), "Taza"])
        self.regalos.append([datetime.strptime("2022-12-19 00:00:00", "%Y-%m-%d %H:%M:%S"), "Kotlin Básico"])
        self.regalos.append([datetime.strptime("2022-12-20 00:00:00", "%Y-%m-%d %H:%M:%S"), "Kotlin Intermedio"])
        self.regalos.append([datetime.strptime("2022-12-21 00:00:00", "%Y-%m-%d %H:%M:%S"), "Kotlin Avanzado"])
        self.regalos.append([datetime.strptime("2022-12-22 00:00:00", "%Y-%m-%d %H:%M:%S"), "Curso Básico JetPack"])
        self.regalos.append([datetime.strptime("2022-12-23 00:00:00", "%Y-%m-%d %H:%M:%S"), "Cena con Brais"])
        self.regalos.append([datetime.strptime("2022-12-24 00:00:00", "%Y-%m-%d %H:%M:%S"), "Amuerzo con Brais"])

    def busca_regalo(self,fecha):
        # FECHA ANTES DEL SORTEO
        if fecha < self.regalos[0][0]:
            self.fecha_anterior(fecha)
        # FECHA EN EL RANGO DEL SORTEO
        elif fecha < self.regalos[-1][0]:
            self.fecha_en_sorteo(fecha)
        # FECHA POSTERIOR AL SORTEO            
        else:
            self.fecha_posterior(fecha)

    def fecha_anterior(self, fecha):
        diferencia = relativedelta(self.regalos[0][0], fecha)
        dif_dias = self.regalos[0][0] - fecha
        return(
            print(
            f"Faltan {dif_dias.days} dias {diferencia.hours} horas {diferencia.minutes} minutos y {diferencia.seconds} segundos"
            )
        )        

    def fecha_en_sorteo(self,fecha):
        for regalo in self.regalos:
            if fecha < regalo[0]:
                diferencia = relativedelta(regalo[0], fecha)
                return(
                    print(
                    f"El regalo es!!: {regalo[1]} y faltan {diferencia.hours} horas, {diferencia.minutes} minutos y {diferencia.seconds} segundos para que finalize el sorteo"
                    )
                )

    def fecha_posterior(self,fecha):
        diferencia = relativedelta(fecha, self.regalos[-1][0])
        dif_dias = fecha - self.regalos[-1][0]
        return(
            print(
            f"El sorteo finalizó hace {dif_dias.days} dias {diferencia.hours} horas {diferencia.minutes} minutos y {diferencia.seconds} segundos"
            )
        )        


if __name__ == '__main__':

    adeviento = Calendario_adeviento()
    adeviento.crea_regalos()

    fecha_buscar = datetime.strptime("2022-11-10 15:30:00", "%Y-%m-%d %H:%M:%S")
    adeviento.busca_regalo(fecha_buscar)

    fecha_buscar = datetime.strptime("2022-12-23 11:45:18", "%Y-%m-%d %H:%M:%S")
    adeviento.busca_regalo(fecha_buscar)

    fecha_buscar = datetime.strptime("2023-12-10 12:00:00", "%Y-%m-%d %H:%M:%S")
    adeviento.busca_regalo(fecha_buscar)
