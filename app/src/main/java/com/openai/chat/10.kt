package com.openai.chat

/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa en Kotlin que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 * Resuelto: Sí.
 * Iteracciones: 1
 * Explicación: Este programa utiliza una pila para almacenar los delimitadores abiertos que se encuentran en la expresión y luego verifica si estos se cierran en el orden correcto.
 *
 */

// función que verifica si una expresión está equilibrada
fun isBalanced(expression: String): Boolean {
    // pila para almacenar los delimitadores abiertos
    val stack = mutableListOf<Char>()

    // recorremos la expresión carácter por carácter
    for (char in expression) {
        when (char) {
            // si encontramos un delimitador abierto, lo agregamos a la pila
            '(', '{', '[' -> stack.add(char)

            // si encontramos un delimitador cerrado, verificamos si coincide con el último delimitador abierto en la pila
            ')' -> if (stack.isEmpty() || stack.removeAt(stack.lastIndex) != '(') return false
            '}' -> if (stack.isEmpty() || stack.removeAt(stack.lastIndex) != '{') return false
            ']' -> if (stack.isEmpty() || stack.removeAt(stack.lastIndex) != '[') return false
        }
    }

    // si todos los delimitadores se cierran de forma correcta, la pila debe estar vacía al final de la expresión
    return stack.isEmpty()
}


fun main() {
    // probamos nuestra función con algunas expresiones
    println(isBalanced("{ [ a * ( c + d ) ] - 5 }"))    // debe imprimir true
    println(isBalanced("{ a * ( c + d ) ] - 5 }"))      // debe imprimir false

    // Brais cases
    println(isBalanced("{a + b [c] * (2x2)}}}}"))               // false
    println(isBalanced("{ [ a * ( c + d ) ] - 5 }"))            // true
    println(isBalanced("{ a * ( c + d ) ] - 5 }"))              // false
    println(isBalanced("{a^4 + (((ax4)}"))                      // false
    println(isBalanced("{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }")) // false
    println(isBalanced("{{{{{{(}}}}}}"))                        // false
    println(isBalanced("(a"))                                   // false

    // Jaime cases
    println(isBalanced("{ [ a * ( c + d ) ] - 5 }"))    // true
    println(isBalanced("[()]{}{[()()]()}"))             // true
    println(isBalanced("{[{}{}]}[()]"))                 // true
    println(isBalanced("{{}{}}"))                       // true
    println(isBalanced("[]{}()"))                       // true
    println(isBalanced("a+2"))                          // true
    println(isBalanced("{ a * ( c + d ) ] - 5 }"))      // false
    println(isBalanced("{()}[)"))                       // false
    println(isBalanced("[(])"))                         // false
    println(isBalanced("{(})"))                         // false
    println(isBalanced("{"))                            // false
}

