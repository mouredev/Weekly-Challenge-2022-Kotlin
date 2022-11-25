'''
*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 */
 '''
def is_prime(number:int):
  if number < 2:
    return False
  else:
    for index in range(2,number):
      if (number  % index==0):
        return False
    return True
for index in range(1,100):
  if(is_prime(index)):
    print(index)