# /*
#  * Reto #49
#  * EL DETECTOR DE HANDLES
#  * Fecha publicación enunciado: 05/11/22
#  * Fecha publicación resolución: 12/12/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
#  * Debes crear una expresión regular para cada caso:
#  * - Handle usuario: Los que comienzan por "@"
#  * - Handle hashtag: Los que comienzan por "#"
#  * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */
import re

USERNAME = r"@[a-zA-Z0-9]*"
HASTAG = r"#[a-zA-Z0-9]*"
WEB = r"https*://[a-zA-z0-9]*\.[a-z]*|www\.[a-zA-z0-9]*\.[a-z]*|https*://www\.[a-zA-z0-9]*\.[a-z]*"


def handle_detector(text : re) -> None:
	usernames = re.findall(USERNAME, text)
	hastags = re.findall(HASTAG, text)
	webs = re.findall(WEB, text)

	print_results(text, usernames, hastags, webs)

def print_results(text: re, usernames: list, hastags: list, webs: list) -> None:
	usernames_text = ""
	hastags_text = ""
	webs_text = ""

	if len(usernames) > 0:
		usernames_text = "Usernames: "

		for i in range(0, len(usernames)):
			if i != len(usernames)-1:
				usernames_text = usernames_text + usernames[i] + ", "
			else:
				usernames_text = usernames_text + usernames[i] + ".\n"

	if len(hastags) > 0:
		hastags_text = "Hastags: "

		for i in range(0, len(hastags)):
			if i != len(hastags)-1:
				hastags_text = hastags_text + hastags[i] + ", "
			else:
				hastags_text = hastags_text + hastags[i] + ".\n"

	if len(webs) > 0:
		webs_text = "Webs: "

		for i in range(0, len(webs)):
			if i != len(webs)-1:
				webs_text = webs_text + webs[i] + ", "
			else:
				webs_text = webs_text + webs[i] + ".\n"

	text = "Text: " + text + "\n" + usernames_text + hastags_text + webs_text
	print(text)

def main():
	text = '@helloworld'
	handle_detector(text)

	text = '@helloworld2022'
	handle_detector(text)

	text = 'Hello World, username @helloworld hello'
	handle_detector(text)

	text = 'Hello World, username @helloworld2022 hello'
	handle_detector(text)

	text = 'Hello World, username @helloworld2022 hello @hello20 bye'
	handle_detector(text)

	text = 'Hello World'
	handle_detector(text)

	text = '#Helloworld'
	handle_detector(text)

	text = '#Helloworld2022'
	handle_detector(text)

	text = 'Hello World, username #helloworld hello'
	handle_detector(text)

	text = 'Hello World, username #helloworld2022 hello'
	handle_detector(text)

	text = 'Hello World, username #helloworld2022 hello #hello20 bye'
	handle_detector(text)

	text = '@helloworld #helloworld'
	handle_detector(text)

	text = '@helloworld2022 #helloworld2022'
	handle_detector(text)

	text = '3helloworld2022 @helloworld2022'
	handle_detector(text)

	text = 'Hello World, username #helloworld2022 hello @hello20 bye'
	handle_detector(text)

	text = 'www.mouredev.com'
	handle_detector(text)

	text = 'https://www.mouredev.com'
	handle_detector(text)

	text = 'http://adviento.dev'
	handle_detector(text)

	text = 'httpk://adviento.dev'
	handle_detector(text)

	text = 'www.mouredev.com hello https://google.com'
	handle_detector(text)

	text = 'Hello World, username #helloworld2022 hello @hello20 bye https://adviento.dev bye'
	handle_detector(text)

	text = 'My username @helloworld hastag #helloworld website https://mouredev.com thanks'
	handle_detector(text)

	text = '@helloworld2022 #helloworld2022 Hello World! 2www.hello.com222'
	handle_detector(text)

	text = '3helloworld2022 ww@helloworld2022 http://adviento.dev @retos #mouredev @python'
	handle_detector(text)

	text = 'Hello World, username #helloworld2022 hello @hello20 https://retosdeprogramacion.com/semanales2022 #python #JAVA #XMAS @python.com'
	handle_detector(text)

	text = 'MoureDev @mouredev, https://moure.dev/, #RETOS https://retosdeprogramacion.com/, #CALENDARIO https://adviento.dev/ @mouredev'
	handle_detector(text)

	text = 'http://adviento.dev23'
	handle_detector(text)

	text = '2022@helloword dddddhttp://adviento.dev23 21313#python'
	handle_detector(text)

	text = '2022@hellowordhttp://adviento.dev2321313#python'
	handle_detector(text)

if __name__ == '__main__':
	main()