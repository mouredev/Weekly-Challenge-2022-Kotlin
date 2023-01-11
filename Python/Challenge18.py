# 
#  Reto #18
#  TRES EN RAYA
#  Fecha publicación enunciado: 02/05/22
#  Fecha publicación resolución: 09/05/22
#  Dificultad: DIFÍCIL
#  
#  Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
#  - "X" si han ganado las "X"
#  - "O" si han ganado los "O"
#  - "Empate" si ha habido un empate
#  - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
#  Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
#  
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  
#

CHARS_ACCEPTED = ["X", "x", "O", "o", ""]


def count_chars(matrix: list[list[str]]):
    """
    Cuenta la cantidad de caracteres X e O. Además comprueba si se tiene los caracteres aceptados.
    """
    # Variables
    is_char_accepted = True
    count_O = 0
    count_X = 0
    count_blank = 0

    # Recorre la matriz por completo
    for row in matrix:
        for char in row:
            
            # Si el  caracter está permitido lo cuenta, en caso contrario no.
            if char in CHARS_ACCEPTED:
                if char.upper() == "O":
                    count_O += 1

                elif char.upper() == "X":
                    count_X += 1
                
                elif char == "":
                    count_blank += 1
            
            # Vuelve a False una bandera
            else:
                is_char_accepted = False
    
    # Si el tablero está completamente vacío, se considera como caracteres no aceptados.
    if count_blank == 9:
        is_char_accepted = False
    
    return is_char_accepted, count_O, count_X


def row_check(matrix: list[list[str]]):
    """
    Función que chequea las respuestas de una fila en una matriz.
    """
    win_X = False
    win_O = False

    # Recorre las filas de la matriz y cuenta los caracteres
    for row in matrix:
        if row.count("X") == 3 or row.count("x") == 3:
            win_X = True
        
        if row.count("O") == 3 or row.count("o") == 3:
            win_O = True
    
    return win_X, win_O
    

def tic_tac_toe(matrix: list[list[CHARS_ACCEPTED]]):
    """
    Función principal del juego.
    """

    # Comprueba el número de filas de la matriz, si no corresponde, se retorna None
    if len(matrix) != 3:
        return None
    
    # Comprueba el número de columnas de la matriz, si no corresponde, se retorna None
    for row in matrix:
        if len(row) != 3:
            return None
    
    # Cuenta los caracteres y comprueba si son los caracteres aceptados
    is_char_accepted, count_O, count_X = count_chars(matrix)

    # Si hay caracteres que no son aceptados regresa None
    if not is_char_accepted:
        return None
    
    # Invierte las columnas en filas
    column_items = [[matrix[i][item] for i in range(3)] for item in range(3)]

    # Comprueba si hay ganadores en las filas y columnas
    win_X_row, win_O_row = row_check(matrix)
    win_X_col, win_O_col = row_check(column_items)

    # Obtiene las diagonales del tablero y las convierte a una matriz 3x2. Comprueba además si hay ganadores en las 
    # Diagonales.
    diagonal_matrix = [[matrix[i][i] for i in range(3)], [matrix[i][-i-1] for i in range(3)]]
    win_X_diag, win_O_diag = row_check(diagonal_matrix)

    # Crea una variable de ganadores por caracter de forma general
    win_O = win_O_col or win_O_row or win_O_diag
    win_X = win_X_col or win_X_row or win_X_diag

    # Si hubieron dos ganadores o la diferencia de turnos no es aceptado, retorna None
    if (win_O and win_X) or not  -1 <= (count_X - count_O) <= 1 or count_O == 0 or count_X == 0:
        return None
    
    # Si ganó O, retorna "O"
    elif win_O:
        return "O"
    
    # Si ganó X, retorna "X"
    elif win_X:
        return "X"
    
    # De otra manera, se denota como empate.
    else:
        return "Empate"


# Tests
tic_tac_toe([
    ["O", "X", "O"], 
    ["O", "X", "O"], 
    ["O", "X", "O"]]) # -> None

tic_tac_toe([
    ["O", "O", "X"], 
    ["O", "X", "O"], 
    ["X", "X", "O"]]) # -> X
    
tic_tac_toe([
    ["X", "X", "O"], 
    ["O", "O", "X"], 
    ["X", "O", "X"]]) # -> Empate

tic_tac_toe([
    ["x", "X", ""], 
    ["O", "O", "o"], 
    ["X", "O", "X"]]) # -> O

tic_tac_toe([
    ["", "", ""], 
    ["", "x", ""], 
    ["", "", ""]]) # -> None

tic_tac_toe([
    ["O", "o", "o"]]) # -> None
