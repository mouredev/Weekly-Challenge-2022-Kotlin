# RETO 34 - NUMEROS PERDIDOS
# Enunciado: Dado un array de enteros ordenado y sin repetidos, 
# crea una funcion que calcule y retorne todos los que faltan entre
# el mayor y el menor.
# - Lanza un error si el array de entrada no es correcto.

missingNumbers <- function(numbers) {  
  if (all(numbers == sort(numbers)) & sum(duplicated(numbers)) < 1) {    
    minNumbers = min(numbers)    
    maxNumbers = max(numbers)    
    minToMax = c(minNumbers:maxNumbers)    
    missing = setdiff(minToMax, numbers)     
    print("Los elementos faltantes son:")
    print(missing)
  }
  else
    print("ERROR: El array ingresado no es correcto")
}

missingNumbers(c(2,5,7,9,11,13,15,17,19,20))
