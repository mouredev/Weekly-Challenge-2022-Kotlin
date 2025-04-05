"""
#10-EXPRESIONES EQUILIBRADAS
/*
 * Crea un programa que comprueba si los paréntesis, llaves y corchetes
 * de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran
 *   en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios.
 *   No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 */

"""

def comprobacion(expresion):

    #lista con los simbolos de apertura y cerrado
    open = []
    close = []
    
    #recorremos toda la expresion y la almacenamos en las listas correspondientes
    for i in expresion:
        if i == ("{") or i == ("(") or i == ("["):
            #index += 1
            #open [index] = i
            open.append(i)
        elif i == ("}") or i == (")") or i == ("]"):
            #index_2 += 1
            #close [index_2] = i
            close.append(i)
    
    #print (f"simdolos de open {open}")
    #print (f"simdolos de close {close}")
    
    #comprobamos las listas para encontrar diferencias
    balanceada = True
    if len(open) == len(close):
        x=0
        for z in open[::-1]: #recorre la lista de apertura al inverso
            print (x)
            print (z, close[x])
            if  z == "(" and close[x] != ")":
                print (z, x)
                print ("comprobacion ()")
                balanceada =False
                break

            elif  z == "{" and close[x] != "}":
                print ("comprobacion{}")
                balanceada =False
                break
                
            elif  z == "[" and close[x] != "]":
                print ("comprobacion[]")
                balanceada =False
                break
                
            x += 1
    else:
        balanceada = False

    print (f"la expresion es balanceada? {balanceada}")

comprobacion("{ [ a * ( c + d ) ] - 5 }")

comprobacion("{ a * ( c + d ) ] - 5 }")
