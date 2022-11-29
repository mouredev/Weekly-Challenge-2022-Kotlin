""" /*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */ """

from pwn import *
from time import sleep


def robot(mov: list[int]):

    direcction = 0
    x = 0
    y = 0
    progress = log.progress("Robot steps")
    step = 0

    for steps in mov:
        if type(steps) == int:
            if direcction == 0:
                y += steps
            elif direcction == 180:
                y += steps * -1
            elif direcction == 90:
                x += steps
            elif direcction == 270:
                x += steps * -1

            direcction = robot_direcction(direcction)
            step += 1
            total_steps = len(mov)

            progress.status(f"{step} de {total_steps}. X={x} Y={y}\n")
            sleep(2)

        else:
            print(f"\n[!] {steps} No es válido. Han de ser números enteros!!!\n")
            break


def robot_direcction(last_direcction: int):

    return 270 if last_direcction == 0 else last_direcction - 90


robot([10, 5, -2])
robot([10, 5, -2, 1, 5, -2, 10, 5, -2])
