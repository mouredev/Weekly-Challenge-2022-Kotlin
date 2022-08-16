# package com.mouredev.weeklychallenge2022

# /*
#  * Reto #33
#  * CICLO SEXAGENARIO CHINO
#  * Fecha publicación enunciado: 15/08/22
#  * Fecha publicación resolución: 22/08/22
#  * Dificultad: MEDIA
#  *
#  * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
#  * en el ciclo sexagenario del zodíaco chino.
#  * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
#  * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
#  *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
#  *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
#  * - Cada elemento se repite dos años seguidos.
#  * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
#  *
#  */

" To run the script do 'ruby Challenge33.rb' on this file folder "

def chinese_zodiac(year)

    animals = ['rata', 'buey', 'tigre', 'conejo', 'dragón', 'serpiente', 'caballo', 'oveja', 'mono', 'gallo', 'perro', 'cerdo']
    elements = ['madera', 'fuego', 'tierra', 'metal', 'agua']

    "Your year is #{year}, therefore your Chinese Zodiac corresponds to: #{animals[((year - 1924) % 60) % 12]} #{elements[(((year - 1924) % 60) % 10)/2]}"
end

p "Insert a year:"
year = gets.chomp

while true
    if year.to_i.to_s == year
        if year.to_i < 1924
            p "Err: Selected year is less than 1924, therefore, not a valid year"
            p "Please, insert another year again:"
            year = gets.chomp
            next
        end
        p chinese_zodiac(year.to_i)
        break
    else
        p "Err: Selected year is not an Integer, therefore, not a valid year"
        p "Please, insert the year again:"
        year = gets.chomp
    end
end