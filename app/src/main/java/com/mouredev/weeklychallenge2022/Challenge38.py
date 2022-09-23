'''
/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
'''


def binary_to_decimal(binary: int) -> int:
	number = 0
	counter = len(str(binary)) - 1

	for bit in str(binary):
		number += int(bit) * (2**counter)
		counter -= 1

	return number


def main():
	binary1 = 10
	binary2 = 101
	binary3 = 0
	binary4 = 11111111
	number1 = binary_to_decimal(binary1)
	number2 = binary_to_decimal(binary2)
	number3 = binary_to_decimal(binary3)
	number4 = binary_to_decimal(binary4)

	test = f"Binary = {binary1} -> Decimal = {number1}"

	if number1 == 2:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"Binary = {binary2} -> Decimal = {number2}"

	if number2 == 5:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"Binary = {binary3} -> Decimal = {number3}"

	if number3 == 0:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)

	test = f"Binary = {binary4} -> Decimal = {number4}"

	if number4 == 255:
		test = test + " CORRECT!"
	else:
		test = test + " INCORRECT!"

	print(test)


if __name__ == '__main__':
	main()
