"""
 Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
  - Ten cuidado con algunos casos especiales.
  - Si no hay vocales podrá devolver vacío. 
"""

def most_repeated_vowels(text):
    a, e, o, i, u = 0, 0, 0, 0, 0
    if "a" not in text and "e" not in text and "o" not in text and "i" not in text and "u" not in text:
        print("There are no vowels in text provided")
    else:
        for n in range(len(text)):
            if text[n].lower() == "a":
                a += 1
            elif text[n].lower() == "e":
                e += 1
            elif text[n].lower() == "o":
                o += 1
            elif text[n].lower() == "i":
                i += 1
            elif text[n].lower() == "u":
                u += 1
            else:
                continue

    values_dict = {'a': a, 'e': e, 'o': o, 'i': i, 'u': u}

    print(f"the most repeated vowels is '{max(values_dict, key=values_dict.get)}' with '{values_dict[max(values_dict, key=values_dict.get)]}' presences")

#most_repeated_vowels('sdfghjy')
most_repeated_vowels('rsedaaaioAa')
