#
#   Reto #7
#   CONTANDO PALABRAS
#   Fecha publicación enunciado: 14/02/22
#   Fecha publicación resolución: 21/02/22
#   Dificultad: MEDIA
#  
#   Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas
#   ellas.
#   - Los signos de puntuación no forman parte de la palabra.
#   - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
#   - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
#  
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  

def has_punctuation(phrase: str) -> list:
    """
    Función que realiza la extracción de símbolos de puntuación de una frase, y separa en palabras.
    """

    # Símbolos de puntuación que serán eliminados
    punctuation_chars = [".", ",", ":", ";", "!", "¡", "?", "¿", "(", ")", "{", "}", "[", "]", "-"]
    new_word = ""

    for char in phrase:
        # Si el caracter en la frase se encuentra dentro del listado de puntuación, lo elimina
        if char in punctuation_chars:
            char = ""

        # Concatena el caracter en un String.
        new_word += char

    # El bucle For anterior, se pudo haber sustituido por:
    #
    # for _ in punctuation_chars:
    #   phrase = phrase.replace(_, "")
    # Return phrase.lower().split(" ")
    #

    return new_word.lower().split(" ")


def count_words(phrase: str):
    """
    Cuenta las palabras dentro de una frase, **Toma** en cuenta la acentuación, y las imprime en la consola.

    Ejemplo: 'Él' != 'El', por ende, son dos palabras distintas.
    """
    words_list = has_punctuation(phrase)
    count = {}

    for word in words_list:
        # Si la palabra no está en el diccionario de palabras, la añade con una repetición de 1.
        if word not in count:
            count[word] = 1
        # En caso de que exista en el diccionario, le añade una repetición.
        else:
            count[word] += 1

    # Imprime los resultados de conteo de palabras
    print("El conteo de palabras es: ")
    for register in count:
        print(f"{register}: {count[register]}")


# Run Test
count_words("Y así como suele decirse el gato al rato, el rato a la cuerda, la cuerda al palo; daba el arriero a Sancho, Sancho a la moza, la moza a él, el ventero a la moza")

# Result Test
# El conteo de palabras es:
# y: 1
# así: 1
# como: 1
# suele: 1
# decirse: 1
# el: 4
# gato: 1
# al: 2
# rato: 2
# a: 5
# la: 5
# cuerda: 2
# palo: 1
# daba: 1
# arriero: 1
# sancho: 2
# moza: 3
# él: 1
# ventero: 1

