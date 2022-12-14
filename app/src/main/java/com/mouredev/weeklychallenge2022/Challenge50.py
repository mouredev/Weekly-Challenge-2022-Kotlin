# /*
#  * Reto #50
#  * LA ENCRIPTACIÓN DE KARACA
#  * Fecha publicación enunciado: 12/11/22
#  * Fecha publicación resolución: 19/12/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
#  * algoritmo de encriptación de Karaca (debes buscar información sobre él).
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */

ENCRYPT = {
	'a': 0,
	'e': 1,
	'i': 2,
	'o': 2,
	'u': 3
}

DECRYPT = {
	'0': 'a',
	'1': 'e',
	'2': 'i',
	'3': 'u'
}

END = 'aca'

def karaca(text: str, operation: bool) -> list: # True -> encrypt; False -> decrypt;
	final_text = ""

	if operation:
		word = list(text)
		word.reverse()
		for l in word:
			if l in ENCRYPT.keys():
				final_text += str(ENCRYPT[l])
			else:
				final_text += l

		final_text += END
		final_text = [final_text]
	else:
		text = text.replace(END, '')
		word = list(text)
		word.reverse()

		equals = False
		final_text2 = ""

		for l in word:
			if not equals:
				if l in DECRYPT.keys():
					final_text += str(DECRYPT[l])
				else:
					final_text += l
			else:
				if l in DECRYPT.keys():
					final_text += str(DECRYPT[l])
					final_text2 += str(DECRYPT[l])
				else:
					final_text += l
					final_text2 += l
			if l == '2':
				final_text2 = final_text.replace('i', '') + 'o'
				equals = True
		if not equals:
			final_text = [final_text]
		else:
			final_text2.replace('i', '')
			final_text = [final_text, final_text2]

	return final_text

def main():
	encrypt = karaca("apple", True)
	decrypt = karaca("1lpp0aca", False)

	print(encrypt)
	print(decrypt)

	if encrypt[0] == '1lpp0aca':
		print("Correct!")

	if decrypt[0] == 'apple':
		print("Correct!")

	encrypt = karaca("home", True)
	decrypt = karaca("1m2haca", False)

	print(encrypt)
	print(decrypt)

	if encrypt[0] == '1m2haca':
		print("Correct!")

	if decrypt[0] == 'hime' and decrypt[1] == 'home':
		print("Correct!")

	encrypt = karaca("mouredev", True)
	decrypt = karaca("v1d1r32maca", False)

	print(encrypt)
	print(decrypt)

	if encrypt[0] == 'v1d1r32maca':
		print("Correct!")

	if decrypt[0] == 'miuredev' and decrypt[1] == 'mouredev':
		print("Correct!")


if __name__ == '__main__':
	main()