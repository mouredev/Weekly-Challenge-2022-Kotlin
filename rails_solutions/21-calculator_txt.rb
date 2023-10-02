
 # Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su
 # resultado e imprímelo.
 # - El .txt se corresponde con las entradas de una calculadora.
 # - Cada línea tendrá un número o una operación representada por un
 #   símbolo (alternando ambos).
 # - Soporta números enteros y decimales.
 # - Soporta las operaciones suma "+", resta "-", multiplicación "*"
 #   y división "/".
 # - El resultado se muestra al finalizar la lectura de la última
 #   línea (si el .txt es correcto).
 # - Si el formato del .txt no es correcto, se indicará que no se han
 #   podido resolver las operaciones.

 # Hora inicio: 19:09
 # Hora inicio: 19:23
 # Tiempo transcurrido: 23m

 def calculate_operation_file(file)
    file = File.open(file)
    fileString = file.readlines.map(&:chomp)
    puts eval(fileString.join)
 end

 print calculate_operation_file("Challenge21.txt") # -14 ✅