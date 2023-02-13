 # Crea una función que reciba dos cadenas como parámetro (str1, str2)
 # e imprima otras dos cadenas como salida (out1, out2).
 #- out1 contendrá todos los caracteres presentes en la str1 pero NO
 #  estén presentes en str2.
 #- out2 contendrá todos los caracteres presentes en la str2 pero NO
 #  estén presentes en str1.

# Hora de inicio 19:20
# Hora de cierre 19:30
 ## Cumplido ✅



 def avoid_char_repeated(str1,str2)
    str1_splited = str1.split("")
    str2_splited = str2.split("")
    
    out1 = str1_splited-str2_splited
    out2 = str2_splited-str1_splited
    print ["out1"=>out1,"out2"=>out2];
 end


print avoid_char_repeated("hola", "void") # ["hla","vid"]