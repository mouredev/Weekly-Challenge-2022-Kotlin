"""
Reto #10
EXPRESIONES EQUILIBRADAS
Fecha publicación enunciado: 07/03/22
Fecha publicación resolución: 14/03/22
Dificultad: MEDIA

Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
- Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
- Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
- Expresión balanceada: { [ a ( c + d ) ] - 5 }
- Expresión no balanceada: { a ( c + d ) ] - 5 }

Información adicional:
- Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
- Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
- Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
- Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""


def main():
    print(isBalanced("{a + b [c] (2x2)}}}}"))
    print(isBalanced("{ [ a ( c + d ) ] - 5 }"))
    print(isBalanced("{ a ( c + d ) ] - 5 }"))
    print(isBalanced("{a^4 + (((ax4)}"))
    print(isBalanced("{ ] a ( c + d ) + ( 2 - 3 )[ - 5 }"))
    print(isBalanced("{{{{{{(}}}}}}"))
    print(isBalanced("(a"))

def isBalanced(expression: str) -> bool:
    stack = list()

    for char in expression:
        if char == "[" or char == "{" or char == "(":
            stack.append(char)
            continue

        if char == "]":
            if len(stack) != 0:
                pop = stack.pop()
                if pop != "[":
                    return False
            else:
                return False

        elif char == "}":
            if len(stack) != 0:
                pop = stack.pop()
                if pop != "{":
                    return False
            else:
                return False

        elif char == ")":
            if len(stack) != 0:
                pop = stack.pop()
                if pop != "(":
                    return False
            else:
                return False
    
    if len(stack) == 0:
        return True
    else:
        return False
        
if __name__ == "__main__":
    main()