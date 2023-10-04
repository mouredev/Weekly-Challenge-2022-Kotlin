'''
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 '''
try:
    word1 = input("Inserta la primera palabra: ")
    word2 = input("Inserta la segunda palabra: ")

    if word1.isnumeric() or word2.isnumeric():
        raise ValueError("Las palabras no pueden contener números")
    elif word1 == word2:
        raise ValueError("Las palabras son iguales")
    
    if sorted(word1) == sorted (word2):
       print ("Son anagramas")
    else<:
        print("No son anagramas")

except ValueError as e:
    print("Existe un error:", e)