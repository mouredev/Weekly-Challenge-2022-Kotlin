"""/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */"""
 
def cuenta_palabras (texto):
    texto = texto.lower()
    simbolos = {":":"",",":"","?":"","¿":"","!":"","¡":"","(":"",")":"",".":"","á": "a", "é": "e", "í": "i", "ó": "o", "ú": "u"}  
    for caracter in simbolos:
        if caracter in texto:
            texto = texto.replace(caracter, simbolos[caracter])
    texto = texto.split()
    for palabra in texto:
        contador = 0
        for i in texto:
            if palabra == i:
                contador += 1
        if contador == 1:
            print(f"La palabra '{palabra}' no se repite")
        else:
            print(f"La palabra '{palabra}' se repite {contador} veces")
            for j in texto:
                if palabra == j:
                    texto.remove(palabra)    
            


text = "Doña Uzeada de Ribera Maldonado de Bracamonte y Anaya era baja, rechoncha, abigotada. Ya no existia razon para llamar talle al suyo. Sus colores vivos, sanos, podian mas que el albayalde y el soliman del afeite, con que se blanqueaba por simular melancolias. Gastaba dos parches oscuros, adheridos a las sienes y que fingian medicamentos. Tenia los ojitos ratoniles, maliciosos. Sabia dilatarlos duramente o desmayarlos con recato o levantarlos con disimulo. Caminaba contoneando las imposibles caderas y era dificil, al verla, no asociar su estampa achaparrada con la de ciertos palmipedos domesticos. Sortijas celestes y azules le ahorcaban las falanges"
cuenta_palabras (text)