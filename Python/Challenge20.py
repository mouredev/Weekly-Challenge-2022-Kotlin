#
#  Reto #20
#  PARANDO EL TIEMPO
#  Fecha publicación enunciado: 16/05/22
#  Fecha publicación resolución: 23/05/22
#  Dificultad: MEDIA
#
#  Enunciado: Crea una función que sume 2 números y retorne su resultado pasados unos segundos.
#  - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
#  - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del
#    programa principal. Se podría ejecutar varias veces al mismo tiempo.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

# Ambas librerías son nativas de Python
import time
import asyncio


async def add_delayed(num1: int, num2: int, wait_time: int):
    """
    Corrutina que realiza la suma de 2 números y espera un tiempo determinado.
    """

    # Toma el tiempo de inicio de la tarea
    init_time = time.time()

    # Realiza la suma de los números
    add = num1 + num2

    # Espera el tiempo especificado
    await asyncio.sleep(wait_time)

    # Toma el tiempo de finalización de la tarea
    finish_time = time.time()

    # Imprime el resultado y el tiempo que le tomó realizar la tarea en específico
    print(f"{num1} + {num2} = {add}. \tIt Took: {round(finish_time-init_time, 3)} seconds.")


async def main():
    """
    Función principal que realiza el llamado de las corrutinas.
    """
    # Realiza los test de llamado de las funciones.
    await asyncio.gather(
        add_delayed(1, 1, 5),
        add_delayed(5, 5, 3),
        add_delayed(10, 10, 1)
    )


if __name__ == "__main__":
    # Toma el tiempo inicial de ejecución
    init_time = time.time()

    # Da comienzo a la función Main
    asyncio.run(main())

    # Toma el tiempo final de ejecución
    finish_time = time.time()

    # Imprime el tiempo total de ejecución de los tests
    print(f"\nAll Excecution took: {round(finish_time - init_time, 3)} seconds.")


# Result Tests

# 10 + 10 = 20.   It Took: 1.013 seconds.
# 5 + 5 = 10.     It Took: 3.009 seconds.
# 1 + 1 = 2.      It Took: 5.01 seconds.

# All Excecution took: 5.014 seconds.
