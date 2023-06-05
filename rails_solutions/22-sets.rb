 # Crea una función que reciba dos array, un booleano y retorne un array.
 # - Si el booleano es verdadero buscará y retornará los elementos comunes
 #   de los dos array.
 # - Si el booleano es falso buscará y retornará los elementos no comunes
 #   de los dos array.
 # - No se pueden utilizar operaciones del lenguaje que
 #   lo resuelvan directamente.
 #
 # Hora inicio: 19:00

 def sets_boolean(array1, array2, boolean)
    arrayAnswer=[]
    if boolean
    array1.each_with_index do |value, index|
        if value==array2[index]
           arrayAnswer.push(value) 
        end
    end
    else
    array1.each_with_index do |value, index|
        if value!=array2[index]
            arrayAnswer.push(value) 
            arrayAnswer.push(array2[index]) 
        end
    end
 end

 puts arrayAnswer.reject { |answer| answer.nil? }
end

 print sets_boolean([1,2,true,"a"],[1,2,false,"a"],true) # ✅ => [ 1,2,"a"]
 print sets_boolean([1,2,true,"a","c"],[1,2,false,"b"],false) # ✅ => [true, false, "a","b","c"]