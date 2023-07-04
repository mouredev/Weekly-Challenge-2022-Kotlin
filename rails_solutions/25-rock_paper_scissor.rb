 # Crea un programa que calcule quien gana más partidas al piedra,
 # papel, tijera.
 # - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 # - La función recibe un listado que contiene pares, representando cada jugada.
 # - El par puede contener combinaciones de "R" (piedra), "P" (papel)
 #   o "S" (tijera).
 # - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 # Hora de inicio: 7:15
 # Hora de cierre: 7:32

 def rock_paper_scissor(hands)
    player1=0    
    player2=0    
    winner = "tie"


    for hand in hands do
        if hand[0]=="R"&& hand[1]=="S"
        player1+=1
        end

        if hand[0]=="S"&& hand[1]=="R"
            player2+=1
        end

        if hand[0]=="P"&& hand[1]=="R"
        player1+=1
        end
        
        if hand[0]=="R"&& hand[1]=="P"
        player2+=1
        end
        
        if hand[0]=="S"&& hand[1]=="P"
        player1+=1
        end

        if hand[0]=="P"&& hand[1]=="S"
        player2+=1
        end
    end

    if player1>player2
        winner="Winner is Player 1"
    end

    if player2>player1
        winner="Winner is Player 2 "
    end

    return winner
 end

puts rock_paper_scissor([["R","S"],["S","R"],["P","S"]]) # Player 2
puts rock_paper_scissor([["R","S"],["S","R"],["P","P"]]) # Tie
puts rock_paper_scissor([["R","S"],["S","R"],["S","P"]]) # Player 1