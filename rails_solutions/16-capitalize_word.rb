
# Crea una función que reciba un String de cualquier tipo y se encargue de
# poner en mayúscula la primera letra de cada palabra.
# - No se pueden utilizar operaciones del lenguaje que
#   lo resuelvan directamente.
# Hora de inicio 19:22
# Hora de cierre 19:31

def capitalize_words(sentence)
    arrayCapitalize=[]

    for word in sentence.tr('¿¡','').split(" ") do
       arrayCapitalize.push(word.capitalize())
    end

    return arrayCapitalize.join(" ")

end

 print capitalize_words("capitalize my expression")  # Capitalize My Expression
 print capitalize_words("¿hola      qué tal estás?")  # Hola Que Tal Estás?