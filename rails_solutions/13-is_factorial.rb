 # Escribe una función que calcule y retorne el factorial 
 # de un número dado de forma recursiva.

# Hora de inicio 19:23
# Hora de inicio 19:49

def is_factorial(number)
    return [*1..number].inject(:*)
end
 
 
 print is_factorial(1)  # 1
 print is_factorial(5)  # 120
 print is_factorial(7)  # 5040