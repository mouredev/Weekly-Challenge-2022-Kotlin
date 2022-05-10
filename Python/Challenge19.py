#
#  Reto #19
#  CONVERSOR TIEMPO
#  Fecha publicación enunciado: 09/05/22
#  Fecha publicación resolución: 16/05/22
#  Dificultad: FACIL
#  
#  Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en 
#             milisegundos.
#  
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar 
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  
# 

def time_to_milisecond(days: int, hours: int, minutes: int, second: int):
    """
    Función que convierte valores de tiempo, en milisegundos. No considera los valores dados como fecha, por ende no hay
    comprobación de ese formato.
    """
    # Si algñun valor dado es negativo, retorna None
    if days < 0 or hours < 0 or minutes < 0 or second < 0:
        return None

    # Variables
    conversion_list = [1000, 60, 60, 24]
    times = [days, hours, minutes, second]
    final_time = 0

    # Por cada formato de tiempo, realiza la conversión a milisegundos y la suma al tiempo final
    for time in times:

        # Variable de acumulación de tiempo
        accum_time = time

        # Por cada valor de conversión, realiza la multiplicación y acumulación del tiempo
        for conversion in conversion_list:
            accum_time *= conversion
        
        # El tiempo ya en milisegundos, lo acumula a la variable final
        final_time += accum_time

        # Retira el último valor de la lista de conversión. Es una conveniencia debido a que todos los valores no se
        # deben multiplicar por todos los valores de esa lista
        conversion_list.pop()
    
    return final_time


# Tests
print(time_to_milisecond(5, 10, 2, 10))     # -> 468130000
print(time_to_milisecond(20, 50, 90, 500))  # -> 1913900000
print(time_to_milisecond(60, 1, 1, 1))      # -> 5187661000
print(time_to_milisecond(0, 0, 1, 1))       # -> 61000
print(time_to_milisecond(-1, 0, 1, 1))      # -> None
