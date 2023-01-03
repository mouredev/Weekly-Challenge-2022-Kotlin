# package com.mouredev.weeklychallenge2022

# /*
#  * Reto #48
#  * EL CALENDARIO DE ADEVIENTO 2022
#  * Fecha publicación enunciado: 28/11/22
#  * Fecha publicación resolución: 05/12/22
#  * Dificultad: FÁCIL
#  *
#  * ¿Conoces el calendario de adviento de la comunidad (https://adviento.dev)?
#  * 24 días, 24 regalos sorpresa relacionados con desarrollo de software, ciencia y tecnología desde el 1 de diciembre.
#  *
#  * Enunciado: Crea una función que reciba un objeto de tipo "Date" y retorne lo siguiente:
#  * - Si la fecha coincide con el calendario de aDEViento 2022: Retornará el regalo de ese día (a tu elección) y cuánto queda para que finalice el sorteo de ese día.
#  * - Si la fecha es anterior: Cuánto queda para que comience el calendario.
#  * - Si la fecha es posterior: Cuánto tiempo ha pasado desde que ha finalizado.
#  *
#  * Notas:
#  * - Tenemos en cuenta que cada día del calendario comienza a medianoche 00:00:00 y finaliza a las 23:59:59.
#  * - Debemos trabajar con fechas que tengan año, mes, día, horas, minutos y segundos.
#  * - 🎁 Cada persona que aporte su solución entrará en un nuevo sorteo del calendario de aDEViento hasta el día de su corrección (sorteo exclusivo para quien entregue su solución).
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */

from datetime import datetime

def calendar(date):
    if date >= datetime(2022, 12, 1, 0, 0, 0) and date <= datetime(2022, 12, 24, 23, 59, 59):
        present = {1:"Libro Python", 2:"Curso Python", 3:"Licencia desarrolador android", 4:"Libro C#", 5:"Curso C#", 6:"Licencia desarrollador apple", 7:"Curso Kotlin", 8:"Libro Kotlin", 9:"Curso desarrollo font-end", 10:"Libro emprendimiento", 11:"Curso desarrollo back-end", 12:"Curso desarrollo web", 13:"Libro Python", 14:"Curso Python", 15:"Licencia desarrolador android", 16:"Libro C#", 17:"Curso C#", 18:"Licencia desarrollador apple", 19:"Curso Kotlin", 20:"Libro Kotlin", 21:"Curso desarrollo font-end", 22:"Libro emprendimiento", 23:"Curso desarrollo back-end", 24:"Curso desarrollo web", }
        day = date.day
        hour_diff = 23 - date.hour
        minute_diff = 59 - date.minute
        second_diff = 59 - date.second
        return (f'El regalo es {present[day]} y quedan {hour_diff} horas, {minute_diff} minutos y {second_diff} segundos')
    elif date < datetime(2022, 12, 1, 0, 0, 0):
        date_diff = datetime(2022, 12, 1, 0, 0, 0) - date
        day_diff = date_diff.days
        hour_dif = date_diff.seconds // 60 // 60
        minute_diff = date_diff.seconds // 60 % 60
        second_diff = date_diff.seconds % 60 % 60
        return (f'Quedan {date_diff.days} dias, {hour_dif} horas, {minute_diff} minutos y {second_diff} segundos')
    elif date > datetime(2022, 12, 24, 23, 59, 59):
        date_diff = date - datetime(2022, 12, 24, 23, 59, 59)
        day_diff = date_diff.days
        hour_dif = date_diff.seconds // 60 // 60
        minute_diff = date_diff.seconds // 60 % 60
        second_diff = date_diff.seconds % 60 % 60
        return (f'Han pasado {date_diff.days} dias, {hour_dif} horas, {minute_diff} minutos y {second_diff} segundos')

print(calendar(datetime(2022, 11, 1, 23, 59, 59)))
print(calendar(datetime(2023, 1, 1, 23, 59, 59)))
print(calendar(datetime(2022, 12, 6, 23, 59, 59)))
print(calendar(datetime(2022, 1, 1, 11, 23, 31)))
print(calendar(datetime(2022, 12, 21, 10, 33, 45)))
