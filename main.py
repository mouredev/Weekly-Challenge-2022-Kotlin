import os

os.system("CLS")
num_leap_year = 0
leap_year = int(input("Introduzca un año. "))


while True:
    if leap_year % 4 == 0:
        if leap_year % 100 == 0 and leap_year % 400 != 0:
            print(leap_year, " no es un año bisiesto")
            leap_year += 1
            continue
        print(leap_year)
        num_leap_year += 1
        if num_leap_year == 30:
            break
    leap_year += 1
