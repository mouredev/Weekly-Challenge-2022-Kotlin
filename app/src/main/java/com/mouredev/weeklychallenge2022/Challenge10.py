"""/*
 * Crea un programa que comprueba si los paréntesis, llaves y corchetes
 * de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran
 *   en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios.
 *   No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 */"""

def expresion_equilibrada (cadena):
    llavea = corca = parea = llavec = corcc = parec = 0
    for caracter in cadena:
        if (caracter == "{"):
            llavea = llavea + 1
        elif (caracter == "["):
            corca = corca + 1
        elif (caracter == "("):
            parea = parea + 1
        elif (caracter == "}"):
            llavec = llavec + 1
        elif (caracter == "]"):
            corcc = corcc + 1
        elif (caracter == ")"):
            parec = parec + 1
    if (llavea + llavec) % 2 == 0 and (corca + corcc) % 2 == 0 and (corca + corcc) % 2 == 0:
        return True
    else:
        return False
          
print(expresion_equilibrada("{ [ a * ( c + d ) ] - 5 }"))
print(expresion_equilibrada("{ a * ( c + d ) ] - 5 }"))
print(expresion_equilibrada("[ a * ( c + d ) ] - 5"))
print(expresion_equilibrada("a * ( c + d ) - 5"))
