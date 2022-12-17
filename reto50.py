#
# Reto #50
# LA ENCRIPTACIÓN DE KARACA
# Fecha publicación enunciado: 12/12/22
# Fecha publicación resolución: 19/12/22
# Dificultad: FACIL
# Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto
# utilizando el algoritmo de encriptación de Karaca.
# (Debes buscar información sobre él)
#

class Karaca:
    def encriptar(texto):
        if (texto[-3:].lower() == "aca" and any(num.isdigit() for num in texto)) or any(num.isdigit() for num in texto):
            return texto

        return (texto[::-1].translate(texto[::-1].maketrans("aeiouáéíóúü", "01234012344")).lower() + "aca")

    def desencriptar(texto):
        if texto[-3:].lower() != "aca" or not any(num.isdigit() for num in texto):
            return texto

        texto = texto.rstrip("aca")
        return texto[::-1].translate(texto[::-1].maketrans("01234", "aeiou"))

def encripta(texto, modo):
    resultado = list()
    palabras = texto.split()
    
    if modo:
        for palabra in palabras:
            resultado.append(Karaca.encriptar(palabra))
    else:
        for palabra in palabras:
            resultado.append(Karaca.desencriptar(palabra))

    return " ".join(resultado)

if __name__ == "__main__":
    texto = "100 horas"
    print(encripta(texto, True))
    
    texto = "100 s0r3haca"
    print(encripta(texto, False))
    
