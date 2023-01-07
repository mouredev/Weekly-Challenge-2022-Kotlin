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
import datetime
import random

ADVENT_2022 = datetime.datetime(2022, 12, 1)
YEAR = ADVENT_2022.strftime("%Y")
MONTH = ADVENT_2022.strftime("%m")
FIRST_DAY = datetime.datetime(2022, 12, 1).strftime("%d")
LAST_DAY = datetime.datetime(2022, 12, 24).strftime("%d")
START_DATE = datetime.datetime(2022, 12, 1, 0, 0, 0)
END_DATE = datetime.datetime(2022, 12, 24, 23, 59, 59)


def advent(d: datetime):
	print(d.date())
	if d.strftime("%Y") == YEAR and d.strftime("%m") == MONTH and FIRST_DAY <= d.strftime("%d") <= LAST_DAY:
		difference = (d - END_DATE) * -1
		message = "Congratulations you win! -> Present" + str(random.randrange(0, 100))
		message = message + f"\n{difference.seconds} seconds left!"
	elif d.strftime("%Y") == YEAR and d.strftime("%m") == MONTH and d.strftime("%d") > LAST_DAY:
		difference = d - END_DATE
		message = f"{difference.days} days and {difference.seconds} senconds pased!"
	elif d.strftime("%Y") <= YEAR and d.strftime("%m") <= MONTH:
		difference = START_DATE - d
		message = f"{difference.days} days and {difference.seconds} senconds to start!"
	else:
		difference = d - END_DATE
		message = f"{difference.days} days and {difference.seconds} senconds pased!"

	print(message)

def main():
	advent(datetime.datetime.now())
	advent(datetime.datetime(2022, 11, 1, 0, 0, 0))
	advent(datetime.datetime(2022, 10, 5, 0, 0, 0))
	advent(datetime.datetime(2022, 12, 25, 0, 0, 0))
	advent(datetime.datetime(2023, 12, 24, 0, 0, 0))
	advent(datetime.datetime(2050, 1, 24, 0, 0, 0))
	advent(datetime.datetime(2050, 12, 31, 23, 59, 59))
	advent(datetime.datetime(1983, 12, 31, 23, 59, 59))
	advent(datetime.datetime(1983, 12, 1, 0, 0, 0))
	advent(datetime.datetime(2021, 12, 1, 0, 0, 0))
	advent(datetime.datetime(2022, 11, 30, 23, 59, 59))
	advent(datetime.datetime(2022, 11, 30, 23, 59, 58))
	advent(datetime.datetime(2022, 11, 30, 23, 59, 0))
	advent(datetime.datetime(2022, 11, 30, 23, 58, 0))
	advent(datetime.datetime(2022, 11, 30, 23, 0, 0))
	advent(datetime.datetime(2022, 11, 30, 22, 0, 0))
	advent(datetime.datetime(2021, 12, 1, 23, 59, 59))
	advent(datetime.datetime(2021, 12, 1, 23, 59, 0))
	advent(datetime.datetime(2021, 12, 1, 23, 0, 0))

if __name__ == '__main__':
	main()