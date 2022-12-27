#
#   Reto #25
#   PIEDRA, PAPEL, TIJERA
#   Fecha publicación enunciado: 20/06/22
#   Fecha publicación resolución: 27/06/22
#   Dificultad: MEDIA
#
#   Enunciado: Crea un programa que calcule quien gana más partidas al piedra, papel, tijera.
#   - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
#   - La función recibe un listado que contiene pares, representando cada jugada.
#   - El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
#   - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
#
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#
#


VALUES_GAMES = ["R", "r", "P", "p", "S", "s"]


def game(games: list[tuple]):
    score_player_one = 0
    score_player_two = 0

    for i in games:
        if type(i) != tuple or len(i) != 2:
            return "Error"

        if (i[0] not in VALUES_GAMES) or (i[1] not in VALUES_GAMES):
            return "Error"

        p1 = i[0].upper()
        p2 = i[1].upper()

        if p1 != i[1].upper():
            if (p1 == "R" and p2 == "S") or (p1 == "P" and p2 == "R") or (p1 == "S" and p2 == "P"):
                score_player_one += 1

            else:
                score_player_two += 1

    if score_player_one == score_player_two:
        return "Tie"

    elif score_player_one > score_player_two:
        return "Won Player 1"

    else:
        return "Won Player 2"


# Tests
print(game([("s", "P"), ("R", "R"), ("R", "P")]))
print(game([("r", "P"), ("p", "s"), ("p", "r")]))
print(game([("r", "P"), ("r", "s"), ("p", "r")]))
print(game([("S", "P"), ("P", "R"), ("R", "P"), "R"]))
print(game([("S", "P"), ("P", "R"), ("R", "P"), (1, 2)]))

# Results
# Tie
# Won Player 2
# Won Player 1
# Error
# Error
