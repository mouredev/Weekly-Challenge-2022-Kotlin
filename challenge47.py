
#LeonardoReichert@Github.com
#RearlanFDX@Twitch


"""

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

Resultado de la ejecucion:
Testing challenge MoureDev..
Text: "rty" have max vocal ""
Text: "Hola MoureDev" have max vocal "e"
Text: "aaaaeeeoooooii" have max vocal "o"
Text: "ThisIsATestForChallenge" have max vocal "e"
Text: "more more ore ore wana wana wona aaa" have max vocal "a"

"""



def maxVocal(text):
    
    VOCALS = "aeiou"

    #dejamos solo las vocales en una lista:
    findedVocals = [char for char in text.lower() if char in VOCALS]
    if not findedVocals:
        #no hay vocales
        return "";

    #hacemos un juego de vocales no repetidas:
    theVocals = list(set(findedVocals));

    #hacemos una cuenta, para cada vocal hallada:
    counts = [findedVocals.count(char) for char in theVocals]
    
    #elegimos el indice de la cuenta maxima en counts:
    indexOfMax = counts.index(max(counts))

    return theVocals[indexOfMax]



#solo ejecutar si no se llama como un modulo:
if __name__ == "__main__":
    test_texts = [
        "rty",
        "Hola MoureDev",
        "aaaaeeeoooooii",
        "ThisIsATestForChallenge",
        "more more ore ore wana wana wona aaa",
        ];
    
    print("Testing challenge MoureDev..");

    for text in test_texts:
        print('Text: "%s" have max vocal "%s"' % (text, maxVocal(text)) );









