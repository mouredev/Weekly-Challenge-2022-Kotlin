#
# Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra
# que calcule el mínimo común múltiplo (mcm) de dos números enteros.
# - No se pueden utilizar operaciones del lenguaje que 
#   lo resuelvan directamente.
# Hora inicio: 19:12

 def get_greatest_common_divisor(num1,num2)
    divisors_without_residuals=[]
    divisors_without_residuals_to_num2=[]

    for value in 1..num1 do
      if num1 % value == 0
       divisors_without_residuals.push(value) 
      end
    end

    for value in 1..num2 do
      if num2 % value == 0
       divisors_without_residuals_to_num2.push(value) 
      end
    end

    values_equal =  divisors_without_residuals - divisors_without_residuals_to_num2
    puts "Greatest common divisor between #{num1} & #{num2} is #{values_equal.max()}"
 end

 def get_least_common_multiple(num1,num2)
    multiples_num1=[]
    multiples_num2=[]

    for value in 1..10 do
      multiples_num1.push(value*num1)
    end

    for value in 1..10 do

      multiples_num2.push(value*num2)
    end
      values_equal = multiples_num1 & multiples_num2
    puts "Least common multiple between #{num1} & #{num2} is #{values_equal.min()}"
 end


print get_greatest_common_divisor(15,20) 
print get_least_common_multiple(4,5) 