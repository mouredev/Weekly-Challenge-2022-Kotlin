"""
  Reto #9
  CÓDIGO MORSE
  Fecha publicación enunciado: 02/03/22
  Fecha publicación resolución: 07/03/22
  Dificultad: MEDIA
 
  Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
  - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
  - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
  - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 
  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""


import re


def morse(texto):
    nuevo_texto = ""
    caracteres = {"a":".-", "b":"-...", "c":"-.-.", "d":"-..", "e":".",
              "f":"..-.", "g":"--.", "h":"....", "i":"..", "j":".---",
              "k":"-.-", "l":".-..", "m":"--", "n":"-.", "o":"---",
              "p":".--.", "q":"--.-", "r":".-.", "s":"...", "t":"-",
              "u":"..-", "v":"...-", "w":".--", "x":"-..-", "y":"-.--",
              "z":"--..", "1":".----", "2":"..---", "3":"...--", "4":"....-",
              "5":".....", "6":"-....", "7":"--...", "8":"---..", "9":"----.", 
              "0":"-----"}


    #Si el texto es natural
    if re.search("[a-zA-Z]", texto) is not None:
       texto = texto.lower()
       for letra in texto:
          if letra in caracteres:
            nuevo_texto += caracteres[letra] + "/"
          elif letra == " ":
             nuevo_texto += "/"


    #Si el texto es morse
    else:
      texto = texto.split("/")
      for palabra in texto:
        if palabra == "":
           nuevo_texto += " "
        if palabra in caracteres.values():
           nuevo_texto += {caracter for caracter in caracteres if caracteres[caracter] == palabra}.pop()

    return nuevo_texto


texto = "Hola, buenas tardes, estoy traduciendo un texto"
texto2 = "..../---/.-../.-//-.../..-/./-./.-/...//-/.-/.-./-.././...//./.../-/---/-.--//-/.-./.-/-../..-/-.-./.././-./-../---//..-/-.//-/./-..-/-/---/"
print(morse(texto))
print(morse(texto2))
