#
#  Reto #21
#  CALCULADORA .TXT
#  Fecha publicación enunciado: 23/05/22
#  Fecha publicación resolución: 01/06/22
#  Dificultad: MEDIA
#
#  Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
#  - El .txt se corresponde con las entradas de una calculadora.
#  - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
#  - Soporta números enteros y decimales.
#  - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
#  - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
#  - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
#
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#

# Operadores Válidos
VALID_OPERATORS = ["+", "-", "*", "/"]


def read_file(path: str):
    """
    Función que lee un archivo y extrae las operaciones, números y operadores asociados.
    """

    # Variables
    list_operations = []
    numbers = []
    operators = []

    # Lee el archivo especificado y lo convierte en una lista
    with open(path, "r") as file:
        file_items = file.readlines()

    # Por cada item de la lista, le retira los caracteres de salto de línea de archivo txt.
    # Dependiendo si es un número o una operación lo agrega a una lista
    # Además se crea una lista adicional que contiene todos los elementos.
    for item in file_items:
        # Elimina caracteres especiales
        new_item = item.replace("\n", '')

        # Intenta pasar valor a float y lo ingresa a lista
        try:
            new_item = float(new_item)
            numbers.append(new_item)

        # Si no es posible pasar valor a float, verifica si el valor es string y no es vacío
        except:
            if new_item != "":
                operators.append(new_item)

        # Si el valor no es vacío lo ingresa a
        finally:
            if new_item != "":
                list_operations.append(new_item)

    return list_operations, numbers, operators


def calculator(path: str):
    """
    Función que toma los valores de una lista y realiza las operaciones en el orden que se ingresa.
    """
    # Obtiene el listado completo de las operaciones, los números involucrados y las operaciones
    total_list, number_list, oper_list = read_file(path=path)

    # Variables
    result = number_list[0]
    balanced_count = 0

    # Por cada caracter verifica si el total de lo ingresado en el archivo está equilibrado
    # ! Las reglas que he definido.
    # * No pueden ir 2 números seguidos
    # * No pueden ir 2 operaciones seguidas
    for char in total_list:
        if type(char) == float:
            balanced_count += 1

        # Verifica que los caracteres se encuentren en las operaciones válidas
        elif type(char) == str:
            if char in VALID_OPERATORS:
                balanced_count -= 1

        # Verifica la cuenta si está dentro de los parámetros
        if not 0 <= balanced_count <= 1:
            print(f"Error Aquí {char}")
            break

    # Si no se encuentra balanceada la operación, se retorna "error"
    if balanced_count != 1:
        return "Error"

    # Realiza cada operación del listado y la acumula en variable
    for i in range(len(oper_list)):

        if oper_list[i] == "+":
            result += number_list[i+1]

        elif oper_list[i] == "-":
            result -= number_list[i+1]

        elif oper_list[i] == "/":
            result /= number_list[i+1]

        elif oper_list[i] == "*":
            result *= number_list[i+1]

    # Imprime el resultado de la operación
    print(f"The result of file operations is '{result}'.")


# Test
calculator("Challenge21.txt")

# Result Test
# The result of file operations is '18.5'.
