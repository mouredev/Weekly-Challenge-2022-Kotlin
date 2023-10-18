'''
*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean)
   según sean o no anagramas.
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
 */
 '''
def is_anagrama(word1: str, word2:str):
  word1 = word1.lower()
  word2 = word2.lower()
  print(word1, word2)
  if word2==word1:
    return False  
  elif len(word2)==len(word1):
      word1 = list(word1)
      #print(word1)
      word1.sort()
      #print(word1)
      word2 = list(word2)
      #print(word2)
      word2.sort()
      #print(word2)
      word1 = "".join(word1)
      #print(word1)
      word2 = "".join(word2)
      #print(word2)
      if word1==word2:
        return True
      else:
        return False      
  else:
    return False

print(is_anagrama("moras","amor"))

def is_anagrama_optimizado(word1: str, word2:str):
  if word2==word1:
    return False  
  return sorted(word1.lower())==sorted(word2.lower())

print(is_anagrama_optimizado("mora","amor"))