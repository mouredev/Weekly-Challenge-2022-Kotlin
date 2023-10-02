 # Escribe una función que reciba un texto y retorne verdadero o
 # falso (Boolean) según sean o no palíndromos.
 # Un Palíndromo es una palabra o expresión que es igual si se lee
 # de izquierda a derecha que de derecha a izquierda.
 # NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 # Ejemplo: Ana lleva al oso la avellana.

# Hora de inicio 19:05
# Hora de inicio 19:21

 def is_palindrom(str)
    str = str.delete(".!¡,¿?(){}[]")
    return str.downcase.split(" ").join() == str.reverse().downcase().split(" ").join()
 end


print is_palindrom("hola")  # false 💀
print is_palindrom("Ana")  # True 👼
print is_palindrom("Ana lleva, al oso la avellana.")  # True 👼