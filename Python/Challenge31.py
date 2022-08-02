#
#  Reto #31
#  AÑOS BISIESTOS
#  Fecha publicación enunciado: 01/08/22
#  Fecha publicación resolución: 08/08/22
#  Dificultad: FÁCIL
#
#  Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
#  - Utiliza el menor número de líneas para resolver el ejercicio.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

def next_leap_years(year: int):
    leap_years = []
    year_check = year

    while len(leap_years) < 30:

        if year_check % 4 == 0 and (year_check % 100 != 0 or year_check % 400 == 0):
            leap_years.append(f"{year_check}")

        year_check += 1

    print(f"The next 30 leap years from {year} are: {', '.join(leap_years)}\n")


# Tests
next_leap_years(year=2022)
next_leap_years(year=1999)
next_leap_years(year=200)
next_leap_years(year=2070)

# Result Tests
# The next 30 leap years from 2022 are: 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072,
# 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, 2124, 2128, 2132, 2136, 2140, 2144

# The next 30 leap years from 1999 are: 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048,
# 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120

# The next 30 leap years from 200 are: 204, 208, 212, 216, 220, 224, 228, 232, 236, 240, 244, 248, 252, 256, 260, 264,
# 268, 272, 276, 280, 284, 288, 292, 296, 304, 308, 312, 316, 320, 324

# The next 30 leap years from 2070 are: 2072, 2076, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, 2124,
# 2128, 2132, 2136, 2140, 2144, 2148, 2152, 2156, 2160, 2164, 2168, 2172, 2176, 2180, 2184, 2188, 2192
