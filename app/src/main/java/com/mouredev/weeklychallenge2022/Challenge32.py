
"""
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 ---
 """

def segundo_mayor(lista=list):
    mayor=0
    segundo_mayor=0 
    for i in lista:
        if i > mayor:
            segundo_mayor = mayor
            mayor= i
        else:
            if i >segundo_mayor:
                segundo_mayor=i
    return segundo_mayor
result = segundo_mayor([8 , 10 , 15 , 100, 2, 30, 5, 50, 1, 17 ,16])
print(result)
