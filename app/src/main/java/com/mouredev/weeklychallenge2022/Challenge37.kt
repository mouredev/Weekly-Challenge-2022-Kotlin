#package com.mouredev.weeklychallenge2022
#
#/*
# * Reto #37
# * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
# * Fecha publicación enunciado: 14/09/22
# * Fecha publicación resolución: 19/09/22
# * Dificultad: MEDIA
# *
# * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
# * y se lanzará el 12 de mayo de 2023.
# * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
# * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
# * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
# *   puedes usar el mes, o incluso inventártelo)
# *
# * Información adicional:
# * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
# *   para preguntas, dudas o prestar ayuda a la comunidad.
# * - Tienes toda la información sobre los retos semanales en
# *   https://retosdeprogramacion.com/semanales2022.
# *
# */
#
# 11 de noviembre de 1998 -> the legend of zelda - ocarina of time
# 12 de mayo de 2023 -> the legendo of zelda - Tears of the Kingdom 

from datetime import datetime

def getDifference(date1, date2 = datetime.now(), interval = "secs"):
    duration = date2 - date1
    duration_in_s = duration.total_seconds()
    yr_ct = 365 * 24 * 60 * 60
    month_ct = 12 * 24 * 60 * 60
    day_ct = 24 *60 * 60
    hour_ct = 60 * 60
    minute_ct = 60

    def Years():
        return divmod(duration_in_s, yr_ct)[0]
    def Month():
        return divmod(duration_in_s, month_ct)[0]
    def Days():
        return divmod(duration_in_s, day_ct)[0]
    def Hours():
        return divmod(duration_in_s, hour_ct)[0]
    return {
        'Years': int(Years()),
        'Month': int(Month()),
        'Days': int(Days()),
        'Hours': int(Hours())
    }[interval]
    
juego1 = ("The leyend of zelda - Ocarina of Time")
juego2 = ("The leyend of zelda - Tears of the Kingdom")
date1 = datetime(1998, 10, 11, 00, 00, 00)
date2 = datetime(2023, 5, 12, 00, 00, 00)

print(" - La diferencia entre", juego1, "y", juego2, "es : Años -> ", getDifference(date1, date2, "Years"))
print(" - La diferencia entre", juego1, "y", juego2, "es : Meses -> ", getDifference(date1, date2, "Month"))
print(" - La diferencia entre", juego1, "y", juego2, "es : Dias -> ", getDifference(date1, date2, "Days"))
print(" - La diferencia entre", juego1, "y", juego2, "es : Horas -> ", getDifference(date1, date2, "Hours"))
=======
package com.mouredev.weeklychallenge2022

/*
 * Reto #37
 * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
 * Fecha publicación enunciado: 14/09/22
 * Fecha publicación resolución: 19/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
 * y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
 *   puedes usar el mes, o incluso inventártelo)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
