import re
"""
Crea un función que reciba un texto y retorne la vocal que más veces se repita.
Si no hay vocales podrá devolver vacío
"""

#Uso de regex por su simplicidad
#No se han tenido en cuenta las tildes
def max_vowel(text):

    text = text.lower() #Necesario para tener en cuenta las mayúsculas
    vowels = dict()
    
    #Creamos diccionario con vocales y el número de veces que se repite
    for letter in text:
        if re.match("[aeiou]",letter):
            try:
                vowels[letter] += 1
            except:
                vowels[letter] = 1
    
    #Comprobamos cuál es el mayor valor del diccionario
    try:
        mx = max(vowels.values())
    except:
        mx = 0
    
    #List comprehension que recoge la/s vocal/es que coinciden con el máximo valor
    list_max_vowels = [vowel for vowel, v in vowels.items() if v == mx]
    if not  list_max_vowels:
        return None
    else:
        return list_max_vowels

print(max_vowel("dfgh ghaf vceEwbc"))
print(max_vowel("dfgh gh"))