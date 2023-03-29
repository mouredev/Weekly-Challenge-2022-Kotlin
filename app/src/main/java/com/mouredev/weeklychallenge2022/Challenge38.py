#
#Reto #38
#BINARIO A DECIMAL
#Fecha publicación enunciado: 19/09/22
#Fecha publicación resolución: 27/09/22
#Dificultad: MEDIA
#
#Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
#funciones propias del lenguaje que lo hagan directamente.
#
#Información adicional:
#- Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  para preguntas, dudas o prestar ayuda a la comunidad.
#- Tienes toda la información sobre los retos semanales en
#  https://retosdeprogramacion.com/semanales2022.
#
#

def binToDec(bin):
    i = len(bin) - 1
    dec = 0

    for p in bin:
        dec += int(p) * 2 ** i
        i = i - 1

    return dec
    
print("Result:", binToDec("101"))
print("Result:", binToDec("1011011"))
print("Result:", binToDec("1000011101"))
