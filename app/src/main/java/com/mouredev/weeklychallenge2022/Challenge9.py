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

def decoder(string: str) -> str:
    morse_dict = {"A":".-", "N":"-.",  "0":"-----",
        "B":"-...",  "Ñ":"--.--", "1":". ----",
        "C":"-.-.",  "O":"---",     "2":"..---",
        "CH":"----", "P":".--.",   "3":"...--",
        "D":"-..",    "Q":"--.-",   "4":"....-",
        "E":".",        "R":".-.",     "5":".....",
        "F":"..-.",  "S":"...",     "6":"-....",
        "G":"--.",    "T":"-",         "7":"--...",
        "H":"....",  "U":"..-",     "8":"---..",
        "I":"..",      "V":"...-",   "9":"----.",
        "J":".---",  "W":".--",     ".":".-.-.-",
        "K":"-.-",    "X":"-..-",   ",":"--..--",
        "L":".-..",  "Y":"-.--",   "?":"..--..",
        "M":"--",      "Z":"--..",   "\"":".-..-.",
        "/":"-..-.", " ":"  "
    }

    if re.search("[a-zA-Z]",string) != None:
        morse = ""

        for i in string.upper():
            morse += morse_dict[i] + " "

        return morse
    
    else:
        natural=""
        string = string.replace("    "," / ")
        string = string.split(" ")
        
        for i in string[0:-1]:
            if i == "/":
                natural += " "
            value = {j for j in morse_dict if morse_dict[j]==i}
            if len(value) != 0:
                natural += value.pop()

        return natural

if __name__=="__main__":
    print(decoder("Hola Mundo"))
    print(decoder(".... --- .-.. .-    -- ..- -. -.. --- "))





