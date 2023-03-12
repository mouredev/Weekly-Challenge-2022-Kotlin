# /*
#  * Reto #42
#  * CONVERSOR DE TEMPERATURA
#  * Fecha publicación enunciado: 17/10/22
#  * Fecha publicación resolución: 24/10/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
#  * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
#  * - En caso contrario retornará un error.
#  * - ¿Quieres emplear lo aprendido en este reto?
#  *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */


def converter(degrees: str) -> str:
	if 'º' not in degrees:
		return "Invalid Value"
	elif 'C' not in degrees and 'F' not in degrees:
		return "Invalid Value"
	elif 'C' in degrees:
		# ºC -> ºF
		return str((9.0/5.0)*float(degrees[:-2])+32) + 'ºF'
	else:
		# ºF -> ºC
		return str((float(degrees[:-2])-32)/(9.0/5.0)) + 'ºC'


def main():
	print("Degree converter:")
	print("ºC -> ºF and ºF -> ºC")
	celsius1 = '0.0ºC'
	celsius2 = '100.0ºC'
	fahrenheit1 = '32.0ºF'
	fahrenheit2 = '212.0ºF'
	result1 = converter(celsius1)
	result2 = converter(celsius2)
	result3 = converter(fahrenheit1)
	result4 = converter(fahrenheit2)
	result5 = converter('0ºD')
	result6 = converter('0C')

	test = f"{celsius1} = {result1}"

	if result1 == fahrenheit1:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{celsius2} = {result2}"

	if result2 == fahrenheit2:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{fahrenheit1} = {result3}"

	if result3 == celsius1:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{fahrenheit2} = {result4}"

	if result4 == celsius2:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{result5}"

	if result5 == "Invalid Value":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"{result6}"

	if result6 == "Invalid Value":
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)


if __name__ == '__main__':
	main()
