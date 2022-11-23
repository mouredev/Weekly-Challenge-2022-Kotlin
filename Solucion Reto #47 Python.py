# /*
#  * Enunciado: Crea un función que reciba un texto y retorne la vocal que
#  * más veces se repita.
#  * - Ten cuidado con algunos casos especiales.
#  * - Si no hay vocales podrá devolver vacío. 
#  */

text = input('Ingresa un texto: ').upper()

vowels = ['A','E','I','O','U']

count = [0,0,0,0,0,]

# Add to count the quantity of times tha a vowel is repited
for word in text:
    for vowel in vowels:
        if word == vowel:
            position = vowels.index(vowel)
            count[position] += 1

           

# in case of more than 1 vowel repited de same number of times
max_vowels = []
print('max =>',max(count))
for c in range(len(count)):
    print(c,' ==> ',vowels[c],' ==> cant:',count[c])
    if count[c] == max(count):
        max_vowels.append(vowels[c])

        
# Show the information    
print(text)
if len(max_vowels) > 1:
    print(f'Las letras que mas se repiten son {max_vowels} y se repiten {max(count)} veces')
else:
    print(f'la letra que mas se repite es {max_vowels}  y se repite {max(count)} veces')