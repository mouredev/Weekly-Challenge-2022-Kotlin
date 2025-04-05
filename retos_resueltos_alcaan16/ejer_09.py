"""
#9-CÓDIGO MORSE
/*
 * Crea un programa que sea capaz de transformar texto natural a código
 * morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar
 *   la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
 *   o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en
 *   https://es.wikipedia.org/wiki/Código_morse.
 */

"""

def traductor(texto):
    
    #definimos el diccionario de morse
    morse = {"A":".-","B":"-...","C":"-.-.","D":"-..","E":".","F":"..-.","G":"--.","H":"....",
            "I":"..","J":".---","K":"-.-","L":".-..","M":"--","N":"-.","Ñ":"--.--","O":"---",
            "P":".--.","Q":"--.-","R":".-.","S":"...","T":"-","U":"..-","V":"...-","W":".--",
            "X":"-..-","Y":"-.--","Z":"--..","0":"-----","1":".----","2":"..---","3":"...--",
            "4":"....-","5":".....","6":"-....","7":"--...","8":"---..","9":"----.",".":".-.-.-",
            ",":"--..--","?":"..--..",'"':".-..-.","/":"-..-.", " ":"  "}

    #comprobamos si es morse o natural
    if texto[0] == "-" or texto[0] == "." :

        print ("es morse")
        texto_nuevo = texto.split() #la cadena de texto la convierte en una lista
        
        for x in texto_nuevo: #recorremos la lista comparandola con el diccioneario
            for clave in morse:
                if morse[clave] == x:
                    print(clave,end="") #imprime la palabra y al terminar no salta de linea
    else:
        print ("es natural")
        texto_may = texto.upper() #mayusculas
        palabra = ""
        for letra in texto_may: #recorre el dicionario buscando las coincidencias
            palabra += morse[letra]
            palabra += " "
        print (palabra)

#traductor ("esto es la autentica prueba")
traductor (". ... - ---  . ...  .-.. .-  .- ..- - . -. - .. -.-. .-  .--. .-. ..- . -... .- .-.-.")

""" otra solucion
        
        for caracter in texto:
            if caracter != " ":
                letra += caracter
                
        for x in morse:
            if morse[x] == letra:
                print (x)
                break
        

def codigo_morse(texto):
    morse = {"A":".-","B":"-...","C":"-.-.","D":"-..","E":".","F":"..-.","G":"--.","H":"....",
            "I":"..","J":".---","K":"-.-","L":".-..","M":"--","N":"-.","Ñ":"--.--","O":"---",
            "P":".--.","Q":"--.-","R":".-.","S":"...","T":"-","U":"..-","V":"...-","W":".--",
            "X":"-..-","Y":"-.--","Z":"--..","0":"-----","1":".----","2":"..---","3":"...--",
            "4":"....-","5":".....","6":"-....","7":"--...","8":"---..","9":"----.",".":".-.-.-",
            ",":"--..--","?":"..--..",'"':".-..-.","/":"-..-.", " ":"  "}

    natural = '.-'

    if texto[0] in natural:
        codigo = texto.split()
        for i in codigo:
            for clave in morse:
                if morse[clave] == i:
                    print(clave,end="")
        print()
    else:
        textom = texto.upper()
        for i in textom:
            print(morse.get(i),end=" ")
        print()

def main():
    codigo_morse("..-. . .-.. .. --..    -. .- ...- .. -.. .- -..")
    codigo_morse("Feliz Navidad")

main()
"""