 # Escribe una función que calcule y retorne el factorial 
 # de un número dado de forma recursiva.

# Reto #14
# ¿ES UN NÚMERO DE ARMSTRONG?
# Dificultad: FÁCIL
#
# Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong 
# (o también llamado narcisista).
# Si no conoces qué es un número de Armstrong, debes buscar información al respecto.#

# Hora de inicio 19:20
# Hora de cierre 19:42

def is_amstrong(number) 
    powers=number.digits.length
    puts "The number is #{number} and is amstrong? #{number==number.digits.reverse.inject(0){ |sum, x| sum + x**powers}}"
end
 
 
 print is_amstrong(371)  # True
 print is_amstrong(375)  # false
 print is_amstrong(8208)  # True
 print is_amstrong(8223)  # False
 print is_amstrong(115132219018763992565095597973971522401) ## True
 print is_amstrong(115132219018763992565095597973971522403) ## False