# package com.mouredev.weeklychallenge2022

# /*
#  * Reto #42
#  * CONVERSOR DE TEMPERATURA
#  * Fecha publicación enunciado: 17/10/22
#  * Fecha publicación resolución: 24/10/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
#  * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
#  * - En caso contrario retornará un error.
#  * - ¿Quieres emplear lo aprendido en este reto?
#  *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */


try:
    a=input("Escribe la temperatura a covertir: \n")
    if "°C" in a or "°F" in a or "°c" in a or "°f" in a:
        if "°C" in a or "°c" in a:
            F=int(a[:-2])
            F=(F * 9/5) + 32 
            print(f'{float(F)} °F')
        if "°F" in a or "°f" in a:
            C=int(a[:-2])
            C=(C - 32) * 5/9 
            print(f'{float(C)} °C')
    else:
        TypeError:print("Error - Introduzca la temperatura a convertir con su respectiva unidad °C o °F")

except  TypeError: 
    print("Introduzca la temperatura a convertir con su respectiva unidad °C o °F")