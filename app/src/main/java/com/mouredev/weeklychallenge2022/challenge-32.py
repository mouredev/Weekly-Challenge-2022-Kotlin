
'''
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
 */

 '''


my_list = [3,6,7,10,3,4,5,6,1,33,54,22,56,55,8,120,144,140]
my_list.sort()
second = my_list[len(my_list) -2]
print("the second bigger number is {}".format(second))

    