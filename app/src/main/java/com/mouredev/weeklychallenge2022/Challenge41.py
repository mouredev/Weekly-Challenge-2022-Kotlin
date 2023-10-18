# /*
#  * Reto #41
#  * LA LEY DE OHM
#  * Fecha publicación enunciado: 10/10/22
#  * Fecha publicación resolución: 17/10/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
#  * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
#  * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */


def ohm(voltage, resistance, current):
	if voltage is not None and resistance is not None and current is None and resistance != 0:
		return round(voltage/resistance)
	elif voltage is None and resistance is not None and current is not None:
		return round(current * resistance, 2)
	elif voltage is not None and resistance is None and current is not None and current != 0:
		return round(voltage/current)
	else:
		return "Invalid values"


def main():
	print("Ohm's law -> I = V/R")
	voltage = 30
	resistance = 10
	current = 3
	current1 = ohm(voltage, resistance, None)
	voltage1 = ohm(None, resistance, current)
	resistance1 = ohm(voltage, None, current)
	error1 = ohm(voltage, None, None)
	error2 = ohm(None, None, None)
	error3 = ohm(voltage, 0, None)
	error4 = ohm(voltage, None, 0)

	test = f"I = V/R = {voltage}V/{resistance}Ω = {current1}A"

	if current1 == current:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"V = I * R = {current}A * {resistance}Ω = {voltage1}V"

	if voltage1 == voltage:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"R = V/I = {voltage}V/{current}A = {resistance1}Ω"

	if resistance1 == resistance:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{error1}"

	if error1 == "Invalid values":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{error2}"

	if error2 == "Invalid values":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{error3}"

	if error3 == "Invalid values":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{error4}"

	if error4 == "Invalid values":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)


if __name__ == '__main__':
	main()
