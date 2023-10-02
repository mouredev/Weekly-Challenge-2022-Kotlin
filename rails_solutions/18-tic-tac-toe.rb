# Crea una función que analice una matriz 3x3 compuesta por "X" y "O"
# y retorne lo siguiente:
# - "X" si han ganado las "X"
# - "O" si han ganado los "O"
# - "Empate" si ha habido un empate
# - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta.
#   O si han ganado los 2.
# Nota: La matriz puede no estar totalmente cubierta.
# Se podría representar con un vacío "", por ejemplo.

# Hora de inicio 19:12
# Hora de cierre 20:13


def tic_tac_toe(boardValues)

    winnerOptions = [
        [0,1,2],
        [0,3,6],
        [0,4,8],
        [1,4,7],
        [2,5,8],
        [2,4,6],
        [3,4,5],
        [6,7,8],
    ]

    promptMessage = ""
    isFail = false

    for indexWinner in winnerOptions do
        if (boardValues[indexWinner[0]]=="x" && boardValues[indexWinner[1]]=="x" && boardValues[indexWinner[2]]=="x" )
            if !promptMessage.empty?
             isFail  = true
            end
           promptMessage = "X is Winner" 
        end

        if (boardValues[indexWinner[0]]=="o" && boardValues[indexWinner[1]]=="o" && boardValues[indexWinner[2]]=="o" )
            if !promptMessage.empty?
             isFail = true
            end
           promptMessage = "O is Winner"  
        end
    end

    if (boardValues.count("x")!=4 && boardValues.count("x")!=5 || boardValues.count("o")!=4 && boardValues.count("o")!=5)
        isFail=true
    end

    puts isFail ? "Bad game, both options can't winners or has many options of a unique participant": promptMessage
end

 print tic_tac_toe(["x","x","x",
                    "x","o","o",
                    "o","x","o"])  # Ganador X 🏆 

 print tic_tac_toe(["o","o","o",
                    "x","x","o",
                    "o","x","x"])  # Ganador O 🏆

 print tic_tac_toe(["o","o","x",
                    "o","x","o",
                    "o","x","x"])  # Ganador O 🏆

 print tic_tac_toe(["o","o","x",
                    "o","x","o",
                    "x","x","o"])  # Ganador X 🏆

 print tic_tac_toe(["o","o","o",
                    "x","x","x",
                    "o","x","x"])  # Fail 💀
                    
 print tic_tac_toe(["o","o","o",
                    "o","x","o",
                    "x","x","o"])  # Fail 💀

 print tic_tac_toe(["o","o","x",
                    "o","x","x",
                    "o","o","x"])  # both winners, fail 💀


