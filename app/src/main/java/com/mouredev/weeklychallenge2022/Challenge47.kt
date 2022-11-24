package com.mouredev.weeklychallenge2022

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
def vocal_comun(texto):
  texto_min=texto.lower()
  vocales={'a':0, 'e':0, 'i':0, 'o':0,'u':0}
  for letra in texto_min:
    if letra in vocales.keys():
      vocales[letra]+=1
  max=0
  max_vocal=''
  for vocal,reps in vocales.items():
    if reps>max:
      max=reps
      max_vocal=vocal
  return max_vocal
