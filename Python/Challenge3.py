# 
#  Reto #3
#  ¿ES UN NÚMERO PRIMO?
#  Fecha publicación enunciado: 17/01/22
#  Fecha publicación resolución: 24/01/22
#  Dificultad: MEDIA
#  
#  Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
#  Hecho esto, imprime los números primos entre 1 y 100.
#  
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  
# 

def isPrimeNumber(number:int) -> bool:
  """
  Para [2,number) se verifica si el número es divisible por otro número
  que no sea 1 o sí mismo. De serlo, Return -> False.
  """
  is_prime = True
  
  for i in range(2, number):
    if (number % i) == 0:
        is_prime = False
  
  return is_prime


# Pregunta un número para comprobar si es primo, e imprime una respuesta
valueNumber = int(input("¿Qué número desea comprobar?: "))

if isPrimeNumber(valueNumber):
  print(f"{valueNumber} es primo")
else:
  print(f"{valueNumber} no es primo")


# Imprime los número primos hasta 100
print("\nNúmeros primos hasta el 100")
for i in range(2,100):
  isPrime = isPrimeNumber(i)

  if isPrime:
    print(i)