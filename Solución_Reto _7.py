"""
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
"""
def count_words(n):
  # Ponemos minusculas la frase
  n = n.lower() 

  sign = [",",".",";","(",")"]

  # Quitamos los signos de puntuación
  for i in sign:
    n = n.replace(i,"")
  # Creamos lista con las palabras
  word_list = n.split(" ")
 
  # Bucle que cuenta si esa palabra aparece al menos 2 veces en la frase n
  for word in word_list:
    if n.count(word) > 1:
      n_occur = n.count(word)
      print(f'La palabra {word} se repite {n_occur} veces')
      n = n.replace(word,"")

count_words("Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev).")

### La palabra mi se repite 2 veces
### La palabra nombre se repite 2 veces
### La palabra es se repite 2 veces
### La palabra brais se repite 2 veces
### La palabra moure se repite 2 veces
